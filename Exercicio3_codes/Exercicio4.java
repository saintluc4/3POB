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

        System.out.println("Quantidade de pares: " + pares);
        System.out.println("Quantidade de ímpares: " + impares);

        scanner.close();
    }
}