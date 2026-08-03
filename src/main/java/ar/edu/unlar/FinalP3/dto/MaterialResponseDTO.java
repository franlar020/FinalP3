package ar.edu.unlar.FinalP3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaterialResponseDTO {
    private String codigo;
    private String titulo;
    private String tipo; // "LIBRO" o "REVISTA"
}