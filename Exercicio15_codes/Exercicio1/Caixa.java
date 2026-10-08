package Exercicio15_codes.Exercicio1;

public class Caixa<T> {
    private T conteudo;

    public void guardar(T elemento) {
        conteudo = elemento;
    }

    public T recuperar() {
        return conteudo;
    }

    public boolean isVazia() {
        return conteudo == null;
    }

    public void limpar() {
        conteudo = null;
    }
}
