package vn.edu.husc.s_t1020761.state;

public interface CheDoDienThoai {

    void onCalling();

    void onSMSReceived();

    void onSystemNotification();

    String getTenCheDo();
}
