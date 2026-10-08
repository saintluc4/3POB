package Exercicio10_codes.Exercicio4;

public class Exercicio4 {
    public static void main(String[] args) {
        Eleitor eleitor = new Eleitor();
        int[] idades = {18, -1, 131, 0, 130};

        for (int idade : idades) {
            try {
                eleitor.cadastrar("Ana", idade);
            } catch (IdadeInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
