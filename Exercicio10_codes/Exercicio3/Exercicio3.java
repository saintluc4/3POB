package Exercicio10_codes.Exercicio3;

public class Exercicio3 {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("001", 500.00);

        try {
            conta.sacar(200.00);
            conta.sacar(400.00);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
