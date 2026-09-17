package Exercicio8_codes.Exercicio1;

public class Veiculo {

    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca  = marca;
        this.modelo = modelo;
    }

    public String getMarca()  { return marca; }
    public String getModelo() { return modelo; }

    public void exibirDetalhes() {
        System.out.printf("Marca:  %s%n", marca);
        System.out.printf("Modelo: %s%n", modelo);
    }
}