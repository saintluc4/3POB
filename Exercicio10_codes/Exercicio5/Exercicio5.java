package Exercicio10_codes.Exercicio5;

public class Exercicio5 {
    public static void main(String[] args) {
        ServicoArquivo servico = new ServicoArquivo();
        String[] caminhos = {"dados.txt", null, ""};

        for (String caminho : caminhos) {
            try {
                servico.processarArquivo(caminho);
            } catch (ProcessamentoDadosException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Motivo raiz: " + e.getCause().getMessage());
            }
        }
    }
}
