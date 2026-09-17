package Exercicio8_codes.Exercicio3;

public class Exercicio3 {

    // recebe qualquer Notificacao sem saber o tipo concreto
    static void processarEnvio(Notificacao notificacao, String texto) {
        notificacao.enviar(texto); // dynamic binding resolve o tipo real
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

        // testando tipos diferentes com mensagens distintas
        System.out.println("\n===== Envios individuais =====");
        processarEnvio(new EmailNotificacao("joao@email.com"),  "Bem-vindo!");
        processarEnvio(new SmsNotificacao  ("21988880000"),     "Código: 4821");
        processarEnvio(new PushNotificacao ("device-abc-99"),   "Nova mensagem recebida.");
    }
}