package vn.edu.husc.dp4.nguyenHuynhMinhTien.component;

public class XeCoBan implements Xe {
    private int xeId;
    private String tenMauXe;
    private String moTa;
    private double giaBan;

    public XeCoBan(int xeId, String tenMauXe, String moTa, double giaBan) {
        this.xeId = xeId;
        this.tenMauXe = tenMauXe;
        this.moTa = moTa;
        this.giaBan = giaBan;
    }

    public int getXeId() {
        return xeId;
    }

    @Override
    public String getTenMauXe() {
        return tenMauXe;
    }

    @Override
    public String getMoTa() {
        return moTa;
    }

    @Override
    public double getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-30s %15.0f  %s", xeId, tenMauXe, giaBan, moTa);
    }
}
