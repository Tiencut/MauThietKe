package com.SV22T1020761.lib;

import java.io.*;
import java.text.*;
import java.util.*;

public class CongNhanReader {
    public static List<CongNhan> docDanhSach(String filename) {
        List<CongNhan> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
            String line;
            while ((line = br.readLine()) != null) {
                String[] v = line.split(",");
                list.add(new CongNhan(v[0].trim(), sdf.parse(v[1].trim())));
            }
        } catch (Exception e) {}
        return list;
    }
}
