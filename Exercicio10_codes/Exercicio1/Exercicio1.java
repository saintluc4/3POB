package Exercicio10_codes.Exercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número inteiro: ");
            int primeiro = scanner.nextInt();

            System.out.print("Digite o segundo número inteiro: ");
            int segundo = scanner.nextInt();

            int resultado = primeiro / segundo;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: não é possível dividir por zero.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: informe apenas números inteiros.");
        } finally {
            System.out.println("Operação finalizada.");
            scanner.close();
        }
    }
}
