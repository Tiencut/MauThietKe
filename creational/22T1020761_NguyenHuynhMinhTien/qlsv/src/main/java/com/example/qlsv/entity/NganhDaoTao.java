package com.example.qlsv.entity;

/**
 * Entity class for NganhDaoTao table.
 */
public class NganhDaoTao {
    private int id;
    private String name;

    public NganhDaoTao(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "NganhDaoTao{id=" + id + ", name='" + name + "'}";
    }
}