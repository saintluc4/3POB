package Exercicio3_codes;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite A: ");
        int a = scanner.nextInt();

        System.out.println("Digite o limite B: ");
        int b = scanner.nextInt();

        int pares = 0;
        int impares = 0;

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        System.out.printf("Quantidade de pares: %d%n", pares);
        System.out.printf("Quantidade de ímpares: %d%n", impares);

        scanner.close();
    }
}