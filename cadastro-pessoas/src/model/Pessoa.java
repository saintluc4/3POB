package model;

import java.util.Locale;

import exception.PessoaInvalidaException;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(int id, String nome, int idade, double altura)
            throws PessoaInvalidaException {
        setId(id);
        setNome(nome);
        setIdade(idade);
        setAltura(altura);
    }

    // ── Getters ──────────────────────────────────────────
    public int getId()        { return id; }
    public String getNome()   { return nome; }
    public int getIdade()     { return idade; }
    public double getAltura() { return altura; }

    // ── Setters com validação ────────────────────────────
    public void setId(int id) throws PessoaInvalidaException {
        if (id <= 0) {
            throw new PessoaInvalidaException("O ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public void setNome(String nome) throws PessoaInvalidaException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new PessoaInvalidaException("O nome não pode ser vazio.");
        }
        if (nome.contains(";")) {
            throw new PessoaInvalidaException("O nome não pode conter ponto e vírgula (;).");
        }
        this.nome = nome.trim();
    }

    public void setIdade(int idade) throws PessoaInvalidaException {
        if (idade < 0 || idade > 150) {
            throw new PessoaInvalidaException("A idade deve estar entre 0 e 150.");
        }
        this.idade = idade;
    }

    public void setAltura(double altura) throws PessoaInvalidaException {
        if (altura <= 0 || altura > 3.0) {
            throw new PessoaInvalidaException("A altura deve estar entre 0 e 3.0 metros.");
        }
        this.altura = altura;
    }

    // ── Conversão de/para linha do CSV ───────────────────
    public String toCsv() {
        // Locale.US garante ponto decimal (1.75) e não vírgula
        return String.format(Locale.US, "%d;%s;%d;%.2f", id, nome, idade, altura);
    }

    public static Pessoa fromCsv(String linha) throws PessoaInvalidaException {
        String[] campos = linha.split(";");
        if (campos.length != 4) {
            throw new PessoaInvalidaException("Linha com quantidade de campos inválida.");
        }
        try {
            int id        = Integer.parseInt(campos[0].trim());
            String nome   = campos[1];
            int idade     = Integer.parseInt(campos[2].trim());
            double altura = Double.parseDouble(campos[3].trim());
            return new Pessoa(id, nome, idade, altura);
        } catch (NumberFormatException e) {
            throw new PessoaInvalidaException("Valor numérico inválido na linha.");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Nome: %-20s | Idade: %-3d | Altura: %.2f m",
                             id, nome, idade, altura);
    }
}
