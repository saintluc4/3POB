package Exercicio9_codes.Exercicio1;

public class Main {
    public static void finalizarCompra(MetodoPagamento metodo, double total) {
        Exercicio1.finalizarCompra(metodo, total);
    }

    public static void main(String[] args) {
        finalizarCompra(new CartaoCredito("1234-5678-9012-3456", 2000.00), 350.00);
        finalizarCompra(new Pix("ana@email.com"), 128.90);
    }
}
