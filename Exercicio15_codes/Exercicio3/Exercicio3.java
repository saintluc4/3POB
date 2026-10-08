package Exercicio15_codes.Exercicio3;

public class Exercicio3 {
    public static void main(String[] args) {
        CalculadoraEstatistica<Integer> inteiros = new CalculadoraEstatistica<>();
        inteiros.adicionar(10);
        inteiros.adicionar(20);
        inteiros.adicionar(30);
        System.out.println("Média dos inteiros: " + inteiros.calcularMedia());
        System.out.println("Maior inteiro: " + inteiros.calcularMaior());

        CalculadoraEstatistica<Double> decimais = new CalculadoraEstatistica<>();
        decimais.adicionar(-2.5);
        decimais.adicionar(-1.5);
        decimais.adicionar(-3.5);
        System.out.println("Média dos decimais: " + decimais.calcularMedia());
        System.out.println("Maior decimal: " + decimais.calcularMaior());



    }
}
