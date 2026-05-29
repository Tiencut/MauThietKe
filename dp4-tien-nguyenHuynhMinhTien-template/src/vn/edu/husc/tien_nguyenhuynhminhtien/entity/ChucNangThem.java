package vn.edu.husc.tien_nguyenhuynhminhtien.entity;

public class ChucNangThem {
    private int id;
    private String ten;
    private String moTa;
    private double chiPhi;

    public ChucNangThem() {}

    public ChucNangThem(int id, String ten, String moTa, double chiPhi) {
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.chiPhi = chiPhi;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public double getChiPhi() { return chiPhi; }
    public void setChiPhi(double chiPhi) { this.chiPhi = chiPhi; }

    @Override
    public String toString() {
        return id + " - " + ten + " - " + moTa + " - " + chiPhi;
    }
}
