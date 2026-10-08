package Exercicio16_codes.Exercicio1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorSenhaTest {
    private final ValidadorSenha validador = new ValidadorSenha();

    @ParameterizedTest
    @ValueSource(strings = {"Senha123", "Java2026", "A1234567", "SEGURA99"})
    void deveAceitarSenhasFortes(String senha) {
        assertTrue(validador.isForte(senha));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Abc1234", "SenhaForte", "senha123", "12345678", "        "})
    void deveRejeitarSenhasFracas(String senha) {
        assertFalse(validador.isForte(senha));
    }
}
