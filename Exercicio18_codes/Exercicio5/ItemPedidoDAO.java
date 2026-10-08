package Exercicio18_codes.Exercicio5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemPedidoDAO {
    void salvarItens(Connection conn, long pedidoId, List<ItemPedido> itens) throws SQLException;
}
