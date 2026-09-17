package Exercicio8_codes.Exercicio4;

public class Circulo extends FiguraGeometrica {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() { return raio; }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }
}