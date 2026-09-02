package Exercicio3_codes;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int soma = 0;
        int contador = 0;

        System.out.println("Digite um número inteiro positivo (-1 para parar): ");
        int num = scanner.nextInt();

        while (num >= 0) {
            soma += num;
            contador++;

            System.out.println("Digite um número inteiro positivo (-1 para parar): ");
            num = scanner.nextInt();
        }

        if (contador > 0) {
            double media = (double) soma / contador;
            System.out.println("Quantidade: " + contador);
            System.out.println("Soma: " + soma);
            System.out.println("Média: " + media);
        } else {
            System.out.println("Nenhum número foi digitado!");
        }

        scanner.close();
    }
}