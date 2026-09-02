package Exercicio4_codes;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[6];

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite o %dº número: %n", (i + 1));
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Digite o número de busca: ");
        int x = scanner.nextInt();

        boolean encontrado = false;
        int posicao = -1;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == x) {
                encontrado = true;
                posicao = i;
                break;
            }
        }

        if (encontrado) {
            System.out.printf("Número %d encontrado na posição %d%n", x, posicao);
        } else {
            System.out.printf("Número %d não encontrado no vetor%n", x);
        }

        scanner.close();
    }
}