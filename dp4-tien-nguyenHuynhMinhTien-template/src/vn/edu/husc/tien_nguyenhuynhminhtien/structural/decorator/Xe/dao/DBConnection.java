package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vn.edu.husc.tien_nguyenhuynhminhtien.util.DBConfig;

public class DBConnection {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				DBConfig.getConnectionUrl(),
				DBConfig.USERNAME,DBConfig.PASSWORD);
	}
}
