package Exercicio8_codes.Exercicio3;

public class Exercicio3 {


    static void processarEnvio(Notificacao notificacao, String texto) {
        notificacao.enviar(texto);
    }

    public static void main(String[] args) {

        Notificacao[] notificacoes = {
            new EmailNotificacao("ana@email.com"),
            new SmsNotificacao  ("11999990000"),
            new PushNotificacao ("device-xpto-42")
        };

        String mensagem = "Seu pedido foi confirmado!";

        System.out.println("===== Disparando notificações =====");
        for (Notificacao n : notificacoes) {
            processarEnvio(n, mensagem);
        }


        System.out.println("\n===== Envios individuais =====");
        processarEnvio(new EmailNotificacao("joao@email.com"),  "Bem-vindo!");
        processarEnvio(new SmsNotificacao  ("21988880000"),     "Código: 4821");
        processarEnvio(new PushNotificacao ("device-abc-99"),   "Nova mensagem recebida.");
    }
}