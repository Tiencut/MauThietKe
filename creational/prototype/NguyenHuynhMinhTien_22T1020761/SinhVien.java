package prototype;

@lombok.AllArgsConstructor 
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SinhVien {
	private String maSinhVien;
	private String hoTen;

	// Hàm dựng kiểu sao chép
	public SinhVien(SinhVien x) {
		this.maSinhVien = x.maSinhVien;
		this.hoTen = x.hoTen;
	}

	public SinhVien taoBanSao() {
		return new SinhVien(this);
	}

	@Override
	public String toString() {
		return "Sinh viên " + this.getHoTen();
	}
}