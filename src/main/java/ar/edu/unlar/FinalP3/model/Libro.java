package ar.edu.unlar.FinalP3.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Libro extends Material {
    private String autor;

    public Libro(String codigo, String titulo, boolean disponible, String autor) {
        super(codigo, titulo, disponible);
        this.autor = autor;
    }
}