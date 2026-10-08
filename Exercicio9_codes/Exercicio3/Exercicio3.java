package Exercicio9_codes.Exercicio3;

public class Exercicio3 {
    public static void main(String[] args) {
        Autenticavel usuario = new Usuario("ana", "1234");
        Administrador administrador = new Administrador("admin", "admin123", 3);
        Autenticavel acessoAdmin = administrador;
        ExportavelJSON exportacao = administrador;

        System.out.println("Usuario autenticado: " + usuario.autenticar("1234"));
        System.out.println("Senha incorreta: " + usuario.autenticar("errada"));
        System.out.println("Administrador autenticado: " + acessoAdmin.autenticar("admin123"));
        System.out.println(exportacao.exportarJSON());
    }
}
