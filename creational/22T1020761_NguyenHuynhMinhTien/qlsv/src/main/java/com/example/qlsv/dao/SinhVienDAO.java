package com.example.qlsv.dao;

import com.example.qlsv.config.DatabaseConnection;
import com.example.qlsv.entity.SinhVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for SinhVien table.
 */
public class SinhVienDAO {

    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> sinhViens = new ArrayList<>();
        String query = "SELECT * FROM SinhVien";

        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                sinhViens.add(new SinhVien(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sinhViens;
    }
}