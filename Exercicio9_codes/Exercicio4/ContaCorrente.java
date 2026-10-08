package Exercicio9_codes.Exercicio4;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public void cobrarTaxaMensal() {
        descontarTaxa(15.00);
    }
}
