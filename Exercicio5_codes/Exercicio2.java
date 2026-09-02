package Exercicio5_codes;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] matriz = new double[4][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite o valor para [%d][%d]: %n", i, j);
                matriz[i][j] = scanner.nextDouble();
            }
        }

        double soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }

        System.out.printf("Soma da diagonal principal: %.2f%n", soma);

        scanner.close();
    }
}