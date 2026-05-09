package vn.edu.husc.s_t1020761.state;

import vn.edu.husc.s_t1020761.utils.Utils;

public class CheDoYenLang implements CheDoDienThoai {

    @Override
    public void onCalling() {
        Utils.rung();
    }

    @Override
    public void onSMSReceived() {

    }

    @Override
    public void onSystemNotification() {

    }

    @Override
    public String getTenCheDo() {
        return "Yên lặng";
    }
}
