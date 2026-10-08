package Exercicio16_codes.Exercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {
    private ContaBancaria conta;

    @BeforeEach
    void prepararConta() {
        conta = new ContaBancaria(100.00);
    }

    @Test
    void deveDepositar() {
        conta.depositar(50.00);
        assertEquals(150.00, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacar() throws SaldoInsuficienteException {
        conta.sacar(40.00);
        assertEquals(60.00, conta.getSaldo(), 0.001);
    }

    @Test
    void devePermitirSaqueDeTodoSaldo() throws SaldoInsuficienteException {
        conta.sacar(100.00);
        assertEquals(0.00, conta.getSaldo(), 0.001);
    }

    @Test
    void deveRejeitarSaqueAcimaDoSaldo() {
        SaldoInsuficienteException erro = assertThrows(
                SaldoInsuficienteException.class, () -> conta.sacar(150.00));
        assertEquals("Saldo insuficiente para realizar o saque.", erro.getMessage());
        assertEquals(100.00, conta.getSaldo(), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -10.0})
    void deveRejeitarSaqueNaoPositivo(double valor) {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class, () -> conta.sacar(valor));
        assertEquals("O valor do saque deve ser maior que zero.", erro.getMessage());
        assertEquals(100.00, conta.getSaldo(), 0.001);
    }
}
