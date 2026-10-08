package Exercicio16_codes.Exercicio3;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void atualizarEmail(Long id, String novoEmail) {
        Usuario usuario = repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        usuario.setEmail(novoEmail);
        repository.salvar(usuario);
    }
}
