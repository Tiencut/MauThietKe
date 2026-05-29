package vn.edu.husc.tien_nguyenhuynhminhtien.state;

public class TrangThaiA implements TrangThai {
    @Override
    public void xuLy(ContextState context) {
        System.out.println("Dang xu ly o trang thai A");
        // context.setTrangThai(new TrangThaiB());
    }
}
