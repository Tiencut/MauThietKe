package com.sv22T1020761.dp.compositesample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeRecord {
    private int id;
    private String type;
    private String name;
    private long size;
    private Integer parentId;
}
