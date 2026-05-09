package com.sv22T1020761.dp.compositesample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File implements Component {
    private String tenFile;
    private long kichThuoc;
    private Component parent;

    public File(String tenFile, long kichThuoc) {
        this.tenFile = tenFile;
        this.kichThuoc = kichThuoc;
    }

    @Override
    public long getTotalSize() {
        return this.kichThuoc;
    }

    @Override
    public String getPath() {
        if (this.parent == null) {
            return "/" + this.tenFile;
        } else {
            return this.parent.getPath() + "/" + this.tenFile;
        }
    }
}
