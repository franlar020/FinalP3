package ar.edu.unlar.FinalP3.controller;

import ar.edu.unlar.FinalP3.dto.DevolucionRequestDTO;
import ar.edu.unlar.FinalP3.dto.DevolucionResponseDTO;
import ar.edu.unlar.FinalP3.dto.PrestamoRequestDTO;
import ar.edu.unlar.FinalP3.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService service;

    @PostMapping("/prestar")
    public ResponseEntity<String> prestar(@RequestBody PrestamoRequestDTO request) {
        return ResponseEntity.ok(service.prestarMaterial(request));
    }

    @PostMapping("/devolver")
    public ResponseEntity<DevolucionResponseDTO> devolver(@RequestBody DevolucionRequestDTO request) {
        return ResponseEntity.ok(service.devolverMaterial(request));
    }
}