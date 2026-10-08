package Exercicio18_codes.Exercicio4;

import java.util.Optional;

public interface ClienteDAO {
    Optional<Cliente> buscarPorCpf(String cpf);
    void salvar(Cliente cliente);
}
