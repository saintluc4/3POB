package Exercicio9_codes.Exercicio3;

public class Usuario implements Autenticavel {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = java.util.Objects.requireNonNull(login);
        this.senha = java.util.Objects.requireNonNull(senha);
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
