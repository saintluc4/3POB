package Exercicio8_codes.Exercicio5;

public class Exercicio5 {

    public static void main(String[] args) {


        ContaPoupanca poupanca = new ContaPoupanca("001-7", 1000.00, 0.5);

        System.out.println("===== Operações — Poupança =====");
        poupanca.exibirExtrato();

        poupanca.depositar(500.00);
        poupanca.aplicarRendimento();
        poupanca.sacar(200.00);
        poupanca.sacar(9999.00);
        poupanca.exibirExtrato();


        ContaCorrente corrente = new ContaCorrente("002-3", 300.00, 500.00);

        System.out.println("===== Operações — Corrente =====");
        corrente.exibirExtrato();

        corrente.sacar(100.00);
        corrente.exibirExtrato();

        corrente.sacar(650.00);
        corrente.exibirExtrato();

        corrente.sacar(9999.00);
        corrente.exibirExtrato();
    }
}