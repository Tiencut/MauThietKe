package vn.edu.husc.tien_nguyenhuynhminhtien.component;

public class DoiTuongGoc implements ThanhPhan {
    private String ten;
    private double chiPhi;

    public DoiTuongGoc(String ten, double chiPhi) {
        this.ten = ten;
        this.chiPhi = chiPhi;
    }

    @Override
    public String getTen() {
        return ten;
    }

    @Override
    public String getMoTa() {
        return ten;
    }

    @Override
    public double getChiPhi() {
        return chiPhi;
    }
}
