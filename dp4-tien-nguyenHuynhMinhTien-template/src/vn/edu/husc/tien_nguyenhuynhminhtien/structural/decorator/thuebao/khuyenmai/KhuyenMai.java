package vn.edu.husc.dp4.nguyenHuynhMinhTien.khuyenmai;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.thuebao.ThueBao;

public abstract class KhuyenMai extends ThueBao {

    protected ThueBao thueBao;

    public KhuyenMai(ThueBao thueBao) {
        this.thueBao = thueBao;
    }
}
