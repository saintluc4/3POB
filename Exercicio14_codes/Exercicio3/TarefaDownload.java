package Exercicio14_codes.Exercicio3;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TarefaDownload implements Callable<String> {
    private int id;

    public TarefaDownload(int id) {
        this.id = id;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1501));
        return "Arquivo " + id + " processado pela thread: " + Thread.currentThread().getName();
    }
}
