package com.example.qlsv.dao;

import com.example.qlsv.config.DatabaseConnection;
import com.example.qlsv.entity.NganhDaoTao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for NganhDaoTao table.
 */
public class NganhDaoTaoDAO {

    public List<NganhDaoTao> getAllNganhDaoTao() {
        List<NganhDaoTao> nganhDaoTaos = new ArrayList<>();
        String query = "SELECT * FROM NganhDaoTao";

        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                nganhDaoTaos.add(new NganhDaoTao(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nganhDaoTaos;
    }
}