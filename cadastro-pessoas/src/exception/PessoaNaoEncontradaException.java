package exception;

public class PessoaNaoEncontradaException extends Exception {

    public PessoaNaoEncontradaException(int id) {
        super(String.format("Nenhuma pessoa encontrada com o ID %d.", id));
    }
}
