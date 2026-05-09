package com.sv22T1020761.ordercomposite;

import com.sv22T1020761.ordercomposite.db.DatabaseConfig;
import com.sv22T1020761.ordercomposite.db.DatabaseInitializer;
import com.sv22T1020761.ordercomposite.db.OrderRepository;
import com.sv22T1020761.ordercomposite.model.OrderComponent;
import com.sv22T1020761.ordercomposite.service.SampleDataFactory;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== THONG TIN KET NOI SQL SERVER ===");
            System.out.println("Server   : " + DatabaseConfig.SERVER + ":" + DatabaseConfig.PORT);
            System.out.println("Database : " + DatabaseConfig.DATABASE);
            System.out.println("Username : " + DatabaseConfig.USERNAME);
            System.out.println();

            DatabaseInitializer initializer = new DatabaseInitializer();
            initializer.initializeDatabase();

            OrderRepository repository = new OrderRepository();
            repository.clearData();

            OrderComponent root = SampleDataFactory.createSampleOrder();
            repository.saveOrderTree(root);

            System.out.println("=== CAY DON HANG BAN DAU ===");
            root.printTree("", true);
            System.out.printf("Tong tien: %.0f%n%n", root.getTotalAmount());

            int rootId = 105;
            OrderComponent loadedRoot = repository.findById(rootId);
            System.out.println("=== DOC LAI TU DATABASE THEO ID = " + rootId + " ===");
            if (loadedRoot != null) {
                loadedRoot.printTree("", true);
                System.out.printf("Tong tien: %.0f%n", loadedRoot.getTotalAmount());
            } else {
                System.out.println("Khong tim thay doi tuong co ID = " + rootId);
            }
        } catch (Exception ex) {
            System.err.println("Loi khi chay chuong trinh: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
