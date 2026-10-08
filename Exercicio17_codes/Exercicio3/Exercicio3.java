package Exercicio17_codes.Exercicio3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercicio3 {
    public static void atualizarSalario(Connection conn, Long id, double novoSalario) throws SQLException {
        String sql = "UPDATE funcionarios SET salario = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, novoSalario);
            pstmt.setLong(2, id);
            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            } else {
                System.out.println("Registros atualizados: " + linhasAfetadas);
            }
        }
    }

    public static void deletarPorId(Connection conn, Long id) throws SQLException {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            } else {
                System.out.println("Registros excluídos: " + linhasAfetadas);
            }
        }
    }
}
