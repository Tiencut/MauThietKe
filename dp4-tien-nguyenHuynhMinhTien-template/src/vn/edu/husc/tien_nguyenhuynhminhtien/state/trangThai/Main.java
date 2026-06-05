package vn.edu.husc.tien_nguyenhuynhminhtien.state.trangThai;

public class Main {
	public static void main(String[] args) {
		// Khởi tạo Context với trạng thái OFF ban đầu
		ContextState context = new ContextState(new TrangThaiOFF());
		System.out.println("Trang thai ban dau: " + context.layTenTrangThai());

		// Tạo trạng thái ON, gọi NutON và gán vào context
		TrangThai trangThaiOn = new TrangThaiON();
		System.out.println("\nGoi NutON tren doi tuong ON:");
		trangThaiOn.NutON(context);
		context.setTrangThai(trangThaiOn);
		System.out.println("Trang thai hien tai: " + context.layTenTrangThai());

	}
}
