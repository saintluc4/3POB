package Exercicio3_codes;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int SENHA = 2026;
        int tentativa;

        do {
            System.out.println("Digite a senha: ");
            tentativa = scanner.nextInt();

            if (tentativa != SENHA) {
                System.out.println("Senha Incorreta! Tente novamente.");
            }
        } while (tentativa != SENHA);

        System.out.println("Acesso Permitido!");

        scanner.close();
    }
}