package com.example.mottu_challenge.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl"; // ou seu SID
    private static final String USER = "rm554945";
    private static final String PASSWORD = "020797";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
