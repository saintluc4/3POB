package Exercicio14_codes.Exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercicio3 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<String>> resultados = new ArrayList<>();

        try {
            for (int id = 1; id <= 6; id++) {
                resultados.add(pool.submit(new TarefaDownload(id)));
            }

            for (Future<String> resultado : resultados) {
                System.out.println(resultado.get());
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Downloads interrompidos.");
        } catch (ExecutionException e) {
            System.out.println("Erro no download: " + e.getCause().getMessage());
        } finally {
            pool.shutdown();
        }
    }
}
