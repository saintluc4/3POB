package Exercicio11_codes.Exercicio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> frequencias = new HashMap<>();

        System.out.print("Digite um texto: ");
        String texto = scanner.nextLine().toLowerCase().trim();

        if (!texto.isEmpty()) {
            String[] palavras = texto.split("\\s+");
            for (String palavra : palavras) {
                frequencias.put(palavra, frequencias.getOrDefault(palavra, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entrada : frequencias.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }

        scanner.close();
    }
}
