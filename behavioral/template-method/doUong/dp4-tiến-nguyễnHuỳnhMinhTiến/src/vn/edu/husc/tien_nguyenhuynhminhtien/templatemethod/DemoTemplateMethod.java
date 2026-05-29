package vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod;

import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.base.DoUongTemplate;
import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.concrete.CaPheNong;
import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.concrete.TraDao;
import vn.edu.husc.tien_nguyenhuynhminhtien.templatemethod.concrete.TraSuaTranChau;

public class DemoTemplateMethod {
    public static void main(String[] args) {
        DoUongTemplate traSua = new TraSuaTranChau();
        DoUongTemplate traDao = new TraDao();
        DoUongTemplate caPheNong = new CaPheNong();

        System.out.println("=== Pha tra sua tran chau ===");
        traSua.phaChe();

        System.out.println("\n=== Pha tra dao ===");
        traDao.phaChe();

        System.out.println("\n=== Pha ca phe nong ===");
        caPheNong.phaChe();
    }
}
