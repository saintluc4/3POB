package Exercicio10_codes.Exercicio2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        String[] valores = {"10", "25", "abc", "50"};
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um índice de 0 a 3: ");
            int indice = Integer.parseInt(scanner.nextLine());
            int numero = Integer.parseInt(valores[indice]);
            System.out.println("Número convertido: " + numero);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: o índice informado não existe no vetor.");
        } catch (NumberFormatException e) {
            System.out.println("Erro: o valor não pode ser convertido para um número inteiro.");
        } finally {
            scanner.close();
        }
    }
}
