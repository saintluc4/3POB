package Exercicio15_codes.Exercicio2;

public class Exercicio2 {
    public static void main(String[] args) {
        Par<Integer, String> p1 = new Par<>(1, "Ativo");
        Par<Integer, String> p2 = new Par<>(1, "Ativo");
        Par<Integer, String> p3 = new Par<>(2, "Inativo");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("p1 e p2 são iguais: " + Par.saoIguais(p1, p2));
        System.out.println("p1 e p3 são iguais: " + Par.saoIguais(p1, p3));
    }
}
