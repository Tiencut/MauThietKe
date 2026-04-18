package com.example.simplefactory;

/**
 * Simple Factory để tạo các đối tượng Shape.
 */
public class SimpleFactory {

    /**
     * Phương thức tĩnh để tạo Shape dựa trên loại.
     * @param shapeType Loại hình dạng ("CIRCLE", "RECTANGLE", "SQUARE")
     * @return Đối tượng Shape tương ứng
     */
    public static Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                throw new IllegalArgumentException("Loại hình dạng không hợp lệ: " + shapeType);
        }
    }
}