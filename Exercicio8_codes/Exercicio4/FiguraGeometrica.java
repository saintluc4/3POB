package Exercicio8_codes.Exercicio4;

public class FiguraGeometrica {

    // contrato: toda figura sabe calcular sua área
    public double calcularArea() {
        return 0.0;
    }

    public void exibirArea() {
        System.out.printf("%-12s → Área: %.2f%n",
                          getClass().getSimpleName(), calcularArea());
    }
}