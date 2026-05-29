package vn.edu.husc.dp4.nguyenHuynhMinhTien.entity;

import java.util.ArrayList;
import java.util.List;

public class CauHinhXe {
    private int cauHinhId;
    private String tenMauXe;
    private String tenKhachHang;
    private double giaCoBan;
    private double giaBanCuoiCung;
    private List<TrangTri> danhSachPhuKien = new ArrayList<>();

    public CauHinhXe(int cauHinhId, String tenMauXe, String tenKhachHang, double giaCoBan, double giaBanCuoiCung) {
        this.cauHinhId = cauHinhId;
        this.tenMauXe = tenMauXe;
        this.tenKhachHang = tenKhachHang;
        this.giaCoBan = giaCoBan;
        this.giaBanCuoiCung = giaBanCuoiCung;
    }

    public int getCauHinhId() { return cauHinhId; }
    public String getTenMauXe() { return tenMauXe; }
    public String getTenKhachHang() { return tenKhachHang; }
    public double getGiaCoBan() { return giaCoBan; }
    public double getGiaBanCuoiCung() { return giaBanCuoiCung; }
    public List<TrangTri> getDanhSachPhuKien() { return danhSachPhuKien; }

    public void themPhuKien(TrangTri trangTri) {
        danhSachPhuKien.add(trangTri);
    }
}
