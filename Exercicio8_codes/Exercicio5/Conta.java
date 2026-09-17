package Exercicio8_codes.Exercicio5;

public class Conta {

    private String numero;
    private double saldo;

    public Conta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo  = saldoInicial;
    }

    public String getNumero() { return numero; }
    public double getSaldo()  { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f efetuado.%n", valor);
        } else {
            System.out.println("Erro: valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f efetuado.%n", valor);
        } else {
            System.out.println("Erro: saldo insuficiente ou valor inválido.");
        }
    }

    public void exibirExtrato() {
        System.out.println("-----------------------------");
        System.out.printf("Conta:  %s%n", numero);
        System.out.printf("Saldo:  R$ %.2f%n", saldo);
        System.out.println("-----------------------------");
    }
}