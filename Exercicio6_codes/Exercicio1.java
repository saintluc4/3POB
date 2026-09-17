package Exercicio6_codes;
import java.util.Scanner;

class Livro{
    String titulo;
    String autor;
    int numeroPaginas;


    void exibirInformacoes(){
        System.out.printf("Titulo: %s%n", titulo);
        System.out.printf("Autor: %s%n", autor);
        System.out.printf("Paginas: %d%n", numeroPaginas);
        System.out.printf("-----%n");
    }
}


public class Exercicio1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Livro livro1 = new Livro();
        System.out.println("=== Livro 1 ===");
        System.out.print("Digite o título: ");
        livro1.titulo = scanner.nextLine();
        System.out.print("Digite o autor: ");
        livro1.autor = scanner.nextLine();
        System.out.print("Digite o número de páginas: ");
        livro1.numeroPaginas = scanner.nextInt();
        scanner.nextLine();

        Livro livro2 = new Livro();
        System.out.println("=== Livro 2 ===");
        System.out.print("Digite o título: ");
        livro2.titulo = scanner.nextLine();
        System.out.print("Digite o autor: ");
        livro2.autor = scanner.nextLine();
        System.out.print("Digite o número de páginas: ");
        livro2.numeroPaginas = scanner.nextInt();

        System.out.printf("%n=== Informações dos Livros ===%n");
        livro1.exibirInformacoes();
        livro2.exibirInformacoes();

        scanner.close();
    }
}
