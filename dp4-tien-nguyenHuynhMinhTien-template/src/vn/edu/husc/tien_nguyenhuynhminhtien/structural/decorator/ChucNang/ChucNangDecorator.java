package vn.edu.husc.tien_nguyenhuynhminhtien.decorator;

import vn.edu.husc.tien_nguyenhuynhminhtien.component.ThanhPhan;

public abstract class ChucNangDecorator implements ThanhPhan {
    protected ThanhPhan thanhPhan;

    public ChucNangDecorator(ThanhPhan thanhPhan) {
        this.thanhPhan = thanhPhan;
    }
}
