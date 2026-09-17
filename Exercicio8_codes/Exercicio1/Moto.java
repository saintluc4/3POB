package Exercicio8_codes.Exercicio1;

public class Moto extends Veiculo {

    private int cilindradas;

    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() { return cilindradas; }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.printf("Cilindradas: %d cc%n", cilindradas);
        System.out.println("-----------------------------");
    }
}