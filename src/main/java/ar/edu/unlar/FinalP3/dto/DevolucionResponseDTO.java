package ar.edu.unlar.FinalP3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DevolucionResponseDTO {
    private String mensaje;
    private double multaCalculada;
}