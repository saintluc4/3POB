package Exercicio5_codes;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[4][3];
        int[] somaLinhas = new int[4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite o valor para [%d][%d]: %n", i, j);
                matriz[i][j] = scanner.nextInt();
                somaLinhas[i] += matriz[i][j];
            }
        }

        for (int i = 0; i < somaLinhas.length; i++) {
            System.out.printf("Soma da linha %d: %d%n", i, somaLinhas[i]);
        }

        scanner.close();
    }
}