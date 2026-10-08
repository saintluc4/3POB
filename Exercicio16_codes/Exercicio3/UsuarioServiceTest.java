package Exercicio16_codes.Exercicio3;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveAtualizarEmailESalvarUsuario() {
        Usuario usuarioExistente = new Usuario(1L, "antigo@email.com");
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(usuarioExistente));

        service.atualizarEmail(1L, "novo@email.com");

        assertEquals("novo@email.com", usuarioExistente.getEmail());
        verify(repository, times(1)).salvar(any(Usuario.class));
        verify(repository).salvar(usuarioExistente);
    }

    @Test
    void naoDeveSalvarUsuarioInexistente() {
        when(repository.buscarPorId(2L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> service.atualizarEmail(2L, "novo@email.com"));
        verify(repository, never()).salvar(any(Usuario.class));
    }
}
