package Exercicio9_codes.Exercicio2;

public class Circulo extends Forma {
    private double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        if (!Double.isFinite(raio) || raio <= 0) {
            throw new IllegalArgumentException("Raio deve ser positivo e finito.");
        }
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
