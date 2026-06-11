package com.example.qlsv;

import com.example.qlsv.config.DatabaseInitializer;
import com.example.qlsv.service.QuanLySinhVienService;

/**
 * Main class to demonstrate the Singleton pattern and data retrieval.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize database
        DatabaseInitializer.initialize();

        // Service layer
        QuanLySinhVienService service = new QuanLySinhVienService();

        // Display data from all tables
        System.out.println("SinhVien:");
        service.getAllSinhVien().forEach(System.out::println);

        System.out.println("\nKhoa (lần 1):");
        service.getAllKhoa().forEach(System.out::println);

        System.out.println("\nKhoa (lần 2 - từ cache):");
        service.getAllKhoa().forEach(System.out::println);

        System.out.println("\nGiangVien:");
        service.getAllGiangVien().forEach(System.out::println);

        System.out.println("\nNganhDaoTao:");
        service.getAllNganhDaoTao().forEach(System.out::println);

        // Test caching cho tính điểm trung bình
        System.out.println("\nĐiểm trung bình sinh viên ID 1 (lần 1):");
        System.out.println(service.tinhDiemTrungBinh(1));

        System.out.println("\nĐiểm trung bình sinh viên ID 1 (lần 2 - từ cache):");
        System.out.println(service.tinhDiemTrungBinh(1));

        System.out.println("\nĐiểm trung bình sinh viên ID 2 (lần đầu):");
        System.out.println(service.tinhDiemTrungBinh(2));
    }
}