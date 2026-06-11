package vn.edu.husc.tien_nguyenhuynhminhtien.decorator;

import vn.edu.husc.tien_nguyenhuynhminhtien.component.ThanhPhan;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.ChucNangThem;

public class ChucNangCuThe extends ChucNangDecorator {
    private ChucNangThem chucNang;

    public ChucNangCuThe(ThanhPhan thanhPhan, ChucNangThem chucNang) {
        super(thanhPhan);
        this.chucNang = chucNang;
    }

    @Override
    public String getTen() {
        return thanhPhan.getTen();
    }

    @Override
    public String getMoTa() {
        return thanhPhan.getMoTa() + " + " + chucNang.getTen();
    }

    @Override
    public double getChiPhi() {
        return thanhPhan.getChiPhi() + chucNang.getChiPhi();
    }
}
