package com.NguyenHuynhMinhTien.statepattern.context;

import com.NguyenHuynhMinhTien.statepattern.state.ITrangThai;
import com.NguyenHuynhMinhTien.statepattern.state.TrangThaiOFF;

public class TV {
    private ITrangThai trangThaiHienTai;

    public TV() {
        this.trangThaiHienTai = new TrangThaiOFF();
    }

    public TV(ITrangThai trangThaiBanDau) {
        this.trangThaiHienTai = trangThaiBanDau;
    }

    public void setTrangThai(ITrangThai trangThai) {
        this.trangThaiHienTai = trangThai;
    }

    public ITrangThai getTrangThai() {
        return trangThaiHienTai;
    }

    public String layTenTrangThai() {
        return trangThaiHienTai.layTenTrangThai();
    }

    public void bamNutON() {
        trangThaiHienTai.bamNutON(this);
    }

    public void bamNutOFF() {
        trangThaiHienTai.bamNutOFF(this);
    }

    public void bamNutMUTE() {
        trangThaiHienTai.bamNutMUTE(this);
    }
}
