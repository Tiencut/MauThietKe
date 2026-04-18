package _22T1020761.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import _22T1020761.DatabaseConnection;
import _22T1020761.entity.SinhVien;

/**
 * DAO cho nguon du lieu SQL Server.
 */
public class SqlServerDao implements IDao {
    private DatabaseConnection dbConn;

    public SqlServerDao(String connectionString) throws SQLException {
        this.dbConn = DatabaseConnection.getInstance(connectionString);
    }

    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        String query = "SELECT MaSinhVien, HoTen, GioiTinhNam, NgaySinh FROM SinhVien";
        try (Statement stmt = dbConn.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String maSV = rs.getString("MaSinhVien");
                String hoTen = rs.getString("HoTen");
                boolean gioiTinhNam = rs.getBoolean("GioiTinhNam");
                LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
                list.add(new SinhVien(maSV, hoTen, gioiTinhNam, ngaySinh));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            SqlServerDao dao = new SqlServerDao("jdbc:sqlserver://localhost;databaseName=QLSV;user=sa;password=your_password");
            List<SinhVien> sinhViens = dao.getAll();
            for (SinhVien sv : sinhViens) {
                System.out.println(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(SinhVien sv) {
        String query = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(query)) {
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getHoTen());
            pstmt.setBoolean(3, sv.isGioiTinhNam());
            pstmt.setDate(4, Date.valueOf(sv.getNgaySinh()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSV) {
        String query = "DELETE FROM SinhVien WHERE MaSinhVien = ?";
        try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(query)) {
            pstmt.setString(1, maSV);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}