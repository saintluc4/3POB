package Exercicio9_codes.Exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaCorrente("001", 1000.00));
        contas.add(new ContaEmpresarial("002", 2000.00));

        for (ContaBancaria conta : contas) {
            conta.depositar(100.00);
        }

        System.out.println("===== Virada de mes =====");
        for (ContaBancaria conta : contas) {
            conta.cobrarTaxaMensal();
            System.out.printf("Conta %s | Saldo: R$ %.2f%n",
                    conta.getNumero(), conta.consultarSaldo());
        }
    }
}
