package prototype;

public class SinhVienNuocNgoai extends SinhVien {
    private String quocGia;

    public SinhVienNuocNgoai() {}

    public SinhVienNuocNgoai(String maSinhVien, String hoTen, String quocGia) {
        super(maSinhVien, hoTen);
        this.quocGia = quocGia;
    }

    // Copy constructor
    public SinhVienNuocNgoai(SinhVienNuocNgoai x) {
        super(x);
        this.quocGia = x.quocGia;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public SinhVien taoBanSao() {
        return new SinhVienNuocNgoai(this);
    }

    @Override
    public String toString() {
        return "Sinh viên NUOC NGOAI " + this.getHoTen() + " có quốc tịch = " + this.getQuocGia();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new SinhVienNuocNgoai(this);
    }
}
