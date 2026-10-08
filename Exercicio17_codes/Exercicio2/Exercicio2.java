package Exercicio17_codes.Exercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exercicio2 {
    public static List<Produto> buscarPorFaixaPreco(Connection conn, double min, double max)
            throws SQLException {
        String sql = "SELECT id, nome, preco, estoque FROM produtos WHERE preco BETWEEN ? AND ?";
        List<Produto> produtos = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, min);
            pstmt.setDouble(2, max);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    Double preco = rs.getDouble("preco");
                    if (rs.wasNull()) {
                        preco = null;
                    }
                    Integer estoque = rs.getInt("estoque");
                    if (rs.wasNull()) {
                        estoque = null;
                    }
                    produtos.add(new Produto(id, nome, preco, estoque));
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar produtos por faixa de preço.", e);
        }

        return produtos;
    }
}
