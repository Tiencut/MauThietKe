package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.entity.TrangTri;

public class TrangTriDAO {
    public List<TrangTri> layTatCaPhuKien() {
        List<TrangTri> ds = new ArrayList<>();
        String sql = "SELECT trang_tri_id, ten_trang_tri, chi_phi_them, mo_ta FROM TrangTri ORDER BY trang_tri_id";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                ds.add(new TrangTri(
                        rs.getInt("trang_tri_id"),
                        rs.getString("ten_trang_tri"),
                        rs.getDouble("chi_phi_them"),
                        rs.getString("mo_ta")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi doc danh sach phu kien: " + e.getMessage());
        }

        return ds;
    }
}
