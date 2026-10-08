package Exercicio18_codes.Exercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAOImpl implements GenericDAO<Produto, Long> {
    private final Connection conn;

    public ProdutoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    private Produto mapear(ResultSet rs) throws SQLException {
        return new Produto(rs.getLong("id"), rs.getString("descricao"),
                rs.getDouble("preco_unitario"), rs.getInt("quantidade_estoque"));
    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (descricao, preco_unitario, quantidade_estoque) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPrecoUnitario());
            pstmt.setInt(3, produto.getQuantidadeEstoque());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (!rs.next()) {
                    throw new SQLException("O banco não retornou o ID do produto.");
                }
                produto.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao salvar produto.", e);
        }
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        String sql = "SELECT id, descricao, preco_unitario, quantidade_estoque FROM produtos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao buscar produto.", e);
        }
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, descricao, preco_unitario, quantidade_estoque FROM produtos";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                produtos.add(mapear(rs));
            }
            return produtos;
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao listar produtos.", e);
        }
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET descricao = ?, preco_unitario = ?, quantidade_estoque = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPrecoUnitario());
            pstmt.setInt(3, produto.getQuantidadeEstoque());
            pstmt.setLong(4, produto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao atualizar produto.", e);
        }
    }

    @Override
    public void deletarPorId(Long id) {
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM produtos WHERE id = ?")) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao deletar produto.", e);
        }
    }
}
