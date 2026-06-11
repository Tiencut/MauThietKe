package vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Cafe;

public class SuaTrangTriCafe extends TrangTriCafe {

    public SuaTrangTriCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String getDescription() {
        return cafe.getDescription() + " + Sua";
    }

    @Override
    public double getCost() {
        return cafe.getCost() + 1200;
    }
}
