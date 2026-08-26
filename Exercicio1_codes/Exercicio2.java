package Exercicio1_codes;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a temperatura em Celsius: ");
        double celsius = scanner.nextDouble();
        
        double fahrenheit = (celsius * 1.8) + 32;
        
        System.out.printf("%.0f%n", fahrenheit);

        scanner.close();
    }
}