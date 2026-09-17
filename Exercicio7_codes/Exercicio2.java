package Exercicio7_codes;

class ContaBancaria {

    private String numeroConta; // imutável — só getter
    private String titular;     // getter e setter
    private double saldo;       // sem setter — só via métodos operacionais

    // construtor base — saldo começa em zero
    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular     = titular;
        this.saldo       = 0.0;
    }

    // construtor sobrecarregado — com depósito inicial
    public ContaBancaria(String numeroConta, String titular, double depositoInicial) {
        this(numeroConta, titular); // chama o construtor base
        depositar(depositoInicial); // usa o método com validação
    }

    // ── Getters ───────────────────────────────────────────
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // ── Setter apenas para titular ────────────────────────
    public void setTitular(String titular) {
        this.titular = titular;
    }

    // ── Métodos operacionais — únicos que alteram o saldo ─
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

        // conta A — saldo inicial zero
        ContaBancaria contaA = new ContaBancaria("001-2", "Ana Lima");

        // conta B — com depósito inicial
        ContaBancaria contaB = new ContaBancaria("002-8", "João Silva", 1000.00);

        System.out.println("===== Conta A =====");
        contaA.exibirExtrato();

        System.out.println("===== Conta B =====");
        contaB.exibirExtrato();

        // operações na conta A
        System.out.println("\n-- Operações na Conta A --");
        contaA.depositar(500.00);
        contaA.depositar(-100.00); // inválido
        contaA.sacar(200.00);
        contaA.sacar(9999.00);     // saldo insuficiente
        contaA.exibirExtrato();

        // tentativa de alterar número da conta — impossível
        System.out.println("-- Teste de imutabilidade --");
        System.out.printf("Número da conta A: %s%n", contaA.getNumeroConta());
        // contaA.setNumeroConta("999"); → não compila, método não existe

        // alteração de titular via setter
        System.out.println("-- Alterando titular da Conta A --");
        contaA.setTitular("Ana Lima Santos");
        System.out.printf("Novo titular: %s%n", contaA.getTitular());
    }
}