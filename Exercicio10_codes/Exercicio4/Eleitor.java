package Exercicio10_codes.Exercicio4;

public class Eleitor {
    public void cadastrar(String nome, int idade) {
        if (idade < 0 || idade > 130) {
            throw new IdadeInvalidaException(
                    "Idade inválida: " + idade + ". A idade deve estar entre 0 e 130 anos.");
        }

        System.out.printf("Eleitor %s cadastrado com %d anos.%n", nome, idade);
    }
}
