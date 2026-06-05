package com.SV22T1020761.lib;

import java.io.*;
import java.util.*;

public class SinhVienReader {
    public static List<SinhVien> docDanhSach(String filename) {
        List<SinhVien> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] v = line.split(",");
                list.add(new SinhVien(v[0].trim(), v[1].trim(), v[2].trim(), Double.parseDouble(v[3].trim())));
            }
        } catch (Exception e) {}
        return list;
    }
}
