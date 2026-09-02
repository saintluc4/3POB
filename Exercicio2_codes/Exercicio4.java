package Exercicio2_codes;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro numero: ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite o segundo numero: ");
        double num2 = scanner.nextDouble();

        System.out.println("Digite o terceiro numero: ");
        double num3 = scanner.nextDouble();

        double maior = Math.max(num1, Math.max(num2, num3));
        double menor = Math.min(num1, Math.min(num2, num3));
        double meio  = (num1 + num2 + num3) - maior - menor;

        System.out.printf("Maior: %.1f%n", maior);
        System.out.printf("Meio:  %.1f%n", meio);
        System.out.printf("Menor: %.1f%n", menor);

        scanner.close();
    }
}