package NguyenHuynhMinhTien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SinhVienReader {
    public static List<SinhVien> readFromFile(String filename) throws IOException {
        List<SinhVien> lst = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            String[] info = line.split(",");
            if (info.length < 4)
                continue;
            String maSinhVien = info[0];
            String hoDem = info[1];
            String ten = info[2];
            String stDiemTrungBinh = info[3];
            double diemTrungBinh = Double.parseDouble(stDiemTrungBinh);
            SinhVien x = new SinhVien(maSinhVien, hoDem, ten, diemTrungBinh);
            lst.add(x);
        }
        br.close();
        return lst;
    }
}
