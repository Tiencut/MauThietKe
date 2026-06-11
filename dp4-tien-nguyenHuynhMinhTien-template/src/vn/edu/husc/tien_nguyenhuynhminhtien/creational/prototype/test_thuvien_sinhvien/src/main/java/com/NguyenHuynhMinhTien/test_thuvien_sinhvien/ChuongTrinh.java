package com.NguyenHuynhMinhTien.test_thuvien_sinhvien;

import NguyenHuynhMinhTien.SinhVien;
import NguyenHuynhMinhTien.SinhVienReader;
import java.io.IOException;
import java.util.List;

public class ChuongTrinh {
    public static void main(String[] args) {
        testThuVienSinhVien();
    }

    private static void testThuVienSinhVien() {
        SinhVien x = new SinhVien();
        x.setTen("Trung");
        try {
            List<SinhVien> lst = SinhVienReader.readFromFile("sinhvien.txt");
            System.out.println("Danh sách sinh viên đọc được");
            for (SinhVien sv : lst) {
                System.out.println(sv.getHoDem() + " " + sv.getTen() + " --- " + sv.getDiemTrungBinh());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
