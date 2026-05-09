package vn.edu.husc.s_t1020761.context;

import vn.edu.husc.s_t1020761.state.CheDoDienThoai;

public class DienThoai {

    private CheDoDienThoai cheDo;

    public DienThoai(CheDoDienThoai cheDo) {
        this.cheDo = cheDo;
    }

    public void setCheDo(CheDoDienThoai cheDo) {

        this.cheDo = cheDo;

        System.out.println(
                "Da chuyen sang che do: "
                + cheDo.getTenCheDo());
    }

    public void coCuocGoiDen() {

        System.out.println("\n=== Co cuoc goi den ===");

        cheDo.onCalling();
    }

    public void coTinNhanDen() {

        System.out.println("\n=== Co tin nhan den ===");

        cheDo.onSMSReceived();
    }

    public void coThongBaoHeThong() {

        System.out.println("\n=== Co su kien he thong ===");

        cheDo.onSystemNotification();
    }
}
