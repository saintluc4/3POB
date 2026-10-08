package Exercicio11_codes.Exercicio4;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtos = new HashMap<>();

    public boolean existeProduto(String codigo) {
        return produtos.containsKey(codigo);
    }

    public void inserirProduto(String codigo, int quantidade) {
        if (existeProduto(codigo)) {
            System.out.println("Produto já cadastrado: " + codigo);
            return;
        }

        produtos.put(codigo, quantidade);
        System.out.println("Produto cadastrado: " + codigo);
    }

    public void atualizarQuantidade(String codigo, int variacao) {
        if (!existeProduto(codigo)) {
            System.out.println("Produto não encontrado: " + codigo);
            return;
        }

        // Valores positivos adicionam unidades; negativos retiram unidades.
        int novaQuantidade = produtos.get(codigo) + variacao;
        produtos.put(codigo, novaQuantidade);
        System.out.println("Produto " + codigo + " | Quantidade: " + novaQuantidade);
    }

    public void exibirEstoqueBaixo(int limiteAlerta) {
        System.out.println("Produtos com estoque zerado ou abaixo de " + limiteAlerta + ":");
        for (Map.Entry<String, Integer> entrada : produtos.entrySet()) {
            int quantidade = entrada.getValue();
            if (quantidade == 0 || quantidade < limiteAlerta) {
                System.out.println(entrada.getKey() + " | Quantidade: " + quantidade);
            }
        }
    }
}
