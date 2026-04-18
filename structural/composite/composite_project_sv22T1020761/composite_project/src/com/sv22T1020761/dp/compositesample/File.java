package com.sv22T1020761.dp.compositesample;

public class File implements Component {
    private String name;
    private long size;
    private Folder parent;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public long getTotalSize() {
        return size;
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
