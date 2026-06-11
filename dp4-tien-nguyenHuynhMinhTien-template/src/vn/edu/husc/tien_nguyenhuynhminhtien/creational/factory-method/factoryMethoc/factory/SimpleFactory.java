package vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.factory;

import vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.entity.Circle;
import vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.entity.Rectangle;
import vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.entity.Shape;
import vn.edu.husc.tien_nguyenhuynhminhtien.factoryMethoc.entity.Square;

public class SimpleFactory {
    public static Shape createShape(String type) {
        if (type == null) {
            return null;
        }

        switch (type.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                throw new IllegalArgumentException("Loại không hợp lệ: " + type);
        }
    }
}
