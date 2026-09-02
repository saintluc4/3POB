package Exercicio4_codes;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[10];
        int[] pares = new int[10];
        int[] impares = new int[10];
        int contPares = 0;
        int contImpares = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite o %dº número: %n", (i + 1));
            numeros[i] = scanner.nextInt();

            if (numeros[i] % 2 == 0) {
                pares[contPares++] = numeros[i];
            } else {
                impares[contImpares++] = numeros[i];
            }
        }

        System.out.println("Números pares:");
        for (int i = 0; i < contPares; i++) {
            System.out.printf("%d%n", pares[i]);
        }

        System.out.println("Números ímpares:");
        for (int i = 0; i < contImpares; i++) {
            System.out.printf("%d%n", impares[i]);
        }

        scanner.close();
    }
}