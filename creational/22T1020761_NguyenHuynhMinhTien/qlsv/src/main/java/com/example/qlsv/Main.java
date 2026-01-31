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

        System.out.println("\nKhoa:");
        service.getAllKhoa().forEach(System.out::println);

        System.out.println("\nGiangVien:");
        service.getAllGiangVien().forEach(System.out::println);

        System.out.println("\nNganhDaoTao:");
        service.getAllNganhDaoTao().forEach(System.out::println);
    }
}