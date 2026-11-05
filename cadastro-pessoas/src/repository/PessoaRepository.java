package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.ArquivoException;
import exception.PessoaInvalidaException;
import exception.PessoaNaoEncontradaException;
import model.Pessoa;

public class PessoaRepository {

    private static final String CABECALHO = "id;nome;idade;altura";

    private final String caminhoArquivo;
    private final ArrayList<Pessoa> pessoas = new ArrayList<>();

    public PessoaRepository(String caminhoArquivo) throws ArquivoException {
        this.caminhoArquivo = caminhoArquivo;
        carregar();
    }

    // ── Persistência ─────────────────────────────────────
    private void carregar() throws ArquivoException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            return; // primeira execução: começa com lista vazia
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha = leitor.readLine(); // pula o cabeçalho
            int numeroLinha = 1;
            while ((linha = leitor.readLine()) != null) {
                numeroLinha++;
                if (linha.trim().isEmpty()) {
                    continue;
                }
                try {
                    pessoas.add(Pessoa.fromCsv(linha));
                } catch (PessoaInvalidaException e) {
                    throw new ArquivoException(
                        String.format("Erro na linha %d de %s: %s",
                                      numeroLinha, caminhoArquivo, e.getMessage()), e);
                }
            }
        } catch (IOException e) {
            throw new ArquivoException(
                String.format("Não foi possível ler o arquivo %s", caminhoArquivo), e);
        }
    }

    private void salvar() throws ArquivoException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            escritor.write(CABECALHO);
            escritor.newLine();
            for (Pessoa p : pessoas) {
                escritor.write(p.toCsv());
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new ArquivoException(
                String.format("Não foi possível gravar o arquivo %s", caminhoArquivo), e);
        }
    }

    // ── Operações (CRUD) ─────────────────────────────────
    public int proximoId() {
        int maior = 0;
        for (Pessoa p : pessoas) {
            if (p.getId() > maior) {
                maior = p.getId();
            }
        }
        return maior + 1;
    }

    public void adicionar(Pessoa pessoa) throws ArquivoException {
        pessoas.add(pessoa);
        salvar();
    }

    public List<Pessoa> listar() {
        return new ArrayList<>(pessoas); // cópia: protege a lista interna
    }

    public Pessoa buscarPorId(int id) throws PessoaNaoEncontradaException {
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new PessoaNaoEncontradaException(id);
    }

    public void atualizar() throws ArquivoException {
        salvar(); // o objeto já foi alterado na lista; só persiste
    }

    public void remover(int id) throws PessoaNaoEncontradaException, ArquivoException {
        Pessoa p = buscarPorId(id);
        pessoas.remove(p);
        salvar();
    }
}
