package Exercicio6_codes;
import java.util.Scanner;


class ContaBancaria {
    String titular;
    String numeroConta;
    double saldo = 0.0; // inicia em zero

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }
}

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria();

        System.out.print("Titular da conta: ");
        conta.titular = scanner.nextLine();

        System.out.print("Número da conta: ");
        conta.numeroConta = scanner.nextLine();

        System.out.printf("%n=== Conta de %s criada ===%n", conta.titular);
        conta.consultarSaldo();

        // teste válido
        System.out.printf("%n-- Depósito válido --%n");
        System.out.print("Digite o valor para depósito: ");
        conta.depositar(scanner.nextDouble());
        conta.consultarSaldo();

        // teste válido
        System.out.printf("%n-- Saque válido --%n");
        System.out.print("Digite o valor para saque: ");
        conta.sacar(scanner.nextDouble());
        conta.consultarSaldo();

        // teste inválido — saque maior que saldo
        System.out.printf("%n-- Saque inválido (valor alto) --%n");
        conta.sacar(999999.99);
        conta.consultarSaldo();

        // teste inválido — valor negativo
        System.out.printf("%n-- Depósito inválido (valor negativo) --%n");
        conta.depositar(-50.0);
        conta.consultarSaldo();

        scanner.close();
    }
}