package com.SV22T1020761.lib;

import java.util.Date;

public class CongNhan {
    private String hoTen;
    private Date ngay;

    public CongNhan(String hoTen, Date ngay) {
        this.hoTen = hoTen;
        this.ngay = ngay;
    }

    public String getHoTen() { return hoTen; }
    public Date getNgayBatDau() { return ngay; }
}
