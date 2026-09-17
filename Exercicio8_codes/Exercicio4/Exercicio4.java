package Exercicio8_codes.Exercicio4;

public class Exercicio4 {
        public static void main(String[] args) {

        // array da superclasse — guarda qualquer figura
        FiguraGeometrica[] figuras = {
            new Quadrado (4.0),
            new Retangulo(3.0, 5.0),
            new Circulo  (2.0),
            new Quadrado (7.5),
            new Retangulo(10.0, 2.5),
            new Circulo  (5.0)
        };

        System.out.println("===== Áreas das Figuras =====");

        double areaTotal = 0.0;

        // um único laço — polimorfismo resolve o tipo de cada figura
        for (FiguraGeometrica f : figuras) {
            f.exibirArea();
            areaTotal += f.calcularArea();
        }

        System.out.println("-----------------------------");
        System.out.printf("Área total: %.2f%n", areaTotal);
    }
}