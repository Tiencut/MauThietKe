package vn.edu.husc.tien_nguyenhuynhminhtien.entity;

public class TrangTri {
	int trangTriId;
	String tenTrangTri;
	double chiPhiThem;
	String moTa;

	public TrangTri(int trangTriId, String tenTrangTri, double chiPhiThem, String moTa) {
		super();
		this.trangTriId = trangTriId;
		this.tenTrangTri = tenTrangTri;
		this.chiPhiThem = chiPhiThem;
		this.moTa = moTa;
	}

	public int getTrangTriId() {
		return trangTriId;
	}

	public void setTrangTriId(int trangTriId) {
		this.trangTriId = trangTriId;
	}

	public String getTenTrangTri() {
		return tenTrangTri;
	}

	public void setTenTrangTri(String tenTrangTri) {
		this.tenTrangTri = tenTrangTri;
	}

	public double getChiPhiThem() {
		return chiPhiThem;
	}

	public void setChiPhiThem(double chiPhiThem) {
		this.chiPhiThem = chiPhiThem;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
