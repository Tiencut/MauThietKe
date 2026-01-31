package com.example.qlsv.entity;

/**
 * Entity class for Khoa table.
 */
public class Khoa {
    private int id;
    private String name;

    public Khoa(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Khoa{id=" + id + ", name='" + name + "'}";
    }
}