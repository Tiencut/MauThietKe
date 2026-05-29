package vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Xe;

public class Loa extends PhuKienCuaXe {
    public Loa(Xe xe, String moTaPhuKien, double chiPhi) {
        super(xe, "Loa", moTaPhuKien, chiPhi);
    }
}
