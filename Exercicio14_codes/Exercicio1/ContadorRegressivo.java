package Exercicio14_codes.Exercicio1;

public class ContadorRegressivo implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 10; i >= 1; i--) {
                System.out.println("Regressivo: " + i);
                if (i > 1) {
                    Thread.sleep(300);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
