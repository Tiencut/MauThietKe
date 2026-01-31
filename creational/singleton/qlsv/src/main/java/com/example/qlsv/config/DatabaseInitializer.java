package com.example.qlsv.config;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Initializes the database with schema and data.
 */
public class DatabaseInitializer {

    public static void initialize() {
        String sql = """
            CREATE TABLE SinhVien (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                age INT NOT NULL
            );

            CREATE TABLE Khoa (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL
            );

            CREATE TABLE GiangVien (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL
            );

            CREATE TABLE NganhDaoTao (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL
            );

            INSERT INTO SinhVien (name, age) VALUES
            ('Nguyen Van A', 20),
            ('Tran Thi B', 21),
            ('Le Van C', 19);

            INSERT INTO Khoa (name) VALUES
            ('Cong Nghe Thong Tin'),
            ('Kinh Te'),
            ('Ky Thuat Dien');

            INSERT INTO GiangVien (name) VALUES
            ('Nguyen Van D'),
            ('Tran Thi E'),
            ('Le Van F');

            INSERT INTO NganhDaoTao (name) VALUES
            ('Cong Nghe Phan Mem'),
            ('Kinh Te Doi Ngoai'),
            ('Dien Tu Vien Thong');
            """;

        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement()) {

            for (String query : sql.split(";")) {
                if (!query.trim().isEmpty()) {
                    stmt.execute(query.trim());
                }
            }
            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}