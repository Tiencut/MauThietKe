package vn.edu.husc.tien_nguyenhuynhminhtien.strategy;

public class ContextStrategy {
    private ChienLuoc chienLuoc;

    public ContextStrategy(ChienLuoc chienLuoc) {
        this.chienLuoc = chienLuoc;
    }

    public void setChienLuoc(ChienLuoc chienLuoc) {
        this.chienLuoc = chienLuoc;
    }

    public void thucHienCongViec() {
        chienLuoc.thucHien();
    }
}
