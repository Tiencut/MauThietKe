package com.example.qlsv.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import com.example.qlsv.config.DBConnection;
import com.example.qlsv.entity.SinhVien;

public class SVDAO {
	public List<SinhVien> getAllSV() {
		List<SinhVien> listSV = new ArrayList<>();
		
		// 
		String query = "SELECT * FROM SinhVien";
		Connection conn = DBConnection.getInstanct().getConnection();
		try (Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				listSV.add(new SinhVien(id, name, age));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return listSV;
	}
}
