package Exercicio8_codes.Exercicio5;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(String numero, double saldoInicial,
                         double taxaRendimento) {
        super(numero, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() { return taxaRendimento; }


    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento / 100;
        depositar(rendimento);
        System.out.printf("Rendimento de %.2f%% aplicado: R$ %.2f%n",
                          taxaRendimento, rendimento);
    }


    @Override
    public void exibirExtrato() {
        System.out.println("===== Conta Poupança =====");
        super.exibirExtrato();
        System.out.printf("Taxa de rendimento: %.2f%%%n", taxaRendimento);
        System.out.println("-----------------------------");
    }
}