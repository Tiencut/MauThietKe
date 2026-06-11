package com.NguyenHuynhMinhTien.statepattern.state;

import com.NguyenHuynhMinhTien.statepattern.context.TV;

public class TrangThaiON implements ITrangThai {
    @Override
    public void bamNutON(TV tv) {
        System.out.println("Dang ON. Bam ON tiep khong co tac dung.");
    }

    @Override
    public void bamNutOFF(TV tv) {
        System.out.println("Dang ON. Bam OFF de tat TV.");
        tv.setTrangThai(new TrangThaiOFF());
    }

    @Override
    public void bamNutMUTE(TV tv) {
        System.out.println("Dang ON. Bam MUTE de chuyen sang trang thai MUTE.");
        tv.setTrangThai(new TrangThaiMUTE());
    }

    @Override
    public String layTenTrangThai() {
        return "ON";
    }
}
