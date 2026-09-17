package Exercicio8_codes.Exercicio2;

public class Vendedor extends Funcionario {

    private double totalVendas;
    private double comissaoPercentual;

    public Vendedor(String nome, double salarioBase,
                    double totalVendas, double comissaoPercentual) {
        super(nome, salarioBase);
        this.totalVendas        = totalVendas;
        this.comissaoPercentual = comissaoPercentual;
    }

    public double getTotalVendas()        { return totalVendas; }
    public double getComissaoPercentual() { return comissaoPercentual; }

    @Override
    public double calcularSalario() {
        double comissao = totalVendas * comissaoPercentual / 100;
        return super.calcularSalario() + comissao;
    }
}