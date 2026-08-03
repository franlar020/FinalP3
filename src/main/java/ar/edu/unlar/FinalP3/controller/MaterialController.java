package ar.edu.unlar.FinalP3.controller;

import ar.edu.unlar.FinalP3.dto.MaterialResponseDTO;
import ar.edu.unlar.FinalP3.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
@RequiredArgsConstructor
public class MaterialController {

    private final PrestamoService service;

    @GetMapping("/disponibles")
    public ResponseEntity<List<MaterialResponseDTO>> obtenerDisponibles() {
        return ResponseEntity.ok(service.obtenerMaterialesDisponibles());
    }
}