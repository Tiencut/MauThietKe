package com.sv22T1020761.ordercomposite.service;

import com.sv22T1020761.ordercomposite.model.Combo;
import com.sv22T1020761.ordercomposite.model.OrderComponent;
import com.sv22T1020761.ordercomposite.model.Product;

public final class SampleDataFactory {
    private SampleDataFactory() {
    }

    public static OrderComponent createSampleOrder() {
        Product sofa = new Product(1, "Sofa cao cap", 15000000, 1);
        Product banTra = new Product(2, "Ban tra go", 3500000, 1);
        Product tham = new Product(3, "Tham trai san long cuu", 2200000, 1);
        Product goi4 = new Product(4, "Goi tua lung", 250000, 4);
        Product denDung2 = new Product(5, "Den dung co dien", 1800000, 2);
        Product denBan = new Product(6, "Den ban hoc", 750000, 1);
        Product keTv = new Product(7, "Ke TV", 4800000, 1);
        Product manHinh = new Product(8, "Man hinh 55 inch", 12000000, 1);
        Product loa = new Product(9, "Loa soundbar", 6500000, 1);
        Product goi2 = new Product(10, "Goi tua lung", 250000, 2);

        Combo comboPhongKhachCoBan = new Combo(101, "Combo Phong khach co ban");
        comboPhongKhachCoBan.addChild(sofa);
        comboPhongKhachCoBan.addChild(banTra);
        comboPhongKhachCoBan.addChild(tham);
        comboPhongKhachCoBan.addChild(goi4);

        Combo comboAnhSang = new Combo(102, "Combo Anh sang");
        comboAnhSang.addChild(denDung2);
        comboAnhSang.addChild(denBan);

        Combo comboPhongKhachCaoCap = new Combo(103, "Combo Phong khach cao cap");
        comboPhongKhachCaoCap.addChild(comboPhongKhachCoBan);
        comboPhongKhachCaoCap.addChild(comboAnhSang);
        comboPhongKhachCaoCap.addChild(keTv);

        Combo comboGiaiTri = new Combo(104, "Combo Giai tri");
        comboGiaiTri.addChild(manHinh);
        comboGiaiTri.addChild(loa);

        Combo tronBoNoiThat = new Combo(105, "Tron bo noi that phong khach");
        tronBoNoiThat.addChild(comboPhongKhachCaoCap);
        tronBoNoiThat.addChild(comboGiaiTri);
        tronBoNoiThat.addChild(goi2);

        return tronBoNoiThat;
    }
}
