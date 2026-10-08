package Exercicio17_codes.Exercicio5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercicio5 {
    public static void transferirFundos(Connection conn, Long idOrigem, Long idDestino, double valor)
            throws SQLException {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser positivo e finito.");
        }

        boolean autoCommitOriginal = conn.getAutoCommit();
        if (!autoCommitOriginal) {
            throw new SQLException("A conexão já está em modo de transação manual.");
        }

        conn.setAutoCommit(false);
        boolean transacaoEncerrada = false;
        Throwable falha = null;

        try {
            String debito = "UPDATE contas SET saldo = saldo - ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(debito)) {
                pstmt.setDouble(1, valor);
                pstmt.setLong(2, idOrigem);
                if (pstmt.executeUpdate() != 1) {
                    throw new SQLException("Conta de origem não encontrada.");
                }
            }

            String consulta = "SELECT saldo FROM contas WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setLong(1, idOrigem);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.next()) {
                        throw new SQLException("Conta de origem não encontrada.");
                    }
                    double saldo = rs.getDouble("saldo");
                    if (rs.wasNull() || saldo < 0) {
                        throw new IllegalStateException("Saldo insuficiente para realizar a transferência.");
                    }
                }
            }

            String credito = "UPDATE contas SET saldo = saldo + ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(credito)) {
                pstmt.setDouble(1, valor);
                pstmt.setLong(2, idDestino);
                if (pstmt.executeUpdate() != 1) {
                    throw new SQLException("Conta de destino não encontrada.");
                }
            }

            conn.commit();
            transacaoEncerrada = true;
        } catch (SQLException | RuntimeException e) {
            falha = e;
            try {
                conn.rollback();
                transacaoEncerrada = true;
            } catch (SQLException erroRollback) {
                e.addSuppressed(erroRollback);
            }
            throw e;
        } finally {
            if (transacaoEncerrada) {
                try {
                    conn.setAutoCommit(autoCommitOriginal);
                } catch (SQLException erroRestauracao) {
                    if (falha != null) {
                        falha.addSuppressed(erroRestauracao);
                    } else {
                        throw erroRestauracao;
                    }
                }
            }
        }
    }
}
