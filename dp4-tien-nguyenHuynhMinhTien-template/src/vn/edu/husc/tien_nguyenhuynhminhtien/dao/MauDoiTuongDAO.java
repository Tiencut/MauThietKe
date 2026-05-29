package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.entity.MauDoiTuong;

public class MauDoiTuongDAO {
    public List<MauDoiTuong> layTatCa() {
        List<MauDoiTuong> ds = new ArrayList<>();
        String sql = "SELECT id, ten, gia FROM MauDoiTuong ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ds.add(new MauDoiTuong(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getDouble("gia")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi doc MauDoiTuong: " + e.getMessage());
        }

        return ds;
    }
}
