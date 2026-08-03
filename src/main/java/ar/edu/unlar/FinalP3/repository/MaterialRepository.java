package ar.edu.unlar.FinalP3.repository;

import ar.edu.unlar.FinalP3.model.Libro;
import ar.edu.unlar.FinalP3.model.Material;
import ar.edu.unlar.FinalP3.model.Revista;
import ar.edu.unlar.FinalP3.model.Socio;
import ar.edu.unlar.FinalP3.model.SocioPremium;
import ar.edu.unlar.FinalP3.model.SocioRegular;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MaterialRepository {
    
    // Uso HashMap para busquedas O(1) super eficientes por codigo/ID
    private final Map<String, Material> materiales = new HashMap<>();
    private final Map<Integer, Socio> socios = new HashMap<>();

    public MaterialRepository() {
        // Cargo algunos datos iniciales para poder probar los endpoints de entrada
        Libro l1 = new Libro("L001", "Rayuela", true, "Julio Cortazar");
        Libro l2 = new Libro("L002", "Ficciones", false, "Jorge Luis Borges");
        Revista r1 = new Revista("R001", "National Geographic", true, 450);

        materiales.put(l1.getCodigo(), l1);
        materiales.put(l2.getCodigo(), l2);
        materiales.put(r1.getCodigo(), r1);

        Socio s1 = new SocioRegular(1, "Francisco Gonzalez");
        Socio s2 = new SocioPremium(2, "Juan Perez");

        socios.put(s1.getId(), s1);
        socios.put(s2.getId(), s2);
    }

    public Optional<Material> buscarMaterialPorCodigo(String codigo) {
        return Optional.ofNullable(materiales.get(codigo));
    }

    public Optional<Socio> buscarSocioPorId(int id) {
        return Optional.ofNullable(socios.get(id));
    }

    public List<Material> obtenerDisponibles() {
        List<Material> disponibles = new ArrayList<>();
        for (Material m : materiales.values()) {
            if (m.isDisponible()) {
                disponibles.add(m);
            }
        }
        return disponibles;
    }
}