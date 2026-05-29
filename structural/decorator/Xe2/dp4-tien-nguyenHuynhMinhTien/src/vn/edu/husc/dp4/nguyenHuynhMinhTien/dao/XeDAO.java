package vn.edu.husc.dp4.nguyenHuynhMinhTien.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.entity.MauXe;

public class XeDAO {
    public List<MauXe> layTatCaMauXe() {
        List<MauXe> ds = new ArrayList<>();
        String sql = "SELECT xe_id, ten_mau_xe, gia_co_ban, mo_ta FROM Xe ORDER BY xe_id";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                ds.add(new MauXe(
                        rs.getInt("xe_id"),
                        rs.getString("ten_mau_xe"),
                        rs.getDouble("gia_co_ban"),
                        rs.getString("mo_ta")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi doc danh sach mau xe: " + e.getMessage());
        }

        return ds;
    }
}
