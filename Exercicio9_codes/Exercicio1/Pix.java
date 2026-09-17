package Exercicio9_codes.Exercicio1;

public class Pix implements MetodoPagamento {

    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor inválido.");
            return;
        }
        System.out.printf("Pix de R$ %.2f enviado " +
                          "para a chave: %s%n", valor, chavePix);
        System.out.println("Pagamento instantâneo confirmado.");
    }

    @Override
    public String obterDetalhes() {
        return String.format("Pix | Chave: %s", chavePix);
    }
}