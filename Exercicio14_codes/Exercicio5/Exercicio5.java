package Exercicio14_codes.Exercicio5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class Exercicio5 {
    public static void main(String[] args) {
        CompletableFuture<Double> passagens = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CompletionException(e);
            }
            return 1500.00;
        });

        CompletableFuture<Double> hospedagem = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CompletionException(e);
            }
            return 900.00;
        });

        CompletableFuture<String> pacote = passagens.thenCombine(hospedagem,
                (valorPassagens, valorHospedagem) -> String.format(
                        "Pacote de viagem | Passagens: R$ %.2f | Hospedagem: R$ %.2f | Total: R$ %.2f",
                        valorPassagens, valorHospedagem, valorPassagens + valorHospedagem))
                .exceptionally(erro -> "Não foi possível montar o pacote: " + erro.getMessage());

        System.out.println(pacote.join());
    }
}
