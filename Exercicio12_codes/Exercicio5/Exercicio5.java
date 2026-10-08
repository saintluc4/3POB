package Exercicio12_codes.Exercicio5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercicio5 {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("Ana", "TI", 5000.00),
                new Funcionario("Carlos", "RH", 3500.00),
                new Funcionario("Beatriz", "TI", 6000.00),
                new Funcionario("Pedro", "Vendas", 4000.00));

        Predicate<Funcionario> doDepartamentoTI = funcionario ->
                "TI".equals(funcionario.getDepartamento());
        Function<Funcionario, Double> salarioReajustado = funcionario ->
                funcionario.getSalario() * 1.10;
        Consumer<Double> imprimirSalario = salario ->
                System.out.printf("Salário projetado: R$ %.2f%n", salario);

        funcionarios.stream()
                .filter(doDepartamentoTI)
                .map(salarioReajustado)
                .forEach(imprimirSalario);
    }
}
