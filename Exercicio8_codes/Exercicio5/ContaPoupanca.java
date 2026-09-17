package Exercicio8_codes.Exercicio5;

public class ContaPoupanca extends Conta {

    private double taxaRendimento; // percentual ex: 0.5 = 0,5% ao mês

    public ContaPoupanca(String numero, double saldoInicial,
                         double taxaRendimento) {
        super(numero, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() { return taxaRendimento; }

    // aplica rendimento mensal sobre o saldo atual
    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento / 100;
        depositar(rendimento);
        System.out.printf("Rendimento de %.2f%% aplicado: R$ %.2f%n",
                          taxaRendimento, rendimento);
    }

    // sacar() herdado de Conta — sem alteração
    @Override
    public void exibirExtrato() {
        System.out.println("===== Conta Poupança =====");
        super.exibirExtrato();
        System.out.printf("Taxa de rendimento: %.2f%%%n", taxaRendimento);
        System.out.println("-----------------------------");
    }
}