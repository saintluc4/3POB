package Exercicio5_codes;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[2][3];
        int[][] transposta = new int[3][2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite o valor para [%d][%d]: %n", i, j);
                matriz[i][j] = scanner.nextInt();
                transposta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz original (2x3):");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println("Matriz transposta (3x2):");
        for (int i = 0; i < transposta.length; i++) {
            for (int j = 0; j < transposta[i].length; j++) {
                System.out.printf("%4d", transposta[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}