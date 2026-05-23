package vn.edu.husc.tien_nguyenhuynhminhtien.remotes;

import vn.edu.husc.tien_nguyenhuynhminhtien.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
