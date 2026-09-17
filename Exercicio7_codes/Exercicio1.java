package Exercicio7_codes;

class Produto {

    // atributos privados — ninguém acessa diretamente de fora
    private String nome;
    private double preco;
    private int    quantidadeEstoque;

    // construtor completo — 3 parâmetros
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        setPreco(preco);                         // já usa o setter com validação
        setQuantidadeEstoque(quantidadeEstoque); // já usa o setter com validação
    }

    // construtor sobrecarregado — 2 parâmetros, estoque começa em 0
    public Produto(String nome, double preco) {
        this(nome, preco, 0); // chama o construtor completo acima
    }

    // ── Getters ──────────────────────────────────────────
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // ── Setters com validação ─────────────────────────────
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

    // ── Método de negócio ─────────────────────────────────
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

        // Produto A — construtor completo (3 parâmetros)
        Produto produtoA = new Produto("Notebook", 3500.00, 15);

        // Produto B — construtor sobrecarregado (2 parâmetros)
        Produto produtoB = new Produto("Mouse", 150.00);

        System.out.println("===== Produto A =====");
        produtoA.exibirInformacoes();

        System.out.println("===== Produto B =====");
        produtoB.exibirInformacoes();

        // tentativa de preço negativo — deve ser bloqueada
        System.out.println("===== Teste de validação =====");
        System.out.printf("Preço atual do Produto A: R$ %.2f%n", produtoA.getPreco());
        produtoA.setPreco(-10.0);
        System.out.printf("Preço após setPreco(-10): R$ %.2f%n", produtoA.getPreco());
    }
}