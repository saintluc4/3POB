package Exercicio14_codes.Exercicio2;

import java.util.concurrent.CountDownLatch;

public class Exercicio2 {
    private static int executarContagem(boolean sincronizar) throws InterruptedException {
        ContadorAcessos contador = new ContadorAcessos();
        CountDownLatch inicio = new CountDownLatch(1);
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    inicio.await();
                    for (int j = 0; j < 1000; j++) {
                        if (sincronizar) {
                            contador.incrementarSincronizado();
                        } else {
                            contador.incrementarSemSincronizacao();
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads[i].start();
        }

        inicio.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        return contador.getAcessos();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Sem sincronização: " + executarContagem(false));

            int totalSincronizado = executarContagem(true);
            System.out.println("Com sincronização: " + totalSincronizado);
            System.out.println("Atingiu exatamente 5000 acessos: " + (totalSincronizado == 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Contagem interrompida.");
        }
    }
}
