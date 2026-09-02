package Exercicio2_codes;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o lado A: ");
        double a = scanner.nextDouble();

        System.out.println("Digite o lado B: ");
        double b = scanner.nextDouble();

        System.out.println("Digite o lado C: ");
        double c = scanner.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {

            if (a == b && b == c) {
                System.out.println("Triângulo Equilátero!");
            } else if (a == b || a == c || b == c) {
                System.out.println("Triângulo Isósceles!");
            } else {
                System.out.println("Triângulo Escaleno!");
            }

        } else {
            System.out.println("Erro: os lados informados não formam um triângulo válido!");
        }

        scanner.close();
    }
}