package vn.edu.husc.dp4.nguyenHuynhMinhTien.entity;

public class MauXe {
    private int xeId;
    private String tenMauXe;
    private double giaCoBan;
    private String moTa;

    public MauXe(int xeId, String tenMauXe, double giaCoBan, String moTa) {
        this.xeId = xeId;
        this.tenMauXe = tenMauXe;
        this.giaCoBan = giaCoBan;
        this.moTa = moTa;
    }

    public int getXeId() { return xeId; }
    public String getTenMauXe() { return tenMauXe; }
    public double getGiaCoBan() { return giaCoBan; }
    public String getMoTa() { return moTa; }

    @Override
    public String toString() {
        return String.format("%-5d %-30s %15.0f  %s", xeId, tenMauXe, giaCoBan, moTa);
    }
}
