package Exercicio8_codes.Exercicio2;

public class Exercicio2 {

    public static void main(String[] args) {

        // array do tipo da superclasse — guarda qualquer subtipo
        Funcionario[] equipe = {
            new Funcionario("Ana Costa",   3000.00),
            new Gerente    ("Bruno Lima",  5000.00, 1500.00),
            new Vendedor   ("Carla Melo",  2000.00, 20000.00, 5.0),
            new Gerente    ("Diego Souza", 6000.00, 2000.00),
            new Vendedor   ("Eva Santos",  2500.00, 35000.00, 7.0)
        };

        System.out.println("========== Folha de Pagamento ==========");

        double totalFolha = 0.0;

        for (Funcionario f : equipe) {
            f.exibirSalario();                // dynamic binding em ação
            totalFolha += f.calcularSalario();
        }

        System.out.println("----------------------------------------");
        System.out.printf("Total da folha: R$ %.2f%n", totalFolha);
    }
}