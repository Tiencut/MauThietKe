package com.example.qlsv.entity;

/**
 * Entity class for SinhVien table.
 */
public class SinhVien {
    private int id;
    private String name;
    private int age;

    public SinhVien(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "SinhVien{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}