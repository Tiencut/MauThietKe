package com.sv22T1020761.dp.compositesample;

public interface Component {
    long getTotalSize();
    String getName();
    String getFullPath();
    void setParent(Folder parent);
}
