package ar.edu.unlar.FinalP3.dto;

import lombok.Data;

@Data
public class DevolucionRequestDTO {
    private String codigoMaterial;
    private int idSocio;
    private int diasAtraso;
    private String tipoEstrategia; // "NORMAL", "CAMPANIA", "FIN_SEMANA"
}