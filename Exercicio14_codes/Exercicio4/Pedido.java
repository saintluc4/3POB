package Exercicio14_codes.Exercicio4;

public class Pedido {
    private int id;
    private double total;

    public Pedido(int id, double total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public void adicionarFrete(double frete) {
        total += frete;
    }
}
