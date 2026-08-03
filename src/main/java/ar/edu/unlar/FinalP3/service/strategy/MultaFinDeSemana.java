package ar.edu.unlar.FinalP3.service.strategy;

import org.springframework.stereotype.Component;

@Component("multaFinDeSemana")
public class MultaFinDeSemana implements MultaStrategy {
    @Override
    public double calcular(int diasAtraso) {
        // Cobro tarifa normal ($100 por dia) mas un recargo fijo de $200 al total
        return (diasAtraso * 100.0) + 200.0;
    }
}