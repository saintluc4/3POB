package Exercicio5_codes;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[3][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite o valor para [%d][%d]: %n", i, j);
                matriz[i][j] = scanner.nextInt();
            }
        }

        int maior = matriz[0][0];
        int linhaMaior = 0;
        int colunaMaior = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                    linhaMaior = i;
                    colunaMaior = j;
                }
            }
        }

        System.out.printf("Maior valor: %d%n", maior);
        System.out.printf("Linha: %d | Coluna: %d%n", linhaMaior, colunaMaior);

        scanner.close();
    }
}