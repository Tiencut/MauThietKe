package com.example.qlsv.service;

import com.example.qlsv.dao.*;
import com.example.qlsv.entity.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Service layer for QuanLySinhVien operations.
 */
public class QuanLySinhVienService {

    private final SinhVienDAO sinhVienDAO = new SinhVienDAO();
    private final KhoaDAO khoaDAO = new KhoaDAO();
    private final GiangVienDAO giangVienDAO = new GiangVienDAO();
    private final NganhDaoTaoDAO nganhDaoTaoDAO = new NganhDaoTaoDAO();
    
    // Cache cho điểm trung bình
    private final Map<Integer, Double> _diemTrungBinhCache = new HashMap<>();

    public List<SinhVien> getAllSinhVien() {
        return sinhVienDAO.getAllSinhVien();
    }

    public List<Khoa> getAllKhoa() {
        return khoaDAO.getAllKhoa();
    }

    public List<GiangVien> getAllGiangVien() {
        return giangVienDAO.getAllGiangVien();
    }

    public List<NganhDaoTao> getAllNganhDaoTao() {
        return nganhDaoTaoDAO.getAllNganhDaoTao();
    }
    
    // Tính điểm trung bình với caching
    public double tinhDiemTrungBinh(int sinhVienId) {
        if (_diemTrungBinhCache.containsKey(sinhVienId)) {
            System.out.println("Trả về điểm trung bình từ cache cho sinh viên ID: " + sinhVienId);
            return _diemTrungBinhCache.get(sinhVienId);
        } else {
            System.out.println("Tính điểm trung bình cho sinh viên ID: " + sinhVienId + " (chưa có trong cache)");
            // Simulate tính toán lâu: query DB và tính trung bình
            double diemTB = tinhDiemTrungBinhTuDB(sinhVienId);
            try {
                Thread.sleep(2000);  // Simulate thời gian tính toán
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            _diemTrungBinhCache.put(sinhVienId, diemTB);
            System.out.println("Đã tính xong và cache điểm trung bình: " + diemTB);
            return diemTB;
        }
    }
    
    // Phương thức giả lập tính điểm từ DB
    private double tinhDiemTrungBinhTuDB(int sinhVienId) {
        // Giả sử query điểm từ bảng Diem, tính trung bình
        // Ở đây simulate: dựa trên ID để có giá trị khác nhau
        return (sinhVienId * 2.5) % 10;  // Ví dụ: ID 1 -> 2.5, ID 2 -> 5.0, etc.
    }
}