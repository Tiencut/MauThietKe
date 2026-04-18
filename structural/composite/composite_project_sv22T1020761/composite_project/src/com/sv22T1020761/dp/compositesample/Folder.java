package com.sv22T1020761.dp.compositesample;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {
    private String name;
    private List<Component> items;
    private Folder parent;

    public Folder(String name) {
        this(name, new ArrayList<>());
    }

    public Folder(String name, List<Component> items) {
        this.name = name;
        this.items = new ArrayList<>();
        for (Component item : items) {
            addItem(item);
        }
    }

    public void addItem(Component item) {
        item.setParent(this);
        items.add(item);
    }

    @Override
    public long getTotalSize() {
        long total = 0;
        for (Component item : items) {
            total += item.getTotalSize();
        }
        return total;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFullPath() {
        if (parent == null) {
            return "/" + name;
        }
        return parent.getFullPath() + "/" + name;
    }

    @Override
    public void setParent(Folder parent) {
        this.parent = parent;
    }
}
