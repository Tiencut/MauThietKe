package _22T1020761.entity;

import java.time.LocalDate;

/**
 * Entity class cho SinhVien.
 */
public class SinhVien {
    private String maSV;
    private String hoTen;
    private boolean gioiTinhNam;
    private LocalDate ngaySinh;

    public SinhVien(String maSV, String hoTen, boolean gioiTinhNam, LocalDate ngaySinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinhNam = gioiTinhNam;
        this.ngaySinh = ngaySinh;
    }

    // Getters and setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public boolean isGioiTinhNam() { return gioiTinhNam; }
    public void setGioiTinhNam(boolean gioiTinhNam) { this.gioiTinhNam = gioiTinhNam; }

    public LocalDate getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(LocalDate ngaySinh) { this.ngaySinh = ngaySinh; }

    @Override
    public String toString() {
        return maSV + "," + hoTen + "," + gioiTinhNam + "," + ngaySinh;
    }
}