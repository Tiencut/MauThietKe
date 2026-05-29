package vn.edu.husc.dp4.nguyenHuynhMinhTien.main;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.service.XeService;

public class Main {
    public static void main(String[] args) {
        XeService service = new XeService();

        System.out.println("BAI THI MAU THIET KE - DECORATOR PATTERN");
        System.out.println("Project: dp4-tien-nguyenHuynhMinhTien");
        System.out.println("Package: vn.edu.husc.dp4.nguyenHuynhMinhTien");

        service.hienThiTatCaMauXe();
        service.hienThiTatCaPhuKien();
        service.hienThiTatCaCauHinhXe();
    }
}
