package com.sv22T1020761.dp.compositesample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Folder implements Component {
    private String tenThuMuc;
    private Component parent;
    private List<Component> lstItem = new ArrayList<>();

    public Folder(String tenThuMuc, Component parent) {
        this.tenThuMuc = tenThuMuc;
        this.parent = parent;
    }

    @Override
    public long getTotalSize() {
        long kq = 0;
        for (Component x : lstItem) {
            kq += x.getTotalSize();
        }
        return kq;
    }

    @Override
    public String getPath() {
        if (this.parent == null)
            return "/" + this.tenThuMuc;
        else
            return this.parent.getPath() + "/" + this.tenThuMuc;
    }
}
