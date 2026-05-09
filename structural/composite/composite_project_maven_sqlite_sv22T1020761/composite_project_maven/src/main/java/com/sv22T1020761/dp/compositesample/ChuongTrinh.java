package com.sv22T1020761.dp.compositesample;

import java.util.Arrays;

public class ChuongTrinh {
    public static void main(String[] args) {
        Folder LAPTRINH = new Folder("LAPTRINH", null);
        Folder JAVA = new Folder("JAVA", LAPTRINH);
        Folder CSHARP = new Folder("CSHARP", LAPTRINH);
        Folder LYTHUYET = new Folder("LYTHUYET", JAVA);

        Component test = new File("test", 1, LAPTRINH);
        Component baitap01 = new File("baitap01", 5, JAVA);
        Component baitap02 = new File("baitap02", 3, JAVA);
        Component abc = new File("abc", 12, LYTHUYET);

        LYTHUYET.setLstItem(Arrays.asList(abc));
        JAVA.setLstItem(Arrays.asList(baitap01, baitap02, LYTHUYET));
        CSHARP.setLstItem(Arrays.asList());
        LAPTRINH.setLstItem(Arrays.asList(JAVA, CSHARP, test));

        System.out.println("Kich thuoc cua file baitap01: " + baitap01.getTotalSize() + " kb");
        System.out.println("Kich thuoc cua folder LYTHUYET: " + LYTHUYET.getTotalSize() + " kb");
        System.out.println("Kich thuoc cua folder LAPTRINH: " + LAPTRINH.getTotalSize() + " kb");

        System.out.println("Duong dan day du cua file baitap02: " + baitap02.getPath());
        System.out.println("Duong dan day du cua thu muc LYTHUYET: " + LYTHUYET.getPath());
    }
}