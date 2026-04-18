package _22T1020761.dao;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import _22T1020761.entity.SinhVien;

/**
 * DAO cho nguon du lieu file van ban.
 */
public class TextFileDao implements IDao {
    private String filePath;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public TextFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String maSV = parts[0];
                    String hoTen = parts[1];
                    boolean gioiTinhNam = Boolean.parseBoolean(parts[2]);
                    LocalDate ngaySinh = LocalDate.parse(parts[3], FORMATTER);
                    list.add(new SinhVien(maSV, hoTen, gioiTinhNam, ngaySinh));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(SinhVien sv) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(sv.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSV) {
        List<SinhVien> list = getAll();
        list.removeIf(sv -> sv.getMaSV().equals(maSV));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (SinhVien sv : list) {
                bw.write(sv.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}