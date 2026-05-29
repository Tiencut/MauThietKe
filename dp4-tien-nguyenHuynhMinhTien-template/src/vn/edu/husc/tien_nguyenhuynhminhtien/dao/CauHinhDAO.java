package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.entity.CauHinh;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.ChucNangThem;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.MauDoiTuong;

public class CauHinhDAO {
    public List<CauHinh> layTatCa() {
        List<CauHinh> ds = new ArrayList<>();

        String sqlCauHinh = """
                SELECT ch.id AS cau_hinh_id, ch.ten_khach_hang,
                       m.id AS mau_id, m.ten AS ten_mau, m.gia
                FROM CauHinh ch
                    JOIN MauDoiTuong m ON ch.mau_id = m.id
                ORDER BY ch.id
                """;

        String sqlChucNang = """
                SELECT cn.id, cn.ten, cn.mo_ta, cn.chi_phi
                FROM CauHinh_ChucNang chcn
                    JOIN ChucNangThem cn ON chcn.chuc_nang_id = cn.id
                WHERE chcn.cau_hinh_id = ?
                ORDER BY chcn.thu_tu, cn.id
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlCauHinh);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MauDoiTuong mau = new MauDoiTuong(
                        rs.getInt("mau_id"),
                        rs.getString("ten_mau"),
                        rs.getDouble("gia")
                );

                CauHinh cauHinh = new CauHinh(
                        rs.getInt("cau_hinh_id"),
                        mau,
                        rs.getString("ten_khach_hang")
                );

                try (PreparedStatement ps2 = conn.prepareStatement(sqlChucNang)) {
                    ps2.setInt(1, cauHinh.getId());
                    try (ResultSet rs2 = ps2.executeQuery()) {
                        while (rs2.next()) {
                            cauHinh.themChucNang(new ChucNangThem(
                                    rs2.getInt("id"),
                                    rs2.getString("ten"),
                                    rs2.getString("mo_ta"),
                                    rs2.getDouble("chi_phi")
                            ));
                        }
                    }
                }

                ds.add(cauHinh);
            }
        } catch (Exception e) {
            System.out.println("Loi doc CauHinh: " + e.getMessage());
        }

        return ds;
    }
}
