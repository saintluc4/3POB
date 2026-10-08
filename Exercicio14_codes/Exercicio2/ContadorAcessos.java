package Exercicio14_codes.Exercicio2;

public class ContadorAcessos {
    private int acessos;

    public void incrementarSemSincronizacao() {
        int valorAtual = acessos;

        Thread.yield();
        acessos = valorAtual + 1;
    }

    public synchronized void incrementarSincronizado() {
        acessos++;
    }

    public int getAcessos() {
        return acessos;
    }
}
