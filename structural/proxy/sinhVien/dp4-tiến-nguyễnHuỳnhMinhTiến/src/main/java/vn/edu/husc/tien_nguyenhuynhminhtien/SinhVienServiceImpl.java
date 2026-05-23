package vn.edu.husc.tien_nguyenhuynhminhtien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienServiceInterface {
    @Override
    public List<SinhVien> getDanhSachSinhVien() {
        System.out.println("Service thật: đang đọc danh sách sinh viên từ CSDL...");

        List<SinhVien> danhSach = new ArrayList<>();
        String sql = "SELECT id, ma_sinh_vien, ho_ten, lop, diem_trung_binh FROM sinh_vien ORDER BY id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                SinhVien sinhVien = new SinhVien(
                        resultSet.getInt("id"),
                        resultSet.getString("ma_sinh_vien"),
                        resultSet.getString("ho_ten"),
                        resultSet.getString("lop"),
                        resultSet.getDouble("diem_trung_binh")
                );
                danhSach.add(sinhVien);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Không thể đọc danh sách sinh viên từ CSDL", e);
        }

        return danhSach;
    }
}
