package Exercicio6_codes;
import java.util.Scanner;


class Circulo {
    double raio;

    double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Circulo circulo = new Circulo();

        System.out.print("Digite o raio do círculo: ");
        circulo.raio = scanner.nextDouble();

        double area      = circulo.calcularArea();
        double perimetro = circulo.calcularPerimetro();

        System.out.printf("Área: %.2f%n", area);
        System.out.printf("Perímetro: %.2f%n", perimetro);

        scanner.close();
    }
}