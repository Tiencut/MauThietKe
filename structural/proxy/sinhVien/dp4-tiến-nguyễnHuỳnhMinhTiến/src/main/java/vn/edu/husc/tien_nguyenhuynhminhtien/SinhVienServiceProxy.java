package vn.edu.husc.tien_nguyenhuynhminhtien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceProxy implements SinhVienServiceInterface {
    private SinhVienServiceInterface serviceThat = null;
    private List<SinhVien> cacheDanhSachSinhVien = null;

    @Override
    public List<SinhVien> getDanhSachSinhVien() {
        System.out.println("Proxy: nhận yêu cầu đọc danh sách sinh viên.");

        if (cacheDanhSachSinhVien != null) {
            System.out.println("Proxy: trả dữ liệu từ cache, không truy vấn lại CSDL.");
            return new ArrayList<>(cacheDanhSachSinhVien);
        }

        if (serviceThat == null) {
            System.out.println("Proxy: khởi tạo service thật theo cơ chế lazy initialization.");
            serviceThat = new SinhVienServiceImpl();
        }

        cacheDanhSachSinhVien = serviceThat.getDanhSachSinhVien();
        return new ArrayList<>(cacheDanhSachSinhVien);
    }
}
