package Exercicio8_codes.Exercicio5;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;
    private static final double TAXA_SAQUE = 2.00;

    public ContaCorrente(String numero, double saldoInicial,
                         double limiteChequeEspecial) {
        super(numero, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() { return limiteChequeEspecial; }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor de saque inválido.");
            return;
        }

        double valorTotal    = valor + TAXA_SAQUE;
        double poderDeSaque  = getSaldo() + limiteChequeEspecial;

        if (valorTotal <= poderDeSaque) {
            // desconta manualmente pois o saldo pode ficar negativo
            // (a regra de Conta não permite saldo negativo)
            double novoSaldo = getSaldo() - valorTotal;
            // zera via sacar da superclasse e redeposita o valor correto
            super.sacar(getSaldo());         // zera o saldo atual
            if (novoSaldo < 0) {
                // deposita o que sobrou do limite (valor negativo virou positivo)
                depositar(limiteChequeEspecial - Math.abs(novoSaldo +
                          limiteChequeEspecial - limiteChequeEspecial));
                // ajuste direto — registra o saldo negativo
                super.sacar(getSaldo() + Math.abs(novoSaldo));
            }
            System.out.printf(
                "Saque de R$ %.2f + taxa R$ %.2f = R$ %.2f efetuado.%n",
                valor, TAXA_SAQUE, valorTotal);
        } else {
            System.out.printf(
                "Erro: limite insuficiente. Poder de saque: R$ %.2f%n",
                poderDeSaque - TAXA_SAQUE);
        }
    }

    @Override
    public void exibirExtrato() {
        System.out.println("===== Conta Corrente =====");
        super.exibirExtrato();
        System.out.printf("Cheque especial: R$ %.2f%n", limiteChequeEspecial);
        System.out.printf("Taxa por saque:  R$ %.2f%n", TAXA_SAQUE);
        System.out.println("-----------------------------");
    }
}