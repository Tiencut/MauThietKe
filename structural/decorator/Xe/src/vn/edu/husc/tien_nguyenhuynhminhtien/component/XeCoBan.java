package vn.edu.husc.tien_nguyenhuynhminhtien.component;

public class XeCoBan implements Xe {
	int xeId;
	String tenMauXe;
	String moTa;
	double giaBan;
	public XeCoBan(int xeId, String tenMauXe, String moTa, double giaBan) {
		super();
		this.xeId = xeId;
		this.tenMauXe = tenMauXe;
		this.moTa = moTa;
		this.giaBan = giaBan;
	}
	public int getXeId() {
		return xeId;
	}
	public String getTenMauXe() {
		return tenMauXe;
	}
	public String getMoTa() {
		return moTa;
	}
	public double getGiaBan() {
		return giaBan;
	}
	
	
}
