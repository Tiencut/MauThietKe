package com.example.simplefactory;

/**
 * Lớp Square triển khai Shape.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông");
    }
}