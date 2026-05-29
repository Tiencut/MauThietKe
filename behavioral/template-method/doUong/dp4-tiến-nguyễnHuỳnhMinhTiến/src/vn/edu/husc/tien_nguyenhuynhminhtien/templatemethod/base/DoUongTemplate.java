package vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.base;

public abstract class DoUongTemplate {

    // Template Method: quy dinh khung thuat toan pha che.
    // Dat final de lop con khong duoc thay doi thu tu cac buoc.
    public final void phaChe() {
        chuanBiDungCu();
        phaNguyenLieuChinh();
        themThanhPhanPhu();
        if (coCanThemDa()) {
            themDa();
        }
        dongGoiVaPhucVu();
    }

    // Buoc chung, cac lop con dung lai.
    private void chuanBiDungCu() {
        System.out.println("1. Chuan bi ly va dung cu pha che");
    }

    // Buoc rieng, bat buoc lop con cai dat.
    protected abstract void phaNguyenLieuChinh();

    // Buoc rieng, bat buoc lop con cai dat.
    protected abstract void themThanhPhanPhu();

    // Hook method: lop con co the ghi de neu muon thay doi hanh vi.
    protected boolean coCanThemDa() {
        return true;
    }

    // Buoc mac dinh, lop con co the dung lai.
    protected void themDa() {
        System.out.println("4. Them da vien");
    }

    // Buoc chung, cac lop con dung lai.
    private void dongGoiVaPhucVu() {
        System.out.println("5. Dong nap va giao cho khach");
    }
}
