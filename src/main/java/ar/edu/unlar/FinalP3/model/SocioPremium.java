package ar.edu.unlar.FinalP3.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SocioPremium extends Socio {

    public SocioPremium(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double aplicarBeneficio(double monto) {
        // Aplico el descuento del 50% que pide el profe
        return monto * 0.5;
    }
}