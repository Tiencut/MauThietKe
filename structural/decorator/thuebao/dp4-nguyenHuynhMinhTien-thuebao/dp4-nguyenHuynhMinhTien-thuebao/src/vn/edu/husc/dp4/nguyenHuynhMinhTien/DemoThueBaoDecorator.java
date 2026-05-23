package vn.edu.husc.dp4.nguyenHuynhMinhTien;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.thuebao.ThueBao;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.thuebao.Tomato;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.khuyenmai.KhuyenMaiABC;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.khuyenmai.KhuyenMaiXYZ;

public class DemoThueBaoDecorator {

    public static void main(String[] args) {

        ThueBao tb = new Tomato();

        System.out.println("Phi thue bao: " + tb.getPhiThueBao());
        System.out.println("So phut goi free: " + tb.getSoPhutGoiFree());
        System.out.println("So tin nhan free: " + tb.getSoTinNhanFree());
        System.out.println("Gia goi: " + tb.getGiaGoi());
        System.out.println("Gia tin nhan: " + tb.getGiaTinNhan());

        System.out.println("-------------------------");

        tb = new KhuyenMaiABC(tb);
        tb = new KhuyenMaiXYZ(tb);

        System.out.println("Sau khi ap dung khuyen mai:");
        System.out.println("Phi thue bao: " + tb.getPhiThueBao());
        System.out.println("So phut goi free: " + tb.getSoPhutGoiFree());
        System.out.println("So tin nhan free: " + tb.getSoTinNhanFree());
        System.out.println("Gia goi: " + tb.getGiaGoi());
        System.out.println("Gia tin nhan: " + tb.getGiaTinNhan());
    }
}
