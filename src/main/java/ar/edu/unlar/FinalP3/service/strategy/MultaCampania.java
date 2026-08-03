package ar.edu.unlar.FinalP3.service.strategy;

import org.springframework.stereotype.Component;

@Component("multaCampania")
public class MultaCampania implements MultaStrategy {
    @Override
    public double calcular(int diasAtraso) {
        // Promo de $60 por dia
        return diasAtraso * 60.0;
    }
}