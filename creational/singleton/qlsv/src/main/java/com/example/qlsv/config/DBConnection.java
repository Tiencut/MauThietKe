package com.example.qlsv.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import javax.management.RuntimeErrorException;

public class DBConnection {
	private static DBConnection instance;
	private Connection connection;
	
    private static final String URL = "jdbc:h2:mem:QuanLySinhVien;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

	
	private DBConnection () {
		try {
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Ket noi that bai", e);
		}
	}
	
	public static synchronized DBConnection getInstanct() {
		if (instance == null)
			instance = new DBConnection();
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
