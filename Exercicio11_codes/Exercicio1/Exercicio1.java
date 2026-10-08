package Exercicio11_codes.Exercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        List<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite a tarefa " + (i + 1) + ": ");
            tarefas.add(scanner.nextLine());
        }

        System.out.print("Digite o nome da tarefa a remover: ");
        if (tarefas.remove(scanner.nextLine())) {
            System.out.println("Tarefa removida.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }

        System.out.print("Digite a tarefa a buscar: ");
        if (tarefas.contains(scanner.nextLine())) {
            System.out.println("Tarefa encontrada.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }

        Collections.sort(tarefas);
        System.out.println("Tarefas em ordem alfabética:");
        for (String tarefa : tarefas) {
            System.out.println("- " + tarefa);
        }

        scanner.close();
    }
}
