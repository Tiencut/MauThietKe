package prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Khởi tạo danh sách
		List<SinhVien> lst1 = new ArrayList<>();

		lst1.add(new SinhVien("sv1", "Nguyễn Văn Trung"));
		lst1.add(new SinhVienNuocNgoai("sv2", "Trần Văn", "Lào"));
		lst1.add(new SinhVienNuocNgoai("sv3", "Lê Thị Hoa", "Anh"));
		lst1.add(new SinhVien("sv100", "John Smith"));

		System.out.println("DANH SÁCH GỐC");
		for (SinhVien sv : lst1) {
			System.out.println(sv.toString());
		}

		// Tạo bản sao
		System.out.println("\nTẠO BẢN SAO KIỂU PROTOTYPE");
		List<SinhVien> lst2 = new ArrayList<>();
		for (SinhVien sv : lst1) {
			SinhVien svCopy = sv.taoBanSao();
			lst2.add(svCopy);
		}

		for (SinhVien sv : lst2) {
			System.out.println(sv.toString());
		}
	}
}