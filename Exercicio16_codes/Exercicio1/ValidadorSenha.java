package Exercicio16_codes.Exercicio1;

public class ValidadorSenha {
    public boolean isForte(String senha) {
        return senha != null && senha.length() >= 8
                && senha.chars().anyMatch(Character::isDigit)
                && senha.chars().anyMatch(Character::isUpperCase);
    }
}
