package Exercicio9_codes.Exercicio4;

public class ContaEmpresarial extends ContaBancaria {
    public ContaEmpresarial(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public void cobrarTaxaMensal() {
        descontarTaxa(30.00 + consultarSaldo() * 0.005);
    }
}
