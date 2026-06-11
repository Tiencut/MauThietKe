package vn.edu.husc.tien_nguyenhuynhminhtien;

public class SinhVien {
    private final int id;
    private final String maSinhVien;
    private final String hoTen;
    private final String lop;
    private final double diemTrungBinh;

    public SinhVien(int id, String maSinhVien, String hoTen, String lop, double diemTrungBinh) {
        this.id = id;
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.diemTrungBinh = diemTrungBinh;
    }

    public int getId() {
        return id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLop() {
        return lop;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %s | %.2f", id, maSinhVien, hoTen, lop, diemTrungBinh);
    }
}
