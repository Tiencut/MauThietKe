package vn.edu.husc.dp4.nguyenHuynhMinhTien.entity;

public class KhachHang {
    private int khachHangId;
    private String tenKhachHang;

    public KhachHang(int khachHangId, String tenKhachHang) {
        this.khachHangId = khachHangId;
        this.tenKhachHang = tenKhachHang;
    }

    public int getKhachHangId() { return khachHangId; }
    public String getTenKhachHang() { return tenKhachHang; }
}
