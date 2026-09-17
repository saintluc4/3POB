package Exercicio8_codes.Exercicio2;

public class Gerente extends Funcionario {

    private double bonusFixo;

    public Gerente(String nome, double salarioBase, double bonusFixo) {
        super(nome, salarioBase);
        this.bonusFixo = bonusFixo;
    }

    public double getBonusFixo() { return bonusFixo; }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonusFixo;
    }
}