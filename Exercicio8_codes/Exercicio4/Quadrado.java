package Exercicio8_codes.Exercicio4;

public class Quadrado extends FiguraGeometrica {

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() { return lado; }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}