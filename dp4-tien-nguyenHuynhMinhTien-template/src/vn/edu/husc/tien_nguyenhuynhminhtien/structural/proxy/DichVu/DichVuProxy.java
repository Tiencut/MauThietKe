package vn.edu.husc.tien_nguyenhuynhminhtien.proxy;

public class DichVuProxy implements DichVu {
    private DichVuThat dichVuThat;
    private boolean coQuyen;

    public DichVuProxy(boolean coQuyen) {
        this.coQuyen = coQuyen;
    }

    @Override
    public void thucHien() {
        if (!coQuyen) {
            System.out.println("Khong co quyen truy cap");
            return;
        }

        if (dichVuThat == null) {
            dichVuThat = new DichVuThat();
        }

        System.out.println("Proxy kiem tra xong, goi dich vu that");
        dichVuThat.thucHien();
    }
}
