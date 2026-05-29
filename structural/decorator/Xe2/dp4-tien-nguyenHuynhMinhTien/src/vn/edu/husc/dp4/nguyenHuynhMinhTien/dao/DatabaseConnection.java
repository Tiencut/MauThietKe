package vn.edu.husc.dp4.nguyenHuynhMinhTien.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.util.DBConfig;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DBConfig.getConnectionUrl(),
                DBConfig.USERNAME,
                DBConfig.PASSWORD
        );
    }
}
