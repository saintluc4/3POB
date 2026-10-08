package Exercicio11_codes.Exercicio2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercicio2 {
    private static Set<Integer> lerTurma(Scanner scanner, String nome) {
        Set<Integer> turma = new HashSet<>();
        System.out.print("Digite as matrículas da " + nome + " separadas por espaços: ");
        String linha = scanner.nextLine().trim();

        if (!linha.isEmpty()) {
            for (String matricula : linha.split("\\s+")) {
                turma.add(Integer.parseInt(matricula));
            }
        }
        return turma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> turmaA = lerTurma(scanner, "Turma A");
        Set<Integer> turmaB = lerTurma(scanner, "Turma B");

        Set<Integer> uniao = new HashSet<>(turmaA);
        uniao.addAll(turmaB);

        Set<Integer> intersecao = new HashSet<>(turmaA);
        intersecao.retainAll(turmaB);

        System.out.println("União: " + uniao);
        System.out.println("Interseção: " + intersecao);

        scanner.close();
    }
}
