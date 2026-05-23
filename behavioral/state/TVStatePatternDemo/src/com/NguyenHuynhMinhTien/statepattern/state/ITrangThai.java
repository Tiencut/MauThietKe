package com.NguyenHuynhMinhTien.statepattern.state;

import com.NguyenHuynhMinhTien.statepattern.context.TV;

public interface ITrangThai {
    void bamNutON(TV tv);

    void bamNutOFF(TV tv);

    void bamNutMUTE(TV tv);

    String layTenTrangThai();
}
