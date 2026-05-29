package vn.edu.husc.tien_nguyenhuynhminhtien.main;

import java.util.List;

import vn.edu.husc.tien_nguyenhuynhminhtien.dao.CauHinhDAO;
import vn.edu.husc.tien_nguyenhuynhminhtien.dao.ChucNangThemDAO;
import vn.edu.husc.tien_nguyenhuynhminhtien.dao.MauDoiTuongDAO;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.CauHinh;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.ChucNangThem;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.MauDoiTuong;
import vn.edu.husc.tien_nguyenhuynhminhtien.service.XuLyService;

public class Main {
    public static void main(String[] args) {
        MauDoiTuongDAO mauDAO = new MauDoiTuongDAO();
        ChucNangThemDAO chucNangDAO = new ChucNangThemDAO();
        CauHinhDAO cauHinhDAO = new CauHinhDAO();
        XuLyService service = new XuLyService();

        System.out.println("========== CAU 1/2.1: DANH SACH MAU DOI TUONG ==========");
        List<MauDoiTuong> dsMau = mauDAO.layTatCa();
        for (MauDoiTuong mau : dsMau) {
            System.out.println(mau);
        }

        System.out.println("\n========== CAU 2.2: DANH SACH CHUC NANG / PHU KIEN ==========");
        List<ChucNangThem> dsChucNang = chucNangDAO.layTatCa();
        for (ChucNangThem cn : dsChucNang) {
            System.out.println(cn);
        }

        System.out.println("\n========== CAU 2.3: DANH SACH CAU HINH ==========");
        List<CauHinh> dsCauHinh = cauHinhDAO.layTatCa();
        service.inDanhSachCauHinh(dsCauHinh);

        // Test nhanh cac pattern khac khi can:
        // new vn.edu.husc.tien_nguyenhuynhminhtien.strategy.ContextStrategy(new vn.edu.husc.tien_nguyenhuynhminhtien.strategy.ChienLuocA()).thucHienCongViec();
        // new vn.edu.husc.tien_nguyenhuynhminhtien.state.ContextState(new vn.edu.husc.tien_nguyenhuynhminhtien.state.TrangThaiA()).yeuCau();
        // new vn.edu.husc.tien_nguyenhuynhminhtien.proxy.DichVuProxy(true).thucHien();
    }
}
