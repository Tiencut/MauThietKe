package com.example.qlsv.dao;

import com.example.qlsv.config.DatabaseConnection;
import com.example.qlsv.entity.GiangVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for GiangVien table.
 */
public class GiangVienDAO {

    public List<GiangVien> getAllGiangVien() {
        List<GiangVien> giangViens = new ArrayList<>();
        String query = "SELECT * FROM GiangVien";

        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                giangViens.add(new GiangVien(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giangViens;
    }
}