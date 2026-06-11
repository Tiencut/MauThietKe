package com.NguyenHuynhMinhTien.statepattern.state;

import com.NguyenHuynhMinhTien.statepattern.context.TV;

public class TrangThaiMUTE implements ITrangThai {
    @Override
    public void bamNutON(TV tv) {
        System.out.println("Dang MUTE. Bam ON khong co tac dung vi TV van dang bat.");
    }

    @Override
    public void bamNutOFF(TV tv) {
        System.out.println("Dang MUTE. Bam OFF de tat TV.");
        tv.setTrangThai(new TrangThaiOFF());
    }

    @Override
    public void bamNutMUTE(TV tv) {
        System.out.println("Dang MUTE. Bam MUTE lan nua de tro ve ON.");
        tv.setTrangThai(new TrangThaiON());
    }

    @Override
    public String layTenTrangThai() {
        return "MUTE";
    }
}
