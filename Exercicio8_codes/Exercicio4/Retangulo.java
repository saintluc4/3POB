package Exercicio8_codes.Exercicio4;

public class Retangulo extends FiguraGeometrica {

    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura  = altura;
    }

    public double getLargura() { return largura; }
    public double getAltura()  { return altura; }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}