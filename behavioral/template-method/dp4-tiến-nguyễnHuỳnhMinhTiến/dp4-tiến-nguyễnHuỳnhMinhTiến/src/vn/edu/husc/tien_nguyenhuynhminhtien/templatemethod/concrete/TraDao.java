package vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.concrete;

import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.base.DoUongTemplate;

public class TraDao extends DoUongTemplate {
    @Override
    protected void phaNguyenLieuChinh() {
        System.out.println("2. Pha tra dao");
    }

    @Override
    protected void themThanhPhanPhu() {
        System.out.println("3. Them dao mieng");
    }
}
