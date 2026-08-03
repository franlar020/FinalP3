package ar.edu.unlar.FinalP3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class DepurarDniResponseDTO {
    private Set<String> dnisUnicos;
    private int cantidadOriginal;
    private int cantidadDepurada;
}