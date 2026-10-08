package Exercicio13_codes.Exercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Exercicio1 {
    public static void main(String[] args) {
        Path diretorio = Path.of("dados", "relatorios");
        Path arquivo = diretorio.resolve("sumario.txt");

        try {
            if (!Files.exists(diretorio)) {
                Files.createDirectories(diretorio);
            }

            String relatorio = "===== Sumário da execução =====\n"
                    + "Data e hora: " + LocalDateTime.now() + "\n"
                    + "Status: sistema executado com sucesso.\n";

            Files.writeString(arquivo, relatorio,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo criado em " + arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gravar o relatório: " + e.getMessage());
        }
    }
}
