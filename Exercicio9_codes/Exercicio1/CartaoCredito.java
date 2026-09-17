package Exercicio9_codes.Exercicio1;

public class CartaoCredito implements MetodoPagamento {

    private String numeroCartao;
    private double limite;

    public CartaoCredito(String numeroCartao, double limite) {
        this.numeroCartao = numeroCartao;
        this.limite       = limite;
    }

    @Override
    public void processarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor inválido.");
            return;
        }
        if (valor > limite) {
            System.out.printf("Erro: limite insuficiente. " +
                              "Disponível: R$ %.2f%n", limite);
            return;
        }
        limite -= valor;
        System.out.printf("Pagamento de R$ %.2f realizado " +
                          "no cartão %s.%n", valor, numeroCartao);
        System.out.printf("Limite restante: R$ %.2f%n", limite);
    }

    @Override
    public String obterDetalhes() {
        return String.format("Cartão de Crédito | Número: %s | " +
                             "Limite disponível: R$ %.2f",
                             numeroCartao, limite);
    }
}