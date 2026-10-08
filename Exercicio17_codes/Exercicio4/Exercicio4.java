package Exercicio17_codes.Exercicio4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Exercicio4 {
    public static void inserirLoteLog(Connection conn, List<String> mensagensLog) throws SQLException {
        String sql = "INSERT INTO logs_sistema (mensagem, data_registro) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (String mensagem : mensagensLog) {
                pstmt.setString(1, mensagem);
                pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }
}
