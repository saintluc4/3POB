package Exercicio7_codes;
import java.util.Scanner;

class Retangulo {

    private double largura;
    private double altura;


    public Retangulo(double largura, double altura) {
        setLargura(largura);
        setAltura(altura);
    }


    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }


    public void setLargura(double largura) {
        if (largura > 0) {
            this.largura = largura;
        } else {
            this.largura = 1.0;
            System.out.println("Aviso: largura deve ser > 0. Valor padrão 1.0 atribuído.");
        }
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            this.altura = 1.0;
            System.out.println("Aviso: altura deve ser > 0. Valor padrão 1.0 atribuído.");
        }
    }


    public double calcularArea() {
        return largura * altura;
    }

    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    public void exibirInformacoes() {
        System.out.println("=============================");
        System.out.printf("Largura:    %.2f%n", largura);
        System.out.printf("Altura:     %.2f%n", altura);
        System.out.printf("Área:       %.2f%n", calcularArea());
        System.out.printf("Perímetro:  %.2f%n", calcularPerimetro());
        System.out.println("=============================");
    }
}

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite a largura: ");
        double largura = scanner.nextDouble();

        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();

        Retangulo retA = new Retangulo(largura, altura);
        System.out.println("\n===== Retângulo A =====");
        retA.exibirInformacoes();


        System.out.println("===== Retângulo B (valores inválidos no construtor) =====");
        Retangulo retB = new Retangulo(-5.0, 0.0);
        retB.exibirInformacoes();


        System.out.println("===== Retângulo A — setter inválido após criação =====");
        retA.setLargura(-3.0);
        retA.exibirInformacoes();

        scanner.close();
    }
}