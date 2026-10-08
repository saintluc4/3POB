package Exercicio9_codes.Exercicio3;

public class Administrador implements Autenticavel, ExportavelJSON {
    private String login;
    private String senha;
    private int nivelAcesso;

    public Administrador(String login, String senha, int nivelAcesso) {
        this.login = java.util.Objects.requireNonNull(login);
        this.senha = java.util.Objects.requireNonNull(senha);
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public String exportarJSON() {
        // A senha nao faz parte dos dados exportados.
        return "{\"login\":\"" + escaparJSON(login)
                + "\",\"nivelAcesso\":" + nivelAcesso + "}";
    }

    private static String escaparJSON(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char caractere : texto.toCharArray()) {
            if (caractere == '"' || caractere == '\\') {
                resultado.append('\\').append(caractere);
            } else if (caractere < 0x20) {
                resultado.append(String.format("\\u%04x", (int) caractere));
            } else {
                resultado.append(caractere);
            }
        }
        return resultado.toString();
    }
}
