import controller.PessoaController;
import exception.ArquivoException;
import repository.PessoaRepository;
import view.PessoaView;

public class Main {

    public static void main(String[] args) {
        try {
            PessoaRepository repositorio = new PessoaRepository("pessoas.csv");
            PessoaController controller  = new PessoaController(repositorio);
            PessoaView view              = new PessoaView(controller);
            view.iniciar();
        } catch (ArquivoException e) {
            System.out.printf("Falha ao iniciar o sistema: %s%n", e.getMessage());
        }
    }
}
