package Exercicio1_codes;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da hora: ");
        double valorHora = scanner.nextDouble();

        System.out.print("Digite a quantidade de horas trabalhadas: ");
        double horas = scanner.nextDouble();

        double salarioBruto = valorHora * horas;
        double desconto = salarioBruto * 0.10;
        double salarioLiquido = salarioBruto - desconto;

        System.out.printf("Salário Bruto: R$ %.2f%n", salarioBruto);
        System.out.printf("Salário Líquido: R$ %.2f%n", salarioLiquido);

        scanner.close();
    }
}