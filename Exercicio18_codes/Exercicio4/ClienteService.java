package Exercicio18_codes.Exercicio4;

public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail não pode ser nulo ou vazio.");
        }
        if (clienteDAO.buscarPorCpf(cliente.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        clienteDAO.salvar(cliente);
    }
}
