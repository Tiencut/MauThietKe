package vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.concrete;

import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.base.DoUongTemplate;

public class TraSuaTranChau extends DoUongTemplate {
    @Override
    protected void phaNguyenLieuChinh() {
        System.out.println("2. Pha tra den va bot sua");
    }

    @Override
    protected void themThanhPhanPhu() {
        System.out.println("3. Them tran chau den");
    }
}
