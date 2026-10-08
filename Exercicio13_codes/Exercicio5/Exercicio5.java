package Exercicio13_codes.Exercicio5;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio5 {
    public static void main(String[] args) {
        Path entrada = Path.of("clientes_bruto.txt");
        Path saida = Path.of("clientes_padronizado.txt");

        try (Stream<String> linhas = Files.lines(entrada)) {
            List<String> clientes = linhas
                    .map(String::trim)
                    .filter(linha -> !linha.isBlank())
                    .map(nome -> nome.toUpperCase(Locale.ROOT))
                    .collect(Collectors.toList());

            Files.write(saida, clientes,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Clientes padronizados gravados em " + saida);
        } catch (IOException | UncheckedIOException e) {
            System.out.println("Erro ao processar os clientes: " + e.getMessage());
        }
    }
}
