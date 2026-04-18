package _22T1020761;

import _22T1020761.dao.IDao;
import _22T1020761.entity.SinhVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Chuong trinh chinh thuc hien kich ban.
 */
public class ChuongTrinh {
    public static void main(String[] args) {
        try {
            // Doc cau hinh tu config.txt
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String type = br.readLine().trim();
            String source = br.readLine().trim();
            br.close();

            // Tao DAO bang Simple Factory
            IDao dao = SimpleFactory.createDao(type, source);

            // 1. Doc danh sach sinh vien
            System.out.println("Danh sach sinh vien:");
            List<SinhVien> list = dao.getAll();
            for (SinhVien sv : list) {
                System.out.println(sv);
            }

            // 2. Insert sinh vien moi
            SinhVien newSV = new SinhVien("SV099", "John Smith", true, LocalDate.of(2000, 11, 30));
            dao.insert(newSV);
            System.out.println("Da insert sinh vien: " + newSV);

            // 3. Delete sinh vien
            dao.delete("SV082");
            System.out.println("Da delete sinh vien: SV082");

            // Doc lai danh sach sau thay doi
            System.out.println("Danh sach sau thay doi:");
            list = dao.getAll();
            for (SinhVien sv : list) {
                System.out.println(sv);
            }

        } catch (IOException | SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}