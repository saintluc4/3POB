package exception;

public class ArquivoException extends Exception {

    public ArquivoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ArquivoException(String mensagem) {
        super(mensagem);
    }
}
