package Exercicio10_codes.Exercicio3;

public class ContaCorrente {
    private String numero;
    private double saldo;

    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                    String.format("Saldo insuficiente na conta %s. Disponível: R$ %.2f.",
                            numero, saldo));
        }

        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Saldo restante: R$ %.2f.%n",
                valor, saldo);
    }
}
