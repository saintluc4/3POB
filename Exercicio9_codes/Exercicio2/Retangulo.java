package Exercicio9_codes.Exercicio2;

public class Retangulo extends Forma {
    private double largura;
    private double altura;

    public Retangulo(String cor, double largura, double altura) {
        super(cor);
        if (!Double.isFinite(largura) || !Double.isFinite(altura)
                || largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Dimensoes devem ser positivas e finitas.");
        }
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}
