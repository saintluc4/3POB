package Exercicio12_codes.Exercicio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Exercicio2 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500.00),
                new Produto("Mouse", 80.00),
                new Produto("Teclado", 150.00),
                new Produto("Monitor", 900.00),
                new Produto("Fone", 120.00),
                new Produto("Webcam", 250.00));

        double total = produtos.stream().mapToDouble(Produto::getPreco).sum();
        OptionalDouble media = produtos.stream().mapToDouble(Produto::getPreco).average();
        Optional<Produto> maisCaro = produtos.stream()
                .max(Comparator.comparingDouble(Produto::getPreco));

        System.out.printf("Valor total: R$ %.2f%n", total);
        media.ifPresent(valor -> System.out.printf("Preço médio: R$ %.2f%n", valor));
        maisCaro.ifPresent(produto -> System.out.printf("Produto mais caro: %s | R$ %.2f%n",
                produto.getNome(), produto.getPreco()));
    }
}
