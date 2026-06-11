package prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo danh sách
        List<SinhVien> lst1 = new ArrayList<>();
        lst1.add(new SinhVien("sv1", "Nguyễn Văn Trung"));
        lst1.add(new SinhVienNuocNgoai("sv2", "Trần Văn", "Lào"));
        lst1.add(new SinhVienNuocNgoai("sv3", "Lê Thị Hoa", "Anh"));
        lst1.add(new SinhVien("sv100", "John Smith"));

        System.out.println("DANH SÁCH GỐC");
        for (SinhVien sv : lst1) {
            System.out.println(sv.toString());
        }

        // Tạo bản sao kiểu 1 (sai)
        System.out.println("\nTẠO BẢN SAO KIỂU 1");
        List<SinhVien> lst2 = new ArrayList<>();
        for (SinhVien x : lst1) {
            SinhVien x2 = new SinhVien(x); // luôn là SinhVien, không đúng với lớp con
            lst2.add(x2);
        }
        for (SinhVien sv : lst2) {
            System.out.println(sv.toString());
        }

        // Tạo bản sao kiểu 2 (đúng)
        System.out.println("\nTẠO BẢN SAO KIỂU 2");
        List<SinhVien> lst3 = new ArrayList<>();
        for (SinhVien x : lst1) {
            SinhVien x2 = x.taoBanSao();
            lst3.add(x2);
        }
        for (SinhVien sv : lst3) {
            System.out.println(sv.toString());
        }

        // Tạo bản sao kiểu 3 (dùng clone)
        System.out.println("\nTẠO BẢN SAO KIỂU 3 (clone)");
        List<SinhVien> lst4 = new ArrayList<>();
        for (SinhVien x : lst1) {
            try {
                SinhVien x2 = (SinhVien) x.clone();
                lst4.add(x2);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        for (SinhVien sv : lst4) {
            System.out.println(sv.toString());
        }
    }
}
