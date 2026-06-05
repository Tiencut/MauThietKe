package vn.edu.husc.tien_nguyenhuynhminhtien.proxy;

public class Main {
    public static void main(String[] args) {
        DichVu dichVuCoQuyen = new DichVuProxy(true);
        DichVu dichVuKhongQuyen = new DichVuProxy(false);

        System.out.println("Thuc hien dich vu co quyen:");
        dichVuCoQuyen.thucHien();

        System.out.println("\nThuc hien dich vu khong co quyen:");
        dichVuKhongQuyen.thucHien();
    }
}
