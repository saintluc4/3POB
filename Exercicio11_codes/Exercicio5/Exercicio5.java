package Exercicio11_codes.Exercicio5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicio5 {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", "Informática", 3500.00));
        produtos.add(new Produto("Mouse", "Informática", 80.00));
        produtos.add(new Produto("Arroz", "Alimentos", 25.00));
        produtos.add(new Produto("Feijão", "Alimentos", 8.00));
        produtos.add(new Produto("Java para iniciantes", "Livros", 65.00));
        produtos.add(new Produto("Lógica de programação", "Livros", 50.00));

        Map<String, List<Produto>> categorias = new HashMap<>();

        for (Produto produto : produtos) {
            String categoria = produto.getCategoria();
            if (!categorias.containsKey(categoria)) {
                categorias.put(categoria, new ArrayList<>());
            }
            categorias.get(categoria).add(produto);
        }

        for (Map.Entry<String, List<Produto>> entrada : categorias.entrySet()) {
            System.out.println("===== " + entrada.getKey() + " =====");
            for (Produto produto : entrada.getValue()) {
                System.out.printf("%s | R$ %.2f%n", produto.getNome(), produto.getPreco());
            }
        }
    }
}
