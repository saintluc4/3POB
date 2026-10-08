package Exercicio14_codes.Exercicio1;

public class ContadorCrescente implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Crescente: " + i);
                if (i < 10) {
                    Thread.sleep(200);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
