package Exercicio7_codes;

class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;


    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular     = titular;
        this.saldo       = 0.0;
    }


    public ContaBancaria(String numeroConta, String titular, double depositoInicial) {
        this(numeroConta, titular);
        depositar(depositoInicial);
    }


    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }


    public void setTitular(String titular) {
        this.titular = titular;
    }


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
        System.out.println("=============================");
        System.out.printf("Conta:    %s%n", numeroConta);
        System.out.printf("Titular:  %s%n", titular);
        System.out.printf("Saldo:    R$ %.2f%n", saldo);
        System.out.println("=============================");
    }
}

public class Exercicio2 {

    public static void main(String[] args) {


        ContaBancaria contaA = new ContaBancaria("001-2", "Ana Lima");


        ContaBancaria contaB = new ContaBancaria("002-8", "João Silva", 1000.00);

        System.out.println("===== Conta A =====");
        contaA.exibirExtrato();

        System.out.println("===== Conta B =====");
        contaB.exibirExtrato();


        System.out.println("\n-- Operações na Conta A --");
        contaA.depositar(500.00);
        contaA.depositar(-100.00);
        contaA.sacar(200.00);
        contaA.sacar(9999.00);
        contaA.exibirExtrato();


        System.out.println("-- Teste de imutabilidade --");
        System.out.printf("Número da conta A: %s%n", contaA.getNumeroConta());



        System.out.println("-- Alterando titular da Conta A --");
        contaA.setTitular("Ana Lima Santos");
        System.out.printf("Novo titular: %s%n", contaA.getTitular());
    }
}