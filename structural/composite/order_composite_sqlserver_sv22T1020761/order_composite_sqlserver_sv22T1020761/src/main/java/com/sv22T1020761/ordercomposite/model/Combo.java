package com.sv22T1020761.ordercomposite.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combo implements OrderComponent {
    private final int id;
    private final String name;
    private final List<OrderComponent> children = new ArrayList<>();

    public Combo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addChild(OrderComponent component) {
        children.add(component);
    }

    public List<OrderComponent> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalAmount() {
        return children.stream().mapToDouble(OrderComponent::getTotalAmount).sum();
    }

    @Override
    public void printTree(String prefix, boolean isLast) {
        if (prefix.isEmpty()) {
            System.out.println(name + " - " + String.format("%.0f", getTotalAmount()));
        } else {
            String branch = isLast ? "└── " : "├── ";
            System.out.println(prefix + branch + name + " - " + String.format("%.0f", getTotalAmount()));
        }

        for (int i = 0; i < children.size(); i++) {
            OrderComponent child = children.get(i);
            boolean childIsLast = i == children.size() - 1;
            String childPrefix;
            if (prefix.isEmpty()) {
                childPrefix = "";
            } else {
                childPrefix = prefix + (isLast ? "    " : "│   ");
            }
            child.printTree(childPrefix, childIsLast);
        }
    }

    @Override
    public String toString() {
        return String.format("Combo{id=%d, name='%s', total=%.0f, children=%d}",
                id, name, getTotalAmount(), children.size());
    }
}
