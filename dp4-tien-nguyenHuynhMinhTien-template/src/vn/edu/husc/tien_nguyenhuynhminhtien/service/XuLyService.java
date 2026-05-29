package vn.edu.husc.tien_nguyenhuynhminhtien.service;

import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.component.DoiTuongGoc;
import vn.edu.husc.tien_nguyenhuynhminhtien.component.ThanhPhan;
import vn.edu.husc.tien_nguyenhuynhminhtien.decorator.ChucNangCuThe;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.CauHinh;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.ChucNangThem;

public class XuLyService {

    // Mau Decorator: tao doi tuong goc roi boc tung chuc nang them.
    public ThanhPhan taoDoiTuongTheoDecorator(CauHinh cauHinh) {
        ThanhPhan doiTuong = new DoiTuongGoc(
                cauHinh.getMau().getTen(),
                cauHinh.getMau().getGia()
        );

        for (ChucNangThem cn : cauHinh.getDanhSachChucNang()) {
            doiTuong = new ChucNangCuThe(doiTuong, cn);
        }

        return doiTuong;
    }

    public void inDanhSachCauHinh(List<CauHinh> danhSach) {
        for (CauHinh ch : danhSach) {
            ThanhPhan doiTuong = taoDoiTuongTheoDecorator(ch);

            System.out.println("----------------------------------");
            System.out.println("Khach hang: " + ch.getTenKhachHang());
            System.out.println("Mau: " + ch.getMau().getTen());
            System.out.println("Tong chi phi: " + doiTuong.getChiPhi());
            System.out.println("Mo ta: " + doiTuong.getMoTa());
            System.out.println("Danh sach chuc nang:");

            for (ChucNangThem cn : ch.getDanhSachChucNang()) {
                System.out.println("  - " + cn.getTen() + " | " + cn.getMoTa() + " | " + cn.getChiPhi());
            }
        }
    }
}
