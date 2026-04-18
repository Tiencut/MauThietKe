package com.sv22T1020761.dp.compositesample;

import java.util.Arrays;

public class ChuongTrinh {
    public static void main(String[] args) {
        Component baitap01 = new File("baitap01", 5);
        Component baitap02 = new File("baitap02", 3);
        Component abc = new File("abc", 12);
        Component test = new File("test", 1);

        Folder lyThuyet = new Folder("LYTHUYET", Arrays.asList(abc));
        Folder java = new Folder("JAVA", Arrays.asList(baitap01, baitap02, lyThuyet));
        Folder csharp = new Folder("C#");
        Folder lapTrinh = new Folder("LAPTRINH", Arrays.asList(java, csharp, test));

        System.out.println("Kich thuoc cua file baitap02: " + baitap02.getTotalSize() + " kb");
        System.out.println("Kich thuoc cua thu muc LYTHUYET: " + lyThuyet.getTotalSize() + " kb");
        System.out.println("Kich thuoc cua thu muc LAPTRINH: " + lapTrinh.getTotalSize() + " kb");
        System.out.println("Duong dan day du cua file baitap02: " + baitap02.getFullPath());
        System.out.println("Duong dan day du cua thu muc LYTHUYET: " + lyThuyet.getFullPath());
    }
}
