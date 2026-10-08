package Exercicio10_codes.Exercicio5;

import java.io.IOException;

public class ServicoArquivo {
    public void processarArquivo(String caminho) throws ProcessamentoDadosException {
        try {
            if (caminho == null || caminho.isEmpty()) {
                throw new IOException("O caminho do arquivo não pode ser nulo ou vazio.");
            }

            // Processamento simulado, sem acessar um arquivo real.
            System.out.println("Arquivo processado: " + caminho);
        } catch (IOException e) {
            throw new ProcessamentoDadosException("Falha ao processar o arquivo.", e);
        }
    }
}
