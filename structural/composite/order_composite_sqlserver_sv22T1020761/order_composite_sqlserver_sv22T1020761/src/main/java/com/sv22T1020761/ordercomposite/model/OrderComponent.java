package com.sv22T1020761.ordercomposite.model;

public interface OrderComponent {
    int getId();
    String getName();
    double getTotalAmount();
    void printTree(String prefix, boolean isLast);
}
