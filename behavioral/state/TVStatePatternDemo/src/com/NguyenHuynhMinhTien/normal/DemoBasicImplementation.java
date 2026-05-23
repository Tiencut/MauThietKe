package com.NguyenHuynhMinhTien.normal;

public class DemoBasicImplementation {
    public static void main(String[] args) {
        TV tv = new TV();

        System.out.println("=== Cach thong thuong: dung switch-case ===");
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
