package vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Cafe;

public abstract class TrangTriCafe extends Cafe {
    protected Cafe cafe;

    public Cafe getCafe() {
        return cafe;
    }

    @Override
    public abstract String getDescription();
}
