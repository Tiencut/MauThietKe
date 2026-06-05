package vn.edu.husc.tien_nguyenhuynhminhtien.state.trangThai;

public class TrangThaiOFF implements TrangThai {
    @Override
    public void NutON(ContextState context) {
        System.out.println("Trang thai ON");
        // context.setTrangThai(new TrangThaiB());
    }
    
    @Override
    public void NutOFF(ContextState context) {
    	System.out.println("Trang thai OFF");
    }
    
    @Override
    public String layTenTrangThai() {
    	return "OFF";
    }
}
