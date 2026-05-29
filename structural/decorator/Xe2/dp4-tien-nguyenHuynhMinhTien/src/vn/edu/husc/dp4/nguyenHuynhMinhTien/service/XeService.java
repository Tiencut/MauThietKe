package vn.edu.husc.dp4.nguyenHuynhMinhTien.service;

import java.util.List;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.dao.CauHinhXeDAO;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.dao.TrangTriDAO;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.dao.XeDAO;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.entity.CauHinhXe;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.entity.MauXe;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.entity.TrangTri;

public class XeService {
    private XeDAO xeDAO = new XeDAO();
    private TrangTriDAO trangTriDAO = new TrangTriDAO();
    private CauHinhXeDAO cauHinhXeDAO = new CauHinhXeDAO();

    public void hienThiTatCaMauXe() {
        List<MauXe> ds = xeDAO.layTatCaMauXe();
        System.out.println("\n========== DANH SACH MAU XE ==========");
        System.out.printf("%-5s %-30s %15s  %s%n", "ID", "Ten mau xe", "Gia co ban", "Mo ta");
        for (MauXe xe : ds) {
            System.out.println(xe);
        }
    }

    public void hienThiTatCaPhuKien() {
        List<TrangTri> ds = trangTriDAO.layTatCaPhuKien();
        System.out.println("\n========== DANH SACH PHU KIEN ==========");
        System.out.printf("%-5s %-30s %15s  %s%n", "ID", "Ten phu kien", "Chi phi them", "Mo ta");
        for (TrangTri trangTri : ds) {
            System.out.println(trangTri);
        }
    }

    public void hienThiTatCaCauHinhXe() {
        List<CauHinhXe> ds = cauHinhXeDAO.layTatCaCauHinhXe();
        System.out.println("\n========== DANH SACH XE DA DUOC CAU HINH ==========");

        for (CauHinhXe cauHinh : ds) {
            System.out.println("\nMa cau hinh: " + cauHinh.getCauHinhId());
            System.out.println("Ten mau xe: " + cauHinh.getTenMauXe());
            System.out.println("Ten khach hang: " + cauHinh.getTenKhachHang());
            System.out.printf("Tong chi phi: %.0f%n", cauHinh.getGiaBanCuoiCung());
            System.out.println("Danh sach phu kien:");
            System.out.printf("  %-30s %-45s %15s%n", "Ten phu kien", "Mo ta", "Gia phu kien");

            for (TrangTri pk : cauHinh.getDanhSachPhuKien()) {
                System.out.printf("  %-30s %-45s %15.0f%n",
                        pk.getTenTrangTri(),
                        pk.getMoTa(),
                        pk.getChiPhiThem()
                );
            }
        }
    }
}
