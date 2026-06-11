package vn.edu.husc.s_t1020761;

import vn.edu.husc.s_t1020761.context.DienThoai;
import vn.edu.husc.s_t1020761.state.*;

public class ChuongTrinh {

    public static void main(String[] args) {

        DienThoai dt =
                new DienThoai(new CheDoChuan());

        dt.setCheDo(new CheDoNgoaiTroi());

        dt.coTinNhanDen();

        dt.coThongBaoHeThong();

        dt.coCuocGoiDen();

        dt.setCheDo(new CheDoYenLang());

        dt.coTinNhanDen();

        dt.coCuocGoiDen();
    }
}
