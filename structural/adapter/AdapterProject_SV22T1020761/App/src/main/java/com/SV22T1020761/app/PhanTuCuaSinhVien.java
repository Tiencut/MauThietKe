package com.SV22T1020761.app;

import com.SV22T1020761.lib.SinhVien;

public class PhanTuCuaSinhVien implements PhanTu {
    private SinhVien sv;

    public PhanTuCuaSinhVien(SinhVien sv) {
        this.sv = sv;
    }

    public String getHoTen() {
        return sv.getHoDem() + " " + sv.getTen();
    }

    public String getLoai() {
        return "SV";
    }

    public String getDoUuTien() {
        double d = sv.getDiemTB();
        if (d < 4) return "X";
        if (d < 6.5) return "D";
        if (d < 7.5) return "C";
        if (d < 8.5) return "B";
        return "A";
    }
}
