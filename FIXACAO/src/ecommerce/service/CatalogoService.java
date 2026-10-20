package ecommerce.service;

import ecommerce.model.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Gerencia o catálogo em memória.
 * A lista é declarada pela interface List (coding to interfaces) e instanciada como ArrayList.
 */
public class CatalogoService {

    private final List<Produto> repositorioProdutos = new ArrayList<>();

    /** Adiciona um produto. Rejeita nulo e ids duplicados. */
    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (repositorioProdutos.contains(produto)) {
            throw new IllegalArgumentException(
                    String.format("Já existe produto com id %d.", produto.getId()));
        }
        repositorioProdutos.add(produto);
    }

    /**
     * Remove pelo id usando Iterator.remove(), a forma segura de remover durante a iteração
     * (remover dentro de um for-each causaria ConcurrentModificationException em muitos casos).
     *
     * @return true se algum produto foi removido
     */
    public boolean removerProdutoPorId(Long id) {
        Iterator<Produto> it = repositorioProdutos.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /** Acesso posicional, O(1) em ArrayList. Lança IndexOutOfBoundsException se o índice for inválido. */
    public Produto buscarPorIndice(int indice) {
        return repositorioProdutos.get(indice);
    }

    /** Busca linear por id, O(n). Retorna null se não encontrar. */
    public Produto buscarPorId(Long id) {
        for (Produto p : repositorioProdutos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /** Busca produtos cujo nome contém o termo, sem distinguir maiúsculas de minúsculas. */
    public List<Produto> buscarPorNome(String termo) {
        List<Produto> encontrados = new ArrayList<>();
        String t = termo.toLowerCase();
        for (Produto p : repositorioProdutos) {
            if (p.getNome().toLowerCase().contains(t)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    /** Ordenação natural (Comparable): por nome, ignorando caixa. Ordena a lista interna in place. */
    public void ordenarPorNome() {
        Collections.sort(repositorioProdutos);
    }

    /** Ordenação alternativa por preço crescente, via Comparator explícito. */
    public void ordenarPorPreco() {
        Collections.sort(repositorioProdutos, Comparator.comparingDouble(Produto::getPreco));
    }

    /** Retorna uma visão imutável (List.copyOf), protegendo o encapsulamento do repositório. */
    public List<Produto> listarTodos() {
        return List.copyOf(repositorioProdutos);
    }

    public int quantidadeProdutos() {
        return repositorioProdutos.size();
    }
}
