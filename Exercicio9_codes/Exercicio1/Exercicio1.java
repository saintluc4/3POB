package Exercicio9_codes.Exercicio1;

public class Exercicio1 {


    static void finalizarCompra(MetodoPagamento metodo, double total) {
        System.out.println("=============================");
        System.out.printf("Total da compra: R$ %.2f%n", total);
        System.out.printf("Método: %s%n", metodo.obterDetalhes());
        System.out.println("Processando pagamento...");
        metodo.processarPagamento(total);
        System.out.println("=============================");
    }

    public static void main(String[] args) {

        MetodoPagamento cartao = new CartaoCredito("1234-5678-9012-3456", 2000.00);
        MetodoPagamento pix    = new Pix("ana@email.com");


        finalizarCompra(cartao, 350.00);
        finalizarCompra(pix,    128.90);


        System.out.println("===== Teste de limite =====");
        finalizarCompra(cartao, 9999.00);
    }
}