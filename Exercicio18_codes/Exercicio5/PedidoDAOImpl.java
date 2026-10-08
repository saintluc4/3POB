package Exercicio18_codes.Exercicio5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public long criarPedido(Connection conn, Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedidos (cliente_id, total) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, pedido.getClienteId());
            pstmt.setDouble(2, pedido.getTotal());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (!rs.next()) {
                    throw new SQLException("O banco não retornou o ID do pedido.");
                }
                return rs.getLong(1);
            }
        }
    }
}
