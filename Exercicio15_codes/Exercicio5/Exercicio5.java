package Exercicio15_codes.Exercicio5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio5 {
    public static <T> void copiarElementos(List<? extends T> origem, List<? super T> destino) {

        for (T elemento : origem) {

            destino.add(elemento);
        }
    }

    public static void main(String[] args) {
        List<Integer> origem = Arrays.asList(1, 2, 3);
        List<Number> numeros = new ArrayList<>();
        List<Object> objetos = new ArrayList<>();

        copiarElementos(origem, numeros);
        copiarElementos(origem, objetos);

        System.out.println("Origem (Integer): " + origem);
        System.out.println("Destino (Number): " + numeros);
        System.out.println("Destino (Object): " + objetos);
    }
}
