package com.example.qlsv.entity;

/**
 * Entity class for GiangVien table.
 */
public class GiangVien {
    private int id;
    private String name;

    public GiangVien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "GiangVien{id=" + id + ", name='" + name + "'}";
    }
}