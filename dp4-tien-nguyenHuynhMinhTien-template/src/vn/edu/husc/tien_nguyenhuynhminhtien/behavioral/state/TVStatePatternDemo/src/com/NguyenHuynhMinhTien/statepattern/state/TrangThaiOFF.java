package com.NguyenHuynhMinhTien.statepattern.state;

import com.NguyenHuynhMinhTien.statepattern.context.TV;

public class TrangThaiOFF implements ITrangThai {
    @Override
    public void bamNutON(TV tv) {
        System.out.println("Dang OFF. Bam ON chuyen TV sang trang thai ON.");
        tv.setTrangThai(new TrangThaiON());
    }

    @Override
    public void bamNutOFF(TV tv) {
        System.out.println("Dang OFF. Bam OFF tiep khong co tac dung.");
    }

    @Override
    public void bamNutMUTE(TV tv) {
        System.out.println("Dang OFF. Bam MUTE khong co tac dung.");
    }

    @Override
    public String layTenTrangThai() {
        return "OFF";
    }
}
