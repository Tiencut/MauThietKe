package com.example.qlsv.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.qlsv.config.DatabaseConnection;
import com.example.qlsv.entity.Khoa;

/**
 * DAO for interacting with the Khoa table.
 */
public class DepartmentDAO {
    private static List<Khoa> _cachedList = null;
    private static long _lastCacheTime = 0;
    private static final long CACHE_TIMEOUT = 10 * 60 * 1000; // 10 phút

    /**
     * Fetch all departments from the Khoa table with caching.
     */
    public List<Khoa> fetchAllDepartments() {
        if (_cachedList == null || (System.currentTimeMillis() - _lastCacheTime) > CACHE_TIMEOUT) {
            System.out.println("Cache trống hoặc hết hạn, đang load từ DB...");
            _cachedList = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM Khoa";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
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