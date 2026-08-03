package ar.edu.unlar.FinalP3.service.strategy;

import org.springframework.stereotype.Component;

@Component("multaNormal")
public class MultaNormal implements MultaStrategy {
    @Override
    public double calcular(int diasAtraso) {
        // Cobro $100 por dia
        return diasAtraso * 100.0;
    }
}