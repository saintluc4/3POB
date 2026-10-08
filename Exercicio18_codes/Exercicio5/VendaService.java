package Exercicio18_codes.Exercicio5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

public class VendaService {
    private final DataSource dataSource;
    private final PedidoDAO pedidoDAO;
    private final ItemPedidoDAO itemPedidoDAO;

    public VendaService(DataSource dataSource, PedidoDAO pedidoDAO, ItemPedidoDAO itemPedidoDAO) {
        this.dataSource = dataSource;
        this.pedidoDAO = pedidoDAO;
        this.itemPedidoDAO = itemPedidoDAO;
    }

    public long registrarVenda(Pedido pedido, List<ItemPedido> itens) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try {
                long pedidoId = pedidoDAO.criarPedido(conn, pedido);
                itemPedidoDAO.salvarItens(conn, pedidoId, itens);
                conn.commit();
                return pedidoId;
            } catch (SQLException | RuntimeException e) {
                try {
                    conn.rollback();
                } catch (SQLException erroRollback) {
                    e.addSuppressed(erroRollback);
                }
                throw e;
            }
        }
    }
}
