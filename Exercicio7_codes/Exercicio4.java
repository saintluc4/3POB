package Exercicio7_codes;
import java.util.Scanner;

class Carro {

    private String modelo;
    private int    ano;
    private int    velocidadeAtual = 0;

    // construtor — recebe modelo e ano
    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano    = ano;
    }

    // ── Getters para todos ────────────────────────────────
    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    // ── Setter apenas para modelo ─────────────────────────
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // ── Getter booleano ───────────────────────────────────
    public boolean isEmMovimento() {
        return velocidadeAtual > 0;
    }

    // ── Métodos operacionais ──────────────────────────────
    public void acelerar(int incremento) {
        if (incremento > 0) {
            velocidadeAtual += incremento;
            System.out.printf("Acelerou! Velocidade atual: %d km/h%n", velocidadeAtual);
        } else {
            System.out.println("Aviso: incremento deve ser maior que zero.");
        }
    }

    public void frear(int decremento) {
        if (decremento > 0) {
            velocidadeAtual = Math.max(0, velocidadeAtual - decremento);
            System.out.printf("Freou! Velocidade atual: %d km/h%n", velocidadeAtual);
        } else {
            System.out.println("Aviso: decremento deve ser maior que zero.");
        }
    }

    public void exibirStatus() {
        System.out.println("=============================");
        System.out.printf("Modelo:     %s%n",    modelo);
        System.out.printf("Ano:        %d%n",    ano);
        System.out.printf("Velocidade: %d km/h%n", velocidadeAtual);
        System.out.printf("Movimento:  %s%n",    isEmMovimento() ? "Sim" : "Não");
        System.out.println("=============================");
    }
}

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        Carro carro = new Carro(modelo, ano);

        System.out.println("\n===== Status inicial =====");
        carro.exibirStatus();

        System.out.println("===== Acelerando =====");
        carro.acelerar(40);
        carro.acelerar(30);
        carro.exibirStatus();

        System.out.println("===== Freando =====");
        carro.frear(20);
        carro.exibirStatus();

        // tenta frear além de zero
        System.out.println("===== Freando além do limite =====");
        carro.frear(999);
        carro.exibirStatus();

        // testa incremento inválido
        System.out.println("===== Aceleração inválida =====");
        carro.acelerar(-10);

        scanner.close();
    }
}