package vn.edu.husc.tien_nguyenhuynhminhtien;

import vn.edu.husc.tien_nguyenhuynhminhtien.devices.Device;
import vn.edu.husc.tien_nguyenhuynhminhtien.devices.Radio;
import vn.edu.husc.tien_nguyenhuynhminhtien.devices.Tv;
import vn.edu.husc.tien_nguyenhuynhminhtien.remotes.AdvancedRemote;
import vn.edu.husc.tien_nguyenhuynhminhtien.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
