package vn.edu.husc.s_t1020761.state;

import vn.edu.husc.s_t1020761.utils.Utils;

public class CheDoNgoaiTroi implements CheDoDienThoai {

    @Override
    public void onCalling() {

        Utils.rung();
        Utils.rung();
        Utils.rung();

        Utils.phatAmThanh(100, 5);
    }

    @Override
    public void onSMSReceived() {

        Utils.phatAmThanh(100, 1);
    }

    @Override
    public void onSystemNotification() {

        Utils.phatAmThanh(90, 1);
    }

    @Override
    public String getTenCheDo() {
        return "Ngoài trời";
    }
}
