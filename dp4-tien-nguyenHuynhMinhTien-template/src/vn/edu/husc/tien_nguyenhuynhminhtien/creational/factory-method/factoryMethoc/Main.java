package vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc;

import vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.entity.Shape;
import vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.factory.SimpleFactory;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = SimpleFactory.createShape("CIRCLE");
        Shape shape2 = SimpleFactory.createShape("RECTANGLE");
        Shape shape3 = SimpleFactory.createShape("SQUARE");

        shape1.draw();
        shape2.draw();
        shape3.draw();

        try {
            SimpleFactory.createShape("TRIANGLE");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}