package Exercicio6_codes;
import java.util.Scanner;

class Funcionario {
    String nome;
    String cargo;
    double salarioBruto;

    void aplicarAumento(double porcentagem) {
        double valorAumento = salarioBruto * porcentagem / 100;
        salarioBruto += valorAumento;
        System.out.printf("Aumento de %.1f%% aplicado: R$ %.2f%n", porcentagem, valorAumento);
    }

    double calcularSalarioLiquido(double descontoImposto) {
        return salarioBruto - descontoImposto;
    }
}

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Funcionario func = new Funcionario();

        System.out.print("Nome do funcionário: ");
        func.nome = scanner.nextLine();

        System.out.print("Cargo: ");
        func.cargo = scanner.nextLine();

        System.out.print("Salário bruto inicial (R$): ");
        func.salarioBruto = scanner.nextDouble();

        System.out.print("Desconto de imposto (R$): ");
        double desconto = scanner.nextDouble();

        // exibe situação antes do aumento
        System.out.printf("%n=== %s — %s ===%n", func.nome, func.cargo);
        System.out.printf("Salário bruto antes:   R$ %.2f%n", func.salarioBruto);
        System.out.printf("Salário líquido antes: R$ %.2f%n", func.calcularSalarioLiquido(desconto));

        // aplica o aumento
        System.out.printf("%n-- Aplicando aumento de 10%% --%n");
        func.aplicarAumento(10);

        // exibe situação depois do aumento
        System.out.printf("%n=== Após o aumento ===%n");
        System.out.printf("Salário bruto depois:   R$ %.2f%n", func.salarioBruto);
        System.out.printf("Salário líquido depois: R$ %.2f%n", func.calcularSalarioLiquido(desconto));

        scanner.close();
    }
}