package Exercicio4_codes;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite o %dº número: %n", (i + 1));
            numeros[i] = scanner.nextInt();
        }

        int maior = numeros[0];
        int menor = numeros[0];
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
                indiceMaior = i;
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
                indiceMenor = i;
            }
        }

        System.out.printf("Maior: %d na posição %d%n", maior, indiceMaior);
        System.out.printf("Menor: %d na posição %d%n", menor, indiceMenor);

        scanner.close();
    }
}