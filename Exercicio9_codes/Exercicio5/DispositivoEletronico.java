package Exercicio9_codes.Exercicio5;

public abstract class DispositivoEletronico {
    private String nome;

    public DispositivoEletronico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void exibirIdentificacao() {
        System.out.println("Dispositivo: " + nome);
    }

    public abstract void ligar();
}
