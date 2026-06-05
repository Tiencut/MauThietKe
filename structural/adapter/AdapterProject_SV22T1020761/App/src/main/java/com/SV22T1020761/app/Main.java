package com.SV22T1020761.app;

import java.util.ArrayList;
import java.util.List;

import com.SV22T1020761.lib.CongNhan;
import com.SV22T1020761.lib.CongNhanReader;
import com.SV22T1020761.lib.SinhVien;
import com.SV22T1020761.lib.SinhVienReader;

public class Main {
    public static void main(String[] args) {
        List<SinhVien> sv = SinhVienReader.docDanhSach("sv.txt");
        List<CongNhan> cn = CongNhanReader.docDanhSach("cn.txt");

        List<PhanTu> list = new ArrayList<>();

        for (SinhVien x : sv) 
            list.add(new PhanTuCuaSinhVien(x));
        for (CongNhan x : cn) 
            list.add(new PhanTuCuaCongNhan(x));

        list.sort((a,b)-> b.getDoUuTien().compareTo(a.getDoUuTien()));

        int i=1;
        for (PhanTu p : list) {
            System.out.println(i++ + " " + p.getHoTen() + " " + p.getLoai() + " " + p.getDoUuTien());
        }
    }
}
