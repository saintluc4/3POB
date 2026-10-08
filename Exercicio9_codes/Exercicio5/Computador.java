package Exercicio9_codes.Exercicio5;

public class Computador extends DispositivoEletronico implements Conectavel {
    public Computador(String nome) {
        super(nome);
    }

    @Override
    public void ligar() {
        System.out.println(getNome() + ": iniciando o sistema operacional.");
    }

    @Override
    public void conectar(String rede) {
        System.out.println(getNome() + ": conectado a rede " + rede + ".");
    }
}
