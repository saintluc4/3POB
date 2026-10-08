package Exercicio9_codes.Exercicio5;

public class Calculadora extends DispositivoEletronico {
    public Calculadora(String nome) {
        super(nome);
    }

    @Override
    public void ligar() {
        System.out.println(getNome() + ": pronta para calcular.");
    }
}
