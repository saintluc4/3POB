package Exercicio16_codes.Exercicio4;

public class NotificacaoService {
    private final EmailSender emailSender;

    public NotificacaoService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void notificarBoasVindas(Usuario usuario) {
        String primeiroNome = usuario.getNome().trim().split("\\s+")[0];
        String assunto = "Bem-vindo ao sistema!";
        String corpo = "Olá, " + primeiroNome + "! Seu cadastro foi realizado com sucesso.";
        emailSender.enviar(usuario.getEmail(), assunto, corpo);
    }
}
