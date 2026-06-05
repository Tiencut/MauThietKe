package com.SV22T1020761.app;

import com.SV22T1020761.lib.CongNhan;
import java.util.*;

public class PhanTuCuaCongNhan implements PhanTu {
    private CongNhan cn;

    public PhanTuCuaCongNhan(CongNhan cn) {
        this.cn = cn;
    }

    public String getHoTen() {
        return cn.getHoTen();
    }

    public String getLoai() {
        return "CN";
    }

    public String getDoUuTien() {
        long years = (new Date().getTime() - cn.getNgayBatDau().getTime()) / (1000L*60*60*24*365);
        if (years < 1) return "X";
        if (years < 3) return "D";
        if (years < 5) return "C";
        if (years < 10) return "B";
        return "A";
    }
}
