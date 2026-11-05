package view;

import java.util.List;
import java.util.Scanner;

import controller.PessoaController;
import exception.ArquivoException;
import exception.PessoaInvalidaException;
import exception.PessoaNaoEncontradaException;
import model.Pessoa;

public class PessoaView {

    private final PessoaController controller;
    private final Scanner scanner = new Scanner(System.in);

    public PessoaView(PessoaController controller) {
        this.controller = controller;
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> atualizar();
                case 5 -> remover();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println();
        System.out.println("===== CADASTRO DE PESSOAS =====");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Buscar por ID");
        System.out.println("4 - Atualizar");
        System.out.println("5 - Remover");
        System.out.println("0 - Sair");
    }

    // ── Ações do menu ────────────────────────────────────
    private void cadastrar() {
        try {
            String nome   = lerTexto("Nome: ");
            int idade     = lerInteiro("Idade: ");
            double altura = lerDecimal("Altura (m): ");

            Pessoa p = controller.cadastrar(nome, idade, altura);
            System.out.printf("Pessoa cadastrada com ID %d.%n", p.getId());
        } catch (PessoaInvalidaException | ArquivoException e) {
            System.out.printf("Erro: %s%n", e.getMessage());
        }
    }

    private void listar() {
        List<Pessoa> pessoas = controller.listar();
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.printf("%n--- %d pessoa(s) cadastrada(s) ---%n", pessoas.size());
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }

    private void buscar() {
        try {
            int id = lerInteiro("ID: ");
            System.out.println(controller.buscar(id));
        } catch (PessoaNaoEncontradaException e) {
            System.out.printf("Erro: %s%n", e.getMessage());
        }
    }

    private void atualizar() {
        try {
            int id = lerInteiro("ID da pessoa a atualizar: ");
            System.out.printf("Atual: %s%n", controller.buscar(id));

            String nome   = lerTexto("Novo nome: ");
            int idade     = lerInteiro("Nova idade: ");
            double altura = lerDecimal("Nova altura (m): ");

            controller.atualizar(id, nome, idade, altura);
            System.out.println("Pessoa atualizada com sucesso.");
        } catch (PessoaNaoEncontradaException | PessoaInvalidaException
                 | ArquivoException e) {
            System.out.printf("Erro: %s%n", e.getMessage());
        }
    }

    private void remover() {
        try {
            int id = lerInteiro("ID da pessoa a remover: ");
            controller.remover(id);
            System.out.println("Pessoa removida com sucesso.");
        } catch (PessoaNaoEncontradaException | ArquivoException e) {
            System.out.printf("Erro: %s%n", e.getMessage());
        }
    }

    // ── Leitura segura de dados ──────────────────────────
    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private double lerDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                // aceita 1,75 e 1.75
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número (ex: 1.75).");
            }
        }
    }
}
