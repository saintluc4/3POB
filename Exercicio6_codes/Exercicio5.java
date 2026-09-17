package Exercicio6_codes;
import java.util.Scanner;

class Aluno {
    String nome;
    String matricula;
    double nota1;
    double nota2;

    double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    String verificarAprovacao() {
        if (this.calcularMedia() >= 7.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    void imprimirBoletim() {
        double media    = this.calcularMedia();
        String situacao = this.verificarAprovacao();

        System.out.println("=============================");
        System.out.printf("Nome:       %s%n", nome);
        System.out.printf("Matrícula:  %s%n", matricula);
        System.out.printf("Nota 1:     %.2f%n", nota1);
        System.out.printf("Nota 2:     %.2f%n", nota2);
        System.out.printf("Média:      %.2f%n", media);
        System.out.printf("Situação:   %s%n", situacao);
        System.out.println("=============================");
    }
}

public class Exercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.print("Nome do aluno: ");
        aluno.nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        aluno.matricula = scanner.nextLine();

        System.out.print("Nota 1: ");
        aluno.nota1 = scanner.nextDouble();

        System.out.print("Nota 2: ");
        aluno.nota2 = scanner.nextDouble();

        System.out.println();
        aluno.imprimirBoletim();

        scanner.close();
    }
}