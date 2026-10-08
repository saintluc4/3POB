package Exercicio16_codes.Exercicio3;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(Long id);
    void salvar(Usuario usuario);
}
