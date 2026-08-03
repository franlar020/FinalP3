package ar.edu.unlar.FinalP3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Socio {
    protected int id;
    protected String nombre;

    // Metodo clave para que cada tipo de socio calcule su propio costo
    public abstract double aplicarBeneficio(double monto);
}