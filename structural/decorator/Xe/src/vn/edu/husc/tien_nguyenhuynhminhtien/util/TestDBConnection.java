package vn.edu.husc.tien_nguyenhuynhminhtien.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        System.out.println("Thử kết nối tới: " + DBConfig.getConnectionUrl());
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(DBConfig.getConnectionUrl(), DBConfig.USERNAME, DBConfig.PASSWORD)) {
                System.out.println("Kết nối thành công: " + (conn != null && !conn.isClosed()));
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC không tìm thấy: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
