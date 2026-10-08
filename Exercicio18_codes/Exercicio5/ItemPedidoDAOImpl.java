package Exercicio18_codes.Exercicio5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ItemPedidoDAOImpl implements ItemPedidoDAO {
    @Override
    public void salvarItens(Connection conn, long pedidoId, List<ItemPedido> itens) throws SQLException {
        String sql = "INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (ItemPedido item : itens) {
                pstmt.setLong(1, pedidoId);
                pstmt.setLong(2, item.getProdutoId());
                pstmt.setInt(3, item.getQuantidade());
                pstmt.setDouble(4, item.getPrecoUnitario());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }
}
