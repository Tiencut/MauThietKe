package vn.edu.husc.tien_nguyenhuynhminhtien.entity;

import java.util.List;
import java.util.ArrayList;

public class CauHinhXe {
	int cauHinhId;
	String tenMauXe;
	String tenKH;
	double giaCoBan;
	double giaCuoiCung;

	List<TrangTri> danhSachPhuKien = new ArrayList<>();
	public CauHinhXe(int cauHinhId, String tenMauXe, String tenKH, double giaCoBan, double giaCuoiCung) {
		super();
		this.cauHinhId = cauHinhId;
		this.tenMauXe = tenMauXe;
		this.tenKH = tenKH;
		this.giaCoBan = giaCoBan;
		this.giaCuoiCung = giaCuoiCung;
	}

	public int getCauHinhId() {
		return cauHinhId;
	}
	public String getTenMauXe() {
		return tenMauXe;
	}
	public String getTenKH() {
		return tenKH;
	}
	public double getGiaCoBan() {
		return giaCoBan;
	}
	public double getGiaCuoiCung() {
		return giaCuoiCung;
	}
	public List<TrangTri> getDanhSachPhuKien() {
		return danhSachPhuKien;
	}
	
	public void themPhuKien(TrangTri trangTri) {
		danhSachPhuKien.add(trangTri);
	}
	
}
