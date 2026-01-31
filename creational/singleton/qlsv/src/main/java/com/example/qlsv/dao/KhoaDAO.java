package com.example.qlsv.dao;

import com.example.qlsv.config.DatabaseConnection;
import com.example.qlsv.entity.Khoa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for Khoa table.
 */
public class KhoaDAO {
    private static List<Khoa> _cachedList = null;
    private static long _lastCacheTime = 0;
    private static final long CACHE_TIMEOUT = 10 * 60 * 1000; // 10 phút

    public List<Khoa> getAllKhoa() {
        if (_cachedList == null || (System.currentTimeMillis() - _lastCacheTime) > CACHE_TIMEOUT) {
            System.out.println("Cache trống hoặc hết hạn, đang load từ DB...");
            _cachedList = new ArrayList<>();
            String query = "SELECT * FROM Khoa";

            Connection conn = DatabaseConnection.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    _cachedList.add(new Khoa(id, name));
                }
                _lastCacheTime = System.currentTimeMillis();
                System.out.println("Đã load xong danh sách Khoa từ DB và cache lại.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Trả về danh sách từ cache.");
        }
        return _cachedList;
    }
}