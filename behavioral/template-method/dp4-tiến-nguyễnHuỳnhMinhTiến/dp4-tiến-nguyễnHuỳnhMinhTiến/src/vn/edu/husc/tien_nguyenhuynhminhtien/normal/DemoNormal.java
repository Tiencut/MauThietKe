package vn.edu.husc.tien_nguyenhuynhminhtien.normal;

public class DemoNormal {
    public static void main(String[] args) {
        TraSuaThuong traSua = new TraSuaThuong();
        TraDaoThuong traDao = new TraDaoThuong();

        traSua.phaChe();
        System.out.println();
        traDao.phaChe();
    }
}
