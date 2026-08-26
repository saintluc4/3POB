package Exercicio2_codes;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um numero inteiro: ");
        int num = scanner.nextInt();

        if(num % 2 == 0){
            System.out.print("O numero é par ");
        } else{
            System.out.print("O numero é impar ");
        }
        scanner.close();
    }
}