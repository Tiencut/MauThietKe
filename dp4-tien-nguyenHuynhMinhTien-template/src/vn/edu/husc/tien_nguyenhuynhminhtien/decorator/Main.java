package vn.edu.husc.tien_nguyenhuynhminhtien.decorator;

import vn.edu.husc.tien_nguyenhuynhminhtien.component.DoiTuongGoc;
import vn.edu.husc.tien_nguyenhuynhminhtien.component.ThanhPhan;
import vn.edu.husc.tien_nguyenhuynhminhtien.entity.ChucNangThem;

public class Main {
	public static void main(String[] args) {
		ThanhPhan xe = new DoiTuongGoc("Xe máy Honda", 1000.0);

		ChucNangThem camera = new ChucNangThem(1, "Camera hành trình", "Ghi hình", 200.0);
		ChucNangThem denLed = new ChucNangThem(2, "Đèn LED", "Đèn chiếu sáng", 150.0);

		ThanhPhan xeCamera = new ChucNangCuThe(xe, camera);
		ThanhPhan xeFull = new ChucNangCuThe(xeCamera, denLed);

		System.out.println("Tên: " + xeFull.getTen());
		System.out.println("Mô tả: " + xeFull.getMoTa());
		System.out.println("Chi phí: " + xeFull.getChiPhi());
	}
}
