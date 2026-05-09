package com.sv22T1020761.dp.compositesample;

import java.sql.*;

public class DatabaseManager {

    private final String dbUrl =
            "jdbc:sqlserver://localhost:1433;databaseName=composite_file_system_db;encrypt=false;trustServerCertificate=true";

    private final String dbUser = "sa";
    private final String dbPass = "sa";

    public DatabaseManager() {
        try {
            // Load driver (quan trọng với nhiều máy)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy SQL Server Driver", e);
        }
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPass);
    }

    public void createTables() throws SQLException {
        String sql =
                "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='items' AND xtype='U') " +
                "BEGIN " +
                "CREATE TABLE items (" +
                "id INT IDENTITY(1,1) PRIMARY KEY, " +
                "name NVARCHAR(255) NOT NULL, " +
                "type NVARCHAR(10) NOT NULL CHECK(type IN ('FILE', 'FOLDER')), " +
                "size BIGINT NOT NULL DEFAULT 0, " +
                "parent_id INT NULL, " +
                "last_modified DATETIME DEFAULT GETDATE(), " +
                "CONSTRAINT FK_Items_Parent FOREIGN KEY(parent_id) REFERENCES items(id) " +
                ") " +
                "END";

        try (Connection conn = openConnection();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        }
    }

    public void clearData() throws SQLException {
        try (Connection conn = openConnection();
             Statement st = conn.createStatement()) {

            // Xóa theo thứ tự để tránh lỗi FK
            st.executeUpdate("DELETE FROM items WHERE parent_id IS NOT NULL");
            st.executeUpdate("DELETE FROM items WHERE parent_id IS NULL");
        }
    }
}