package Exercicio18_codes.Exercicio5;

public class Pedido {
    private Long clienteId;
    private double total;

    public Pedido(Long clienteId, double total) {
        this.clienteId = clienteId;
        this.total = total;
    }

    public Long getClienteId() { return clienteId; }
    public double getTotal() { return total; }
}
