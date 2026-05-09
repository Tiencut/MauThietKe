package com.sv22T1020761.ordercomposite.model;

public class Product implements OrderComponent {
    private final int id;
    private final String name;
    private final double unitPrice;
    private final int quantity;

    public Product(int id, String name, double unitPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getTotalAmount() {
        return unitPrice * quantity;
    }

    @Override
    public void printTree(String prefix, boolean isLast) {
        String branch = prefix.isEmpty() ? "" : (isLast ? "└── " : "├── ");
        String qtyInfo = quantity > 1 ? " (x" + quantity + ")" : "";
        System.out.printf("%s%s%s - %.0f%n", prefix, branch, name + qtyInfo, getTotalAmount());
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', unitPrice=%.0f, quantity=%d, total=%.0f}",
                id, name, unitPrice, quantity, getTotalAmount());
    }
}
