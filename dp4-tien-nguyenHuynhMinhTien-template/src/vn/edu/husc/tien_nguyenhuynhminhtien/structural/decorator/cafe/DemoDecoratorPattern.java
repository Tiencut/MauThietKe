package vn.edu.husc.dp4.nguyenHuynhMinhTien;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.Cafe;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.component.CafeExpresso;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator.RhumTrangTriCafe;
import vn.edu.husc.dp4.nguyenHuynhMinhTien.decorator.SuaTrangTriCafe;

public class DemoDecoratorPattern {

    public static void main(String[] args) {
        Cafe cafe = new CafeExpresso();

        System.out.println(cafe.getDescription() + " --> " + cafe.getCost());

        cafe = new RhumTrangTriCafe(cafe);
        System.out.println(cafe.getDescription() + " --> " + cafe.getCost());

        cafe = new SuaTrangTriCafe(cafe);
        System.out.println(cafe.getDescription() + " --> " + cafe.getCost());
    }
}
