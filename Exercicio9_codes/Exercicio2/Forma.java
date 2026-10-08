package Exercicio9_codes.Exercicio2;

public abstract class Forma {
    private String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    public abstract double calcularArea();

    public void exibirDetalhes() {
        System.out.printf("%s | Cor: %s | Area: %.2f%n",
                getClass().getSimpleName(), cor, calcularArea());
    }
}
