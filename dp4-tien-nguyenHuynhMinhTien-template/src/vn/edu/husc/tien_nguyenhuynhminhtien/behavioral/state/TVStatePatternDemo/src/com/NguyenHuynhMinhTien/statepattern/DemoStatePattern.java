package com.NguyenHuynhMinhTien.statepattern;

import com.NguyenHuynhMinhTien.statepattern.context.TV;

public class DemoStatePattern {
    public static void main(String[] args) {
        TV tv = new TV();

        System.out.println("=== Cach cai dat bang State Pattern ===");
        System.out.println("Trang thai ban dau: " + tv.layTenTrangThai());

        tv.bamNutMUTE();
        System.out.println("Trang thai hien tai: " + tv.layTenTrangThai());

        tv.bamNutOFF();
        System.out.println("Trang thai hien tai: " + tv.layTenTrangThai());

        tv.bamNutON();
        System.out.println("Trang thai hien tai: " + tv.layTenTrangThai());

        tv.bamNutMUTE();
        System.out.println("Trang thai hien tai: " + tv.layTenTrangThai());

        tv.bamNutMUTE();
        System.out.println("Trang thai hien tai: " + tv.layTenTrangThai());

        tv.bamNutOFF();
        System.out.println("Trang thai hien tai: " + tv.layTenTrangThai());
    }
}
