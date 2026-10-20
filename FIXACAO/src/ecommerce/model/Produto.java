package ecommerce.model;

import java.util.Objects;

/**
 * Entidade de domínio do catálogo.
 * Implementa Comparable para definir a ordenação natural: nome, sem distinguir maiúsculas de minúsculas.
 */
public class Produto implements Comparable<Produto> {

    private final Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(Long id, String nome, double preco, int estoque) {
        if (id == null) {
            throw new IllegalArgumentException("O id do produto é obrigatório.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException(String.format("Preço inválido: %.2f", preco));
        }
        if (estoque < 0) {
            throw new IllegalArgumentException(String.format("Estoque inválido: %d", estoque));
        }
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException(String.format("Preço inválido: %.2f", preco));
        }
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException(String.format("Estoque inválido: %d", estoque));
        }
        this.estoque = estoque;
    }

    @Override
    public int compareTo(Produto outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    /** Dois produtos são iguais se tiverem o mesmo id (necessário para remove(Object) e contains). */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto outro = (Produto) o;
        return id.equals(outro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Produto{id=%d, nome='%s', preco=R$ %.2f, estoque=%d}",
                id, nome, preco, estoque);
    }
}
