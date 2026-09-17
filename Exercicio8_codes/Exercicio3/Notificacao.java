package Exercicio8_codes.Exercicio3;

public class Notificacao {

    private String destinatario;

    public Notificacao(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDestinatario() { return destinatario; }

    public void enviar(String mensagem) {
        System.out.printf("Enviando notificação para %s: %s%n",
                          destinatario, mensagem);
    }
}