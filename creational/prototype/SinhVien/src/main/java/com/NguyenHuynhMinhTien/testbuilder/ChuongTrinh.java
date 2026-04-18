package com.NguyenHuynhMinhTien.testbuilder;

public class ChuongTrinh {
    public static void main(String[] args) {
        // Tạo bánh sử dụng Builder đúng mẫu
        Bánh b1 = new Bánh.BánhBuilder(1.5, 0.7)
                .cacao(5)
                .tiêu(0.5)
                .nướcDừa(4.5)
                .ớt(0.3)
                .build();

        Bánh b2 = new Bánh.BánhBuilder(2.0, 1.0)
                .vani(2.2)
                .build();

        System.out.println("Bánh 1: " + b1);
        System.out.println("Bánh 2: " + b2);
    }
}
