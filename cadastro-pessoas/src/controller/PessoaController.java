package controller;

import java.util.List;

import exception.ArquivoException;
import exception.PessoaInvalidaException;
import exception.PessoaNaoEncontradaException;
import model.Pessoa;
import repository.PessoaRepository;

public class PessoaController {

    private final PessoaRepository repositorio;

    public PessoaController(PessoaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Pessoa cadastrar(String nome, int idade, double altura)
            throws PessoaInvalidaException, ArquivoException {
        Pessoa pessoa = new Pessoa(repositorio.proximoId(), nome, idade, altura);
        repositorio.adicionar(pessoa);
        return pessoa;
    }

    public List<Pessoa> listar() {
        return repositorio.listar();
    }

    public Pessoa buscar(int id) throws PessoaNaoEncontradaException {
        return repositorio.buscarPorId(id);
    }

    public Pessoa atualizar(int id, String nome, int idade, double altura)
            throws PessoaNaoEncontradaException, PessoaInvalidaException, ArquivoException {
        Pessoa pessoa = repositorio.buscarPorId(id);

        // valida tudo em um objeto temporário antes de alterar o original
        new Pessoa(id, nome, idade, altura);

        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setAltura(altura);
        repositorio.atualizar();
        return pessoa;
    }

    public void remover(int id) throws PessoaNaoEncontradaException, ArquivoException {
        repositorio.remover(id);
    }
}
