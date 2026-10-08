package Exercicio7_codes;

class Produto {


    private String nome;
    private double preco;
    private int    quantidadeEstoque;


    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }


    public Produto(String nome, double preco) {
        this(nome, preco, 0);
    }


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: preço não pode ser negativo. Valor ignorado.");
        }
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque >= 0) {
            this.quantidadeEstoque = quantidadeEstoque;
        } else {
            System.out.println("Erro: estoque não pode ser negativo. Valor ignorado.");
        }
    }


    public double calcularValorTotalEmEstoque() {
        return preco * quantidadeEstoque;
    }

    public void exibirInformacoes() {
        System.out.printf("Nome:             %s%n",    nome);
        System.out.printf("Preço:            R$ %.2f%n", preco);
        System.out.printf("Estoque:          %d un.%n", quantidadeEstoque);
        System.out.printf("Total em estoque: R$ %.2f%n", calcularValorTotalEmEstoque());
        System.out.println("-----------------------------");
    }
}

public class Exercicio1 {

    public static void main(String[] args) {


        Produto produtoA = new Produto("Notebook", 3500.00, 15);


        Produto produtoB = new Produto("Mouse", 150.00);

        System.out.println("===== Produto A =====");
        produtoA.exibirInformacoes();

        System.out.println("===== Produto B =====");
        produtoB.exibirInformacoes();


        System.out.println("===== Teste de validação =====");
        System.out.printf("Preço atual do Produto A: R$ %.2f%n", produtoA.getPreco());
        produtoA.setPreco(-10.0);
        System.out.printf("Preço após setPreco(-10): R$ %.2f%n", produtoA.getPreco());
    }
}