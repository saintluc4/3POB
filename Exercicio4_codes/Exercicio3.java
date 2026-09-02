package Exercicio4_codes;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] notas = new double[8];
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.printf("Digite a nota do %dº aluno: %n", (i + 1));
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }

        double media = soma / notas.length;
        System.out.printf("Média da turma: %.2f%n", media);

        System.out.println("Alunos acima da média:");
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                System.out.printf("Aluno %d: %.2f%n", (i + 1), notas[i]);
            }
        }

        scanner.close();
    }
}