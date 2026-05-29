package vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.concrete;

import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.base.DoUongTemplate;

public class CaPheNong extends DoUongTemplate {
    @Override
    protected void phaNguyenLieuChinh() {
        System.out.println("2. Pha ca phe phin");
    }

    @Override
    protected void themThanhPhanPhu() {
        System.out.println("3. Them sua dac");
    }

    @Override
    protected boolean coCanThemDa() {
        return false;
    }
}
