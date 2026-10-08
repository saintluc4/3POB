package Exercicio18_codes.Exercicio1;

public class Aluno {
    private Long id;
    private String nome;
    private String matricula;

    public Aluno(Long id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
}
