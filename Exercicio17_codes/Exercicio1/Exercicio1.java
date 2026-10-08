package Exercicio17_codes.Exercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercicio1 {
    public static void inserirCliente(Connection conn, String nome, String email) throws SQLException {
        String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.executeUpdate();

            try (ResultSet chaves = pstmt.getGeneratedKeys()) {
                if (chaves.next()) {
                    System.out.println("Cliente inserido com ID: " + chaves.getLong(1));
                } else {
                    throw new SQLException("O banco não retornou o ID gerado.");
                }
            }
        }
    }
}
