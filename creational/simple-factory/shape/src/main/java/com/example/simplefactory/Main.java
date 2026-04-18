package com.example.simplefactory;

/**
 * Lớp Main để demo Simple Factory Pattern.
 */
public class Main {
    public static void main(String[] args) {
        // Tạo các hình dạng bằng Simple Factory
        Shape circle = SimpleFactory.createShape("CIRCLE");
        Shape rectangle = SimpleFactory.createShape("RECTANGLE");
        Shape square = SimpleFactory.createShape("SQUARE");

        // Vẽ các hình dạng
        circle.draw();
        rectangle.draw();
        square.draw();

        // Thử tạo loại không hợp lệ
        try {
            Shape invalid = SimpleFactory.createShape("TRIANGLE");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}