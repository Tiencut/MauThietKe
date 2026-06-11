package vn.edu.husc.dp4.nguyenHuynhMinhTien.khuyenmai;

import vn.edu.husc.dp4.nguyenHuynhMinhTien.thuebao.ThueBao;

public class KhuyenMaiABC extends KhuyenMai {

    public KhuyenMaiABC(ThueBao thueBao) {
        super(thueBao);
    }

    @Override
    public int getPhiThueBao() {
        return thueBao.getPhiThueBao();
    }

    @Override
    public int getSoPhutGoiFree() {
        return thueBao.getSoPhutGoiFree();
    }

    @Override
    public int getSoTinNhanFree() {
        return thueBao.getSoTinNhanFree() + 1000;
    }

    @Override
    public int getGiaGoi() {
        return thueBao.getGiaGoi();
    }

    @Override
    public int getGiaTinNhan() {
        return thueBao.getGiaTinNhan();
    }
}
