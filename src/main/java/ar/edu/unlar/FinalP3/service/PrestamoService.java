package ar.edu.unlar.FinalP3.service;

import ar.edu.unlar.FinalP3.dto.*;
import ar.edu.unlar.FinalP3.exception.BadRequestException;
import ar.edu.unlar.FinalP3.exception.ResourceNotFoundException;
import ar.edu.unlar.FinalP3.model.Libro;
import ar.edu.unlar.FinalP3.model.Material;
import ar.edu.unlar.FinalP3.model.Socio;
import ar.edu.unlar.FinalP3.repository.MaterialRepository;
import ar.edu.unlar.FinalP3.service.strategy.MultaStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final MaterialRepository repository;
    
    // Inyecto todas las estrategias disponibles directamente en un Map gracias a Spring
    private final Map<String, MultaStrategy> estrategiasMulta;

    public String prestarMaterial(PrestamoRequestDTO request) {
        // Valido que exista el material y el socio
        Material material = repository.buscarMaterialPorCodigo(request.getCodigoMaterial())
                .orElseThrow(() -> new ResourceNotFoundException("Material no encontrado"));
                
        repository.buscarSocioPorId(request.getIdSocio())
                .orElseThrow(() -> new ResourceNotFoundException("Socio no encontrado"));

        if (!material.isDisponible()) {
            throw new BadRequestException("El material ya se encuentra prestado");
        }

        // Lo marco como prestado
        material.setDisponible(false);
        return "Material prestado con exito";
    }

    public DevolucionResponseDTO devolverMaterial(DevolucionRequestDTO request) {
        Material material = repository.buscarMaterialPorCodigo(request.getCodigoMaterial())
                .orElseThrow(() -> new ResourceNotFoundException("Material no encontrado"));
                
        Socio socio = repository.buscarSocioPorId(request.getIdSocio())
                .orElseThrow(() -> new ResourceNotFoundException("Socio no encontrado"));

        if (material.isDisponible()) {
            throw new BadRequestException("El material no estaba prestado");
        }

        // Obtengo la estrategia correcta segun el JSON ("multaNormal", "multaCampania", etc.)
        MultaStrategy strategy = estrategiasMulta.get(request.getTipoEstrategia());
        if (strategy == null) {
            throw new BadRequestException("Estrategia de multa invalida");
        }

        // Calculo la multa base y luego le aplico el descuento del socio si corresponde
        double multaBase = strategy.calcular(request.getDiasAtraso());
        double multaFinal = socio.aplicarBeneficio(multaBase);

        // Vuelve a estar disponible en la biblioteca
        material.setDisponible(true);

        return new DevolucionResponseDTO("Material devuelto correctamente", multaFinal);
    }

    public List<MaterialResponseDTO> obtenerMaterialesDisponibles() {
        return repository.obtenerDisponibles().stream()
                .map(m -> new MaterialResponseDTO(
                        m.getCodigo(),
                        m.getTitulo(),
                        m instanceof Libro ? "LIBRO" : "REVISTA"
                ))
                .collect(Collectors.toList());
    }

    public DepurarDniResponseDTO depurarDnis(DepurarDniRequestDTO request) {
        // Uso HashSet para limpiar los duplicados en una sola pasada como pide la consigna
        Set<String> unicos = new HashSet<>(request.getDnis());
        
        return new DepurarDniResponseDTO(
                unicos,
                request.getDnis().size(),
                unicos.size()
        );
    }
}