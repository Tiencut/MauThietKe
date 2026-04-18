package com.example.simplefactory;

/**
 * Lớp Circle triển khai Shape.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn");
    }
}