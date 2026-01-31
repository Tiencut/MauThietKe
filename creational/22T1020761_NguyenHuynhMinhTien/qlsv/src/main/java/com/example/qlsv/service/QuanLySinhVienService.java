package com.example.qlsv.service;

import com.example.qlsv.dao.*;
import com.example.qlsv.entity.*;

import java.util.List;

/**
 * Service layer for QuanLySinhVien operations.
 */
public class QuanLySinhVienService {

    private final SinhVienDAO sinhVienDAO = new SinhVienDAO();
    private final KhoaDAO khoaDAO = new KhoaDAO();
    private final GiangVienDAO giangVienDAO = new GiangVienDAO();
    private final NganhDaoTaoDAO nganhDaoTaoDAO = new NganhDaoTaoDAO();

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
}