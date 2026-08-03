package ar.edu.unlar.FinalP3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Material {
    // Uso protected para que los hijos puedan acceder si hace falta
    protected String codigo;
    protected String titulo;
    protected boolean disponible;
}