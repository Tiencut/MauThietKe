package vn.edu.husc.tien_nguyenhuynhminhtien;

import vn.edu.husc.tien_nguyenhuynhminhtien.normal.DemoNormal;
import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.DemoTemplateMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== PHAN 1: CODE THUONG ==========");
        DemoNormal.main(args);

        System.out.println("\n========== PHAN 2: TEMPLATE METHOD ==========");
        DemoTemplateMethod.main(args);
    }
}
