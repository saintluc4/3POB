package Exercicio15_codes.Exercicio1;

public class Exercicio1 {
    public static void main(String[] args) {
        Caixa<Integer> caixaNumero = new Caixa<>();
        System.out.println("Caixa de número vazia: " + caixaNumero.isVazia());
        caixaNumero.guardar(42);
        Integer numero = caixaNumero.recuperar();
        System.out.println("Número: " + numero);

        Caixa<String> caixaTexto = new Caixa<>();
        caixaTexto.guardar("Olá, Java!");
        String texto = caixaTexto.recuperar();
        System.out.println("Texto: " + texto);

        Caixa<Produto> caixaProduto = new Caixa<>();
        caixaProduto.guardar(new Produto("Notebook"));
        Produto produto = caixaProduto.recuperar();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Caixa de produto vazia: " + caixaProduto.isVazia());

        caixaProduto.limpar();
        System.out.println("Após limpar, caixa vazia: " + caixaProduto.isVazia());
    }
}
