package vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Cafe;

public class RhumTrangTriCafe extends TrangTriCafe {

    public RhumTrangTriCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String getDescription() {
        return cafe.getDescription() + " + Rhum";
    }

    @Override
    public double getCost() {
        return cafe.getCost() * 1.1;
    }
}
