package Exercicio9_codes.Exercicio4;

public abstract class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        if (!Double.isFinite(saldoInicial) || saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial invalido.");
        }
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public void depositar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("Deposito deve ser positivo e finito.");
        }
        saldo += valor;
    }

    public double consultarSaldo() {
        return saldo;
    }

    protected void descontarTaxa(double valor) {

        saldo -= valor;
    }

    public abstract void cobrarTaxaMensal();
}
