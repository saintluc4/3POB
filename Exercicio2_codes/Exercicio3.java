package Exercicio2_codes;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua primeira nota: ");
            double nota1 = scanner.nextDouble();

        System.out.println("Digite sua segunda nota: ");
            double nota2 = scanner.nextDouble();

        double media = (nota1 + nota2) / 2;

        if(media >= 7.0){
            System.out.printf("Sua media é %.2f, Situação: APROVADO ", media);
        } else if(media >= 5.0 && media <= 6.9){
            System.out.printf("Sua media é %.2f, Situação: RECUPERAÇÃO ", media);
        } else if(media < 5.0){
            System.out.printf("Sua media é %.2f, Situação: REPROVADO ", media);
        }

        scanner.close();
    }
}
