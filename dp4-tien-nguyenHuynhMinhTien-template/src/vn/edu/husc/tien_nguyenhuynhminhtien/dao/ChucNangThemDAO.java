package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.entity.ChucNangThem;

public class ChucNangThemDAO {
    public List<ChucNangThem> layTatCa() {
        List<ChucNangThem> ds = new ArrayList<>();
        String sql = "SELECT id, ten, mo_ta, chi_phi FROM ChucNangThem ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ds.add(new ChucNangThem(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getString("mo_ta"),
                        rs.getDouble("chi_phi")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi doc ChucNangThem: " + e.getMessage());
        }

        return ds;
    }
}
