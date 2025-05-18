package com.example.mottu_challenge.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = OracleConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Conexão com o Oracle estabelecida com sucesso!");
            } else {
                System.out.println("❌ Falha ao conectar no banco.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro de conexão: " + e.getMessage());
        }
    }
}
