package vn.edu.husc.tien_nguyenhuynhminhtien;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        DatabaseInitializer.khoiTaoDuLieuMau();

        SinhVienServiceInterface service = new SinhVienServiceProxy();

        System.out.println("Lần gọi thứ nhất:");
        hienThiDanhSach(service.getDanhSachSinhVien());

        System.out.println("\nLần gọi thứ hai:");
        hienThiDanhSach(service.getDanhSachSinhVien());
    }

    private static void hienThiDanhSach(List<SinhVien> danhSach) {
        System.out.println("ID | Mã SV | Họ tên | Lớp | Điểm TB");
        System.out.println("----------------------------------------");
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }
}
