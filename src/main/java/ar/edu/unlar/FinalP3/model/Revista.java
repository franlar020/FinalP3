package ar.edu.unlar.FinalP3.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Revista extends Material {
    private int numeroEdicion;

    public Revista(String codigo, String titulo, boolean disponible, int numeroEdicion) {
        super(codigo, titulo, disponible);
        this.numeroEdicion = numeroEdicion;
    }
}