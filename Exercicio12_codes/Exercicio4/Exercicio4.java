package Exercicio12_codes.Exercicio4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio4 {
    public static List<String> processarLista(List<String> lista, TransformadorTexto regra) {
        return lista.stream()
                .map(regra::transformar)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> textos = Arrays.asList("java", "streams", "lambda");

        System.out.println("Invertidos: " + processarLista(textos,
                texto -> new StringBuilder(texto).reverse().toString()));
        System.out.println("Entre colchetes: " + processarLista(textos,
                texto -> "[" + texto + "]"));
        System.out.println("Caixa alta: " + processarLista(textos, String::toUpperCase));
    }
}
