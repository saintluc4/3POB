package Exercicio2_codes;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu ano de nascimento: ");
            int anoNascimento = scanner.nextInt();

        System.out.println("Digite o ano atual: ");
            int anoAtual = scanner.nextInt();

        int idade = anoAtual - anoNascimento;

        System.out.printf("Idade: %d anos. ", idade);

        if(idade >= 18){
            System.out.println("Você é maior de idade. ");
        } else{
            System.out.println("Você é menor de idade. ");
        }
        scanner.close();
    }
}
