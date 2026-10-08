package Exercicio13_codes.Exercicio3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Exercicio3 {
    public static void main(String[] args) {
        Path arquivo = Path.of("produtos.csv");

        try {
            List<String> linhas = Files.readAllLines(arquivo);
            double totalInventario = 0;

            for (int i = 1; i < linhas.size(); i++) {
                String[] campos = linhas.get(i).split(",", -1);
                if (campos.length != 3) {
                    throw new NumberFormatException("Linha " + (i + 1)
                            + " deve conter Nome,Quantidade,PrecoUnitario.");
                }

                String nome = campos[0].trim();
                int quantidade = Integer.parseInt(campos[1].trim());
                double precoUnitario = Double.parseDouble(campos[2].trim());
                double totalItem = quantidade * precoUnitario;
                totalInventario += totalItem;

                System.out.printf("%s | Total: R$ %.2f%n", nome, totalItem);
            }

            System.out.printf("Total do inventário: R$ %.2f%n", totalInventario);
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato no CSV: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler o CSV: " + e.getMessage());
        }
    }
}
