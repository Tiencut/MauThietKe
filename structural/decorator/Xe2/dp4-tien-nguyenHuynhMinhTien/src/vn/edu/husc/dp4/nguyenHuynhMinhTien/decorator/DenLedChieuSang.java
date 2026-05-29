package vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Xe;

public class DenLedChieuSang extends PhuKienCuaXe {
    public DenLedChieuSang(Xe xe, String moTaPhuKien, double chiPhi) {
        super(xe, "Den LED Chieu Sang", moTaPhuKien, chiPhi);
    }
}
