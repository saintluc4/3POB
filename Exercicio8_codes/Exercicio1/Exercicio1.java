package Exercicio8_codes.Exercicio1;

public class Exercicio1 {

    public static void main(String[] args) {

        Carro carro = new Carro("Toyota", "Corolla", 4);
        Moto  moto  = new Moto("Honda", "CB 500", 471);

        System.out.println("===== Carro =====");
        carro.exibirDetalhes();

        System.out.println("===== Moto =====");
        moto.exibirDetalhes();
    }
}