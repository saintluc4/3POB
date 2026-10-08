package Exercicio15_codes.Exercicio3;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraEstatistica<T extends Number> {
    private List<T> numeros = new ArrayList<>();

    public void adicionar(T numero) {
        numeros.add(numero);
    }

    public double calcularMedia() {
        if (numeros.isEmpty()) {
            throw new IllegalStateException("Não é possível calcular a média de uma lista vazia.");
        }

        double soma = 0;
        for (T numero : numeros) {
            soma += numero.doubleValue();
        }
        return soma / numeros.size();
    }

    public double calcularMaior() {
        if (numeros.isEmpty()) {
            throw new IllegalStateException("Não existe maior valor em uma lista vazia.");
        }

        double maior = numeros.get(0).doubleValue();
        for (T numero : numeros) {
            maior = Math.max(maior, numero.doubleValue());
        }
        return maior;
    }
}
