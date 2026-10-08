package Exercicio11_codes.Exercicio4;

public class Exercicio4 {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        estoque.inserirProduto("P001", 10);
        estoque.inserirProduto("P002", 6);
        estoque.inserirProduto("P003", 0);
        estoque.inserirProduto("P004", 5);
        estoque.inserirProduto("P001", 20);

        System.out.println("P001 existe: " + estoque.existeProduto("P001"));
        System.out.println("P999 existe: " + estoque.existeProduto("P999"));

        estoque.atualizarQuantidade("P001", 5);
        estoque.atualizarQuantidade("P002", -3);
        estoque.atualizarQuantidade("P999", 2);

        estoque.exibirEstoqueBaixo(5);
    }
}
