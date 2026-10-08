package Exercicio14_codes.Exercicio1;

public class Exercicio1 {
    public static void main(String[] args) {
        Thread crescente = new Thread(new ContadorCrescente());
        Thread regressivo = new Thread(new ContadorRegressivo());

        crescente.start();
        regressivo.start();

        try {
            crescente.join();
            regressivo.join();
            System.out.println("Contagens finalizadas!");
        } catch (InterruptedException e) {
            crescente.interrupt();
            regressivo.interrupt();
            Thread.currentThread().interrupt();
            System.out.println("Espera pelas contagens interrompida.");
        }
    }
}
