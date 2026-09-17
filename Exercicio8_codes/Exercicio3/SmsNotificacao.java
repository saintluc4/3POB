package Exercicio8_codes.Exercicio3;

public class SmsNotificacao extends Notificacao {

    public SmsNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.printf("Enviando SMS para o número %s: %s%n",
                          getDestinatario(), mensagem);
    }
}