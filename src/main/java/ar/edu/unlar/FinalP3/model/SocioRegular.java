package ar.edu.unlar.FinalP3.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SocioRegular extends Socio {
    
    public SocioRegular(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double aplicarBeneficio(double monto) {
        // El socio regular paga full, no le hago descuento
        return monto;
    }
}