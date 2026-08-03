package ar.edu.unlar.FinalP3.controller;

import ar.edu.unlar.FinalP3.dto.DepurarDniRequestDTO;
import ar.edu.unlar.FinalP3.dto.DepurarDniResponseDTO;
import ar.edu.unlar.FinalP3.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/socios")
@RequiredArgsConstructor
public class SocioController {

    private final PrestamoService service;

    @PostMapping("/depurar-duplicados")
    public ResponseEntity<DepurarDniResponseDTO> depurarDuplicados(@RequestBody DepurarDniRequestDTO request) {
        return ResponseEntity.ok(service.depurarDnis(request));
    }
}