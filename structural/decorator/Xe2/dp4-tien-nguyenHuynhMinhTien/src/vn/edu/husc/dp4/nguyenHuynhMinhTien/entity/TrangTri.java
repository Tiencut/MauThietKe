package vn.edu.husc.dp4.nguyenHuynhMinhTien.entity;

public class TrangTri {
    private int trangTriId;
    private String tenTrangTri;
    private double chiPhiThem;
    private String moTa;

    public TrangTri(int trangTriId, String tenTrangTri, double chiPhiThem, String moTa) {
        this.trangTriId = trangTriId;
        this.tenTrangTri = tenTrangTri;
        this.chiPhiThem = chiPhiThem;
        this.moTa = moTa;
    }

    public int getTrangTriId() { return trangTriId; }
    public String getTenTrangTri() { return tenTrangTri; }
    public double getChiPhiThem() { return chiPhiThem; }
    public String getMoTa() { return moTa; }

    @Override
    public String toString() {
        return String.format("%-5d %-30s %15.0f  %s", trangTriId, tenTrangTri, chiPhiThem, moTa);
    }
}
