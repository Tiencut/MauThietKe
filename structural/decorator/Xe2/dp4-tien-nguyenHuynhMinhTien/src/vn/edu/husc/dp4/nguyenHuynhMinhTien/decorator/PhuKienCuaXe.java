package vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Xe;

public abstract class PhuKienCuaXe implements Xe {
    protected Xe xe;
    protected String tenPhuKien;
    protected String moTaPhuKien;
    protected double chiPhi;

    public PhuKienCuaXe(Xe xe, String tenPhuKien, String moTaPhuKien, double chiPhi) {
        this.xe = xe;
        this.tenPhuKien = tenPhuKien;
        this.moTaPhuKien = moTaPhuKien;
        this.chiPhi = chiPhi;
    }

    public String getTenPhuKien() {
        return tenPhuKien;
    }

    public String getMoTaPhuKien() {
        return moTaPhuKien;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    @Override
    public String getTenMauXe() {
        return xe.getTenMauXe();
    }

    @Override
    public String getMoTa() {
        return xe.getMoTa() + " + " + tenPhuKien;
    }

    @Override
    public double getGiaBan() {
        return xe.getGiaBan() + chiPhi;
    }
}
