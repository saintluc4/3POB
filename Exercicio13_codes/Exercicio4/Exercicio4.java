package Exercicio13_codes.Exercicio4;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class Exercicio4 {
    public static void main(String[] args) {
        Path diretorio = Path.of(".");

        try (Stream<Path> caminhos = Files.walk(diretorio)) {
            Iterator<Path> arquivosJava = caminhos
                    .filter(Files::isRegularFile)
                    .filter(caminho -> caminho.getFileName().toString().endsWith(".java"))
                    .iterator();

            long tamanhoTotal = 0;
            while (arquivosJava.hasNext()) {
                Path arquivo = arquivosJava.next();
                long tamanho = Files.size(arquivo);
                tamanhoTotal += tamanho;
                System.out.printf("%s | %d bytes%n", diretorio.relativize(arquivo), tamanho);
            }

            System.out.printf("Tamanho total dos arquivos Java: %d bytes%n", tamanhoTotal);
        } catch (IOException | UncheckedIOException e) {
            System.out.println("Erro ao percorrer o diretório: " + e.getMessage());
        }
    }
}
