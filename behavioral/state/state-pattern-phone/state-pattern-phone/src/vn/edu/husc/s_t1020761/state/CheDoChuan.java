package vn.edu.husc.s_t1020761.state;

import vn.edu.husc.s_t1020761.utils.Utils;

public class CheDoChuan implements CheDoDienThoai {

    @Override
    public void onCalling() {

        Utils.rung();

        Utils.phatAmThanh(80, 3);
    }

    @Override
    public void onSMSReceived() {

        Utils.phatAmThanh(60, 1);
    }

    @Override
    public void onSystemNotification() {

        Utils.phatAmThanh(50, 1);
    }

    @Override
    public String getTenCheDo() {
        return "Chuẩn";
    }
}
