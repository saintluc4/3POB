package Exercicio18_codes.Exercicio3;

public class Livro {
    private Long id;
    private String titulo;

    public Livro(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
}
