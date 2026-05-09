
import java.util.Date;

public class SinhVien {
    public int ID;
    public String HoDem;
    public String Ten;
    public String GioiTinh;
    public Date NgaySinh;
    public double DTB;

    public SinhVien(int ID, String hoDem, String ten,
                     String gioiTinh, Date ngaySinh, double DTB) {
        this.ID = ID;
        this.HoDem = hoDem;
        this.Ten = ten;
        this.GioiTinh = gioiTinh;
        this.NgaySinh = ngaySinh;
        this.DTB = DTB;
    }
}
