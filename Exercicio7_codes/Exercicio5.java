package Exercicio7_codes;

import java.util.Scanner;

class Funcionario {

    private String nome;
    private String matricula;
    private double salario;

    // construtor completo — todos os 3 atributos
    public Funcionario(String nome, String matricula, double salario) {
        this.nome       = nome;
        this.matricula  = matricula;
        this.salario    = salario;
    }

    // ── Getters ───────────────────────────────────────────
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    // ── Setters ───────────────────────────────────────────
    public void setNome(String nome) {
        this.nome = nome;
    }

    // regra de negócio: salário só pode aumentar
    public void setSalario(double novoSalario) {
        if (novoSalario > this.salario) {
            System.out.printf("Salário atualizado: R$ %.2f → R$ %.2f%n",
                              this.salario, novoSalario);
            this.salario = novoSalario;
        } else {
            System.out.printf("Erro: novo salário (R$ %.2f) deve ser maior " +
                              "que o atual (R$ %.2f). Valor ignorado.%n",
                              novoSalario, this.salario);
        }
    }

    // ── Exibição ──────────────────────────────────────────
    public void exibirDados() {
        System.out.println("=============================");
        System.out.printf("Nome:       %s%n",    nome);
        System.out.printf("Matrícula:  %s%n",    matricula);
        System.out.printf("Salário:    R$ %.2f%n", salario);
        System.out.println("=============================");
    }
}

public class Exercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Salário inicial (R$): ");
        double salarioInicial = scanner.nextDouble();

        Funcionario func = new Funcionario(nome, matricula, salarioInicial);

        System.out.println("\n===== Dados iniciais =====");
        func.exibirDados();

        // tentativa de aumento válido
        System.out.println("===== Aumento válido =====");
        System.out.print("Digite o novo salário (maior que o atual): ");
        func.setSalario(scanner.nextDouble());
        func.exibirDados();

        // tentativa de redução — bloqueada pela regra
        System.out.println("===== Tentativa de redução =====");
        System.out.print("Digite um salário menor que o atual: ");
        func.setSalario(scanner.nextDouble());
        func.exibirDados();

        // tentativa com valor igual — também bloqueada
        System.out.println("===== Tentativa com valor igual =====");
        func.setSalario(func.getSalario());
        func.exibirDados();

        scanner.close();
    }
}