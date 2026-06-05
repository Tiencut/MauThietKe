package com.SV22T1020761.lib;

public class SinhVien {
    private String maSV, hoDem, ten;
    private double diemTB;

    public SinhVien(String maSV, String hoDem, String ten, double diemTB) {
        this.maSV = maSV;
        this.hoDem = hoDem;
        this.ten = ten;
        this.diemTB = diemTB;
    }

    public String getHoDem() { return hoDem; }
    public String getTen() { return ten; }
    public double getDiemTB() { return diemTB; }
}
