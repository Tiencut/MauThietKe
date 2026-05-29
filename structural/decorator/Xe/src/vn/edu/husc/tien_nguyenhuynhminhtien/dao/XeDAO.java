package vn.edu.husc.tien_nguyenhuynhminhtien.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.entity.MauXe;

public class XeDAO {
	public List<MauXe> layAllMauXe() {
		List<MauXe> ds = new ArrayList<MauXe>();
		String sql = "select xe_id, ten_mau_xe, gia_co_ban, mo_ta FROM Xe ORDER BY xe_id";
		
		try (Connection conn = DBConnection.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			// Ensure JDBC driver is loaded (fix: No suitable driver found)
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver not found: " + e.getMessage());
			}
			
			while(rs.next()) {
				ds.add(new MauXe(
							rs.getInt("xe_id"),
							rs.getString("ten_mau_xe"),
							rs.getDouble("gia_co_ban"),
							rs.getString("mo_ta")
								)
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi doc ds mau xe: " + e.getMessage());
		}
		return ds;
	}
	
	public static void main(String[] args) {
		XeDAO dao = new XeDAO();
		List<MauXe> ds = dao.layAllMauXe();
		for (MauXe mx : ds) {
			System.out.println(mx.toString());
		}
	}
}
