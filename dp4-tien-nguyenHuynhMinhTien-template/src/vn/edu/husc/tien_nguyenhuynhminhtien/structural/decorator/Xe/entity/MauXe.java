package vn.edu.husc.tien_nguyenhuynhminhtien.entity;

public class MauXe {
	int xeId;
	String tenMauXe;
	double giaCoBan;
	String moTa;
	
	public MauXe(int xeId, String tenMauXe, double giaCoBan, String moTa) {
		super();
		this.xeId = xeId;
		this.tenMauXe = tenMauXe;
		this.giaCoBan = giaCoBan;
		this.moTa = moTa;
	}

	public int getXeId() {
		return xeId;
	}

	public void setXeId(int xeId) {
		this.xeId = xeId;
	}

	public String getTenMauXe() {
		return tenMauXe;
	}

	public void setTenMauXe(String tenMauXe) {
		this.tenMauXe = tenMauXe;
	}

	public double getGiaCoBan() {
		return giaCoBan;
	}

	public void setGiaCoBan(double giaCoBan) {
		this.giaCoBan = giaCoBan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	@Override
	public String toString() {
		return "MauXe{" +
				"xeId=" + xeId +
				", tenMauXe='" + tenMauXe + '\'' +
				", giaCoBan=" + giaCoBan +
				", moTa='" + moTa + '\'' +
				'}';
	}
	
}
