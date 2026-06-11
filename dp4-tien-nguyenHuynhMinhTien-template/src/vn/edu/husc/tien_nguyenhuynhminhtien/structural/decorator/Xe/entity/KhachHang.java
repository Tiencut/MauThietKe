package vn.edu.husc.tien_nguyenhuynhminhtien.entity;

public class KhachHang {
	int KH_id;
	String tenKH;

	public KhachHang(int kH_id, String tenKH) {
		super();
		KH_id = kH_id;
		this.tenKH = tenKH;
	}

	public int getKH_id() {
		return KH_id;
	}

	public String getTenKH() {
		return tenKH;
	}

}
