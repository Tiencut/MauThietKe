package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.entity.CauHinhXe;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.TrangTri;

public class CauHinhXeDAO {
    public List<CauHinhXe> layTatCaCauHinhXe() {
        List<CauHinhXe> ds = new ArrayList<>();

        // lấy thông tin cấu hình xe, bao gồm tên mẫu xe, tên khách hàng, giá cơ bản và giá cuối cùng
        String sqlCauHinh = """
                SELECT ch.cau_hinh_id, x.ten_mau_xe, kh.ten_khach_hang,
                       x.gia_co_ban, ch.gia_cuoi_cung
                FROM CauHinhXe ch
                    JOIN Xe x ON ch.xe_id = x.xe_id
                    JOIN KhachHang kh ON ch.khach_hang_id = kh.khach_hang_id
                ORDER BY ch.cau_hinh_id
                """;
        // lấy thông tin phụ kiện đã chọn cho từng cấu hình xe
        String sqlPhuKien = """
                SELECT tt.trang_tri_id, tt.ten_trang_tri, tt.chi_phi_them, tt.mo_ta
                FROM CauHinhTrangTriXe chtt
                    JOIN TrangTri tt ON chtt.trang_tri_id = tt.trang_tri_id
                WHERE chtt.cau_hinh_id = ?
                ORDER BY chtt.thu_tu_ap_dung, tt.trang_tri_id
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psCauHinh = conn.prepareStatement(sqlCauHinh);
             ResultSet rs = psCauHinh.executeQuery()) {

            while (rs.next()) {
                CauHinhXe cauHinh = new CauHinhXe(
                        rs.getInt("cau_hinh_id"),
                        rs.getString("ten_mau_xe"),
                        rs.getString("ten_khach_hang"),
                        rs.getDouble("gia_co_ban"),
                        rs.getDouble("gia_cuoi_cung")
                );

                try (PreparedStatement psPhuKien = conn.prepareStatement(sqlPhuKien)) {
                    psPhuKien.setInt(1, cauHinh.getCauHinhId());
                    try (ResultSet rsPhuKien = psPhuKien.executeQuery()) {
                        while (rsPhuKien.next()) {
                            cauHinh.themPhuKien(new TrangTri(
                                    rsPhuKien.getInt("trang_tri_id"),
                                    rsPhuKien.getString("ten_trang_tri"),
                                    rsPhuKien.getDouble("chi_phi_them"),
                                    rsPhuKien.getString("mo_ta")
                            ));
                        }
                    }
                }

                ds.add(cauHinh);
            }
        } catch (Exception e) {
            System.out.println("Loi doc danh sach cau hinh xe: " + e.getMessage());
        }

        return ds;
    }
}
