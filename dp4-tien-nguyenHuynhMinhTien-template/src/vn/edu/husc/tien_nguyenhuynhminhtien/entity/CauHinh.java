package vn.edu.husc.tien_nguyenhuynhminhtien.entity;

import java.util.ArrayList;
import java.util.List;

public class CauHinh {
    private int id;
    private MauDoiTuong mau;
    private String tenKhachHang;
    private List<ChucNangThem> danhSachChucNang = new ArrayList<>();

    public CauHinh() {}

    public CauHinh(int id, MauDoiTuong mau, String tenKhachHang) {
        this.id = id;
        this.mau = mau;
        this.tenKhachHang = tenKhachHang;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public MauDoiTuong getMau() { return mau; }
    public void setMau(MauDoiTuong mau) { this.mau = mau; }

    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }

    public List<ChucNangThem> getDanhSachChucNang() { return danhSachChucNang; }

    public void themChucNang(ChucNangThem chucNang) {
        this.danhSachChucNang.add(chucNang);
    }
}
