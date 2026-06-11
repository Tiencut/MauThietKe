package prototype;

@lombok.AllArgsConstructor 
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SinhVienNuocNgoai extends SinhVien {
	private String quocGia;

	public SinhVienNuocNgoai(SinhVienNuocNgoai x) {
		super(x);
		this.quocGia = x.quocGia;
	}

	// Chú ý, phải thêm hàm này
	// Do Lombok không gen được hàm dựng theo @AllArgConstructor
	public SinhVienNuocNgoai(String maSinhVien, String hoTen, String quocGia) {
		super(maSinhVien, hoTen);
		this.setQuocGia(quocGia);
	}

	@Override
	public SinhVien taoBanSao() {
		return new SinhVienNuocNgoai(this);
	}

	@Override
	public String toString() {
		return "Sinh viên NUOC NGOAI " + this.getHoTen() + " có quốc tịch = " + this.getQuocGia();
	}
}