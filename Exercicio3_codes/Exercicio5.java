package Exercicio3_codes;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long fatorial = 1;

        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }

        System.out.println(n + "! = " + fatorial);

        scanner.close();
    }
}