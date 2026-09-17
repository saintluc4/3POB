package Exercicio8_codes.Exercicio3;

public class PushNotificacao extends Notificacao {

    public PushNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.printf("Enviando Push Notification para o dispositivo %s: %s%n",
                          getDestinatario(), mensagem);
    }
}