package vn.edu.husc.tien_nguyenhuynhminhtien.state.trangThai;

public class ContextState {
    private TrangThai trangThai;

    public ContextState(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public String layTenTrangThai() {
        return trangThai.layTenTrangThai();
    }
}