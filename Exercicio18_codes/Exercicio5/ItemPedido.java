package Exercicio18_codes.Exercicio5;

public class ItemPedido {
    private Long produtoId;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(Long produtoId, int quantidade, double precoUnitario) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getProdutoId() { return produtoId; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
}
