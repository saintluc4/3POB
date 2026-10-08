package Exercicio15_codes.Exercicio4;

import java.util.Arrays;
import java.util.List;

public class Exercicio4 {
    public static double somarAreas(List<? extends Figura> listaFiguras) {
        double total = 0;

        for (Figura figura : listaFiguras) {
            total += figura.calcularArea();
        }



        return total;
    }

    public static void main(String[] args) {
        List<Quadrado> quadrados = Arrays.asList(new Quadrado(2), new Quadrado(3));
        List<Circulo> circulos = Arrays.asList(new Circulo(1), new Circulo(2));
        List<Figura> figuras = Arrays.asList(new Quadrado(4), new Circulo(3));

        System.out.printf("Área dos quadrados: %.2f%n", somarAreas(quadrados));
        System.out.printf("Área dos círculos: %.2f%n", somarAreas(circulos));
        System.out.printf("Área das figuras: %.2f%n", somarAreas(figuras));
    }
}
