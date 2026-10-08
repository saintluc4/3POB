package Exercicio18_codes.Exercicio3;

import java.util.List;

public interface LivroDAO {
    List<Livro> buscarPaginado(int pagina, int tamanhoPagina);
}
