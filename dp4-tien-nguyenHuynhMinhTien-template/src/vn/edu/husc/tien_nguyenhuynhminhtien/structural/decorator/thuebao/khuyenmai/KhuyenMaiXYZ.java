package vn.edu.husc.dp4.nguyenHuynhMinhTien.khuyenmai;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.thuebao.ThueBao;

public class KhuyenMaiXYZ extends KhuyenMai {

    public KhuyenMaiXYZ(ThueBao thueBao) {
        super(thueBao);
    }

    @Override
    public int getPhiThueBao() {
        return thueBao.getPhiThueBao();
    }

    @Override
    public int getSoPhutGoiFree() {
        return thueBao.getSoPhutGoiFree() + 500;
    }

    @Override
    public int getSoTinNhanFree() {
        return thueBao.getSoTinNhanFree();
    }

    @Override
    public int getGiaGoi() {
        return 0;
    }

    @Override
    public int getGiaTinNhan() {
        return thueBao.getGiaTinNhan();
    }
}
