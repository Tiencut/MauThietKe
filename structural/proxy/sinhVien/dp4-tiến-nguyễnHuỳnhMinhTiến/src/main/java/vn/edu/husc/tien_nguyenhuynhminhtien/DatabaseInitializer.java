package vn.edu.husc.tien_nguyenhuynhminhtien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void khoiTaoDuLieuMau() {
        taoBangSinhVien();
        if (demSoSinhVien() == 0) {
            themSinhVienMau();
        }
    }

    private static void taoBangSinhVien() {
        String sql = """
                CREATE TABLE IF NOT EXISTS sinh_vien (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    ma_sinh_vien TEXT NOT NULL UNIQUE,
                    ho_ten TEXT NOT NULL,
                    lop TEXT NOT NULL,
                    diem_trung_binh REAL NOT NULL
                )
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Không thể tạo bảng sinh_vien", e);
        }
    }

    private static int demSoSinhVien() {
        String sql = "SELECT COUNT(*) FROM sinh_vien";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Không thể đếm số sinh viên", e);
        }
    }

    private static void themSinhVienMau() {
        String sql = "INSERT INTO sinh_vien(ma_sinh_vien, ho_ten, lop, diem_trung_binh) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            themMotSinhVien(statement, "22T1020761", "Nguyễn Huỳnh Minh Tiến", "CNTT K46", 8.50);
            themMotSinhVien(statement, "22T1020001", "Trần Văn An", "CNTT K46", 7.90);
            themMotSinhVien(statement, "22T1020002", "Lê Thị Bình", "CNTT K46", 8.20);
            themMotSinhVien(statement, "22T1020003", "Phạm Quốc Cường", "CNTT K46", 7.60);
        } catch (SQLException e) {
            throw new RuntimeException("Không thể thêm dữ liệu sinh viên mẫu", e);
        }
    }

    private static void themMotSinhVien(PreparedStatement statement, String maSinhVien, String hoTen, String lop, double diemTrungBinh)
            throws SQLException {
        statement.setString(1, maSinhVien);
        statement.setString(2, hoTen);
        statement.setString(3, lop);
        statement.setDouble(4, diemTrungBinh);
        statement.executeUpdate();
    }
}
