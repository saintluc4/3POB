package ecommerce.app;

import ecommerce.model.Produto;
import ecommerce.service.CatalogoService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CatalogoService catalogo = new CatalogoService();

        catalogo.adicionarProduto(new Produto(10L, "Teclado Mecânico", 349.90, 25));
        catalogo.adicionarProduto(new Produto(20L, "mouse sem fio", 89.50, 60));
        catalogo.adicionarProduto(new Produto(30L, "Monitor 24 polegadas", 899.00, 12));
        catalogo.adicionarProduto(new Produto(40L, "Webcam Full HD", 199.99, 0));

        System.out.println("=== Catálogo inicial ===");
        imprimir(catalogo.listarTodos());

        System.out.println("\n=== Ordenado por nome (Comparable, ignora caixa) ===");
        catalogo.ordenarPorNome();
        imprimir(catalogo.listarTodos());

        System.out.println("\n=== Ordenado por preço (Comparator) ===");
        catalogo.ordenarPorPreco();
        imprimir(catalogo.listarTodos());

        System.out.println("\n=== Busca por nome contendo 'mo' ===");
        imprimir(catalogo.buscarPorNome("mo"));

        System.out.println("\n=== Remoção ===");
        boolean removido = catalogo.removerProdutoPorId(20L);
        System.out.printf("Remover id %d: %b%n", 20L, removido);
        removido = catalogo.removerProdutoPorId(999L);
        System.out.printf("Remover id %d: %b%n", 999L, removido);

        System.out.println("\n=== Busca por índice ===");
        Produto p = catalogo.buscarPorIndice(1);
        System.out.printf("Índice %d -> %s%n", 1, p);

        System.out.println("\n=== Tratamento de erros ===");
        try {
            catalogo.buscarPorIndice(50);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Índice inválido: %s%n", e.getMessage());
        }
        try {
            catalogo.adicionarProduto(new Produto(10L, "Duplicado", 1.00, 1));
        } catch (IllegalArgumentException e) {
            System.out.printf("Erro ao adicionar: %s%n", e.getMessage());
        }
        try {
            catalogo.listarTodos().add(new Produto(99L, "Intruso", 1.00, 1));
        } catch (UnsupportedOperationException e) {
            System.out.println("listarTodos() devolve lista imutável (UnsupportedOperationException).");
        }

        System.out.printf("%nTotal de produtos no catálogo: %d%n", catalogo.quantidadeProdutos());
    }

    private static void imprimir(List<Produto> produtos) {
        for (Produto p : produtos) {
            System.out.printf(" - %s%n", p);
        }
    }
}
