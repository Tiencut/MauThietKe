package vn.edu.husc.tien_nguyenhuynhminhtien.decorator;

import vn.edu.husc.tien_nguyenhuynhminhtien.component.Xe;

public abstract class PhuKienCuaXe implements Xe {
	Xe xe;
	String tenPhuKien;
	String moTaPhuKien;
	double chiPhi;
	public PhuKienCuaXe(Xe xe, String tenPhuKien, String moTaPhuKien, double chiPhi) {
		super();
		this.xe = xe;
		this.tenPhuKien = tenPhuKien;
		this.moTaPhuKien = moTaPhuKien;
		this.chiPhi = chiPhi;
	}
	public String getTenPhuKien() {
		return tenPhuKien;
	}
	public String getMoTaPhuKien() {
		return moTaPhuKien;
	}
	public double getChiPhi() {
		return chiPhi;
	}
	
	@Override
	public String getTenMauXe() {
		return xe.getTenMauXe();
	}
	
	@Override
	public String getMoTa() {
		return xe.getMoTa() + '+' + tenPhuKien;
	}
	
	@Override
	public double getGiaBan() {
		return xe.getGiaBan() + chiPhi;
	}
}
