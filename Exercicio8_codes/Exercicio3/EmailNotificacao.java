package Exercicio8_codes.Exercicio3;

public class EmailNotificacao extends Notificacao {

    public EmailNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.printf("Enviando E-mail para %s: %s%n",
                          getDestinatario(), mensagem);
    }
}