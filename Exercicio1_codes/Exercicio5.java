package Exercicio1_codes;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o total de segundos: ");
        int totalSegundos = scanner.nextInt();

        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;

        System.out.println(horas + " hora(s), " + minutos + " minuto(s) e " + segundos + " segundo(s)");

        scanner.close();
    }
}