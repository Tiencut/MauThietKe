package com.NguyenHuynhMinhTien.normal;

public class TV {
    public static final int TRANG_THAI_OFF = 0;
    public static final int TRANG_THAI_ON = 1;
    public static final int TRANG_THAI_MUTE = 2;

    private int trangThaiHienTai;

    public TV() {
        this.trangThaiHienTai = TRANG_THAI_OFF;
    }

    public TV(int trangThai) {
        this.trangThaiHienTai = trangThai;
    }

    public int getTrangThai() {
        return trangThaiHienTai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThaiHienTai = trangThai;
    }

    public void bamNutON() {
        switch (trangThaiHienTai) {
            case TRANG_THAI_OFF:
                System.out.println("Dang OFF. Bam ON chuyen TV sang trang thai ON.");
                trangThaiHienTai = TRANG_THAI_ON;
                break;
            case TRANG_THAI_ON:
                System.out.println("Dang ON. Bam ON tiep khong co tac dung.");
                break;
            case TRANG_THAI_MUTE:
                System.out.println("Dang MUTE. Bam ON khong co tac dung vi TV van dang bat.");
                break;
            default:
                System.out.println("Trang thai khong hop le.");
        }
    }

    public void bamNutOFF() {
        switch (trangThaiHienTai) {
            case TRANG_THAI_OFF:
                System.out.println("Dang OFF. Bam OFF tiep khong co tac dung.");
                break;
            case TRANG_THAI_ON:
                System.out.println("Dang ON. Bam OFF de tat TV.");
                trangThaiHienTai = TRANG_THAI_OFF;
                break;
            case TRANG_THAI_MUTE:
                System.out.println("Dang MUTE. Bam OFF de tat TV.");
                trangThaiHienTai = TRANG_THAI_OFF;
                break;
            default:
                System.out.println("Trang thai khong hop le.");
        }
    }

    public void bamNutMUTE() {
        switch (trangThaiHienTai) {
            case TRANG_THAI_OFF:
                System.out.println("Dang OFF. Bam MUTE khong co tac dung.");
                break;
            case TRANG_THAI_ON:
                System.out.println("Dang ON. Bam MUTE de chuyen sang trang thai MUTE.");
                trangThaiHienTai = TRANG_THAI_MUTE;
                break;
            case TRANG_THAI_MUTE:
                System.out.println("Dang MUTE. Bam MUTE lan nua de tro ve ON.");
                trangThaiHienTai = TRANG_THAI_ON;
                break;
            default:
                System.out.println("Trang thai khong hop le.");
        }
    }

    public String layTenTrangThai() {
        switch (trangThaiHienTai) {
            case TRANG_THAI_OFF:
                return "OFF";
            case TRANG_THAI_ON:
                return "ON";
            case TRANG_THAI_MUTE:
                return "MUTE";
            default:
                return "UNKNOWN";
        }
    }
}
