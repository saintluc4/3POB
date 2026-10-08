package Exercicio12_codes.Exercicio1;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Exercicio1 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("ana", "carlos", "beatriz", "Antonio", "amanda", "bernardo");

        List<String> resultado = nomes.stream()
                .filter(nome -> nome.toUpperCase(Locale.ROOT).startsWith("A"))
                .map(nome -> nome.toUpperCase(Locale.ROOT))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(resultado);
    }
}
