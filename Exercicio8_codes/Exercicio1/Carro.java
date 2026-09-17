package Exercicio8_codes.Exercicio1;

public class Carro extends Veiculo {

    private int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() { return quantidadePortas; }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.printf("Portas: %d%n", quantidadePortas);
        System.out.println("-----------------------------");
    }
}