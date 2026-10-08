package Exercicio14_codes.Exercicio4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class Exercicio4 {
    public static void main(String[] args) {
        int pedidoId = 101;

        CompletableFuture<Void> checkout = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CompletionException(e);
            }
            return new Pedido(pedidoId, 200.00);
        }).thenApply(pedido -> {

            double frete = pedido.getTotal() * 0.10;
            pedido.adicionarFrete(frete);
            return pedido;
        }).thenAccept(pedido -> {
            System.out.println("Envio de e-mail simulado: confirmação do pedido " + pedido.getId());
            System.out.printf("Checkout concluído com sucesso! Total com frete: R$ %.2f%n",
                    pedido.getTotal());
        });

        System.out.println("Thread principal: atualizando a tela enquanto o checkout é processado.");
        System.out.println("Thread principal: exibindo outros produtos.");


        try {
            checkout.join();
        } catch (CompletionException e) {
            System.out.println("Erro no checkout: " + e.getCause().getMessage());
        }
    }
}
