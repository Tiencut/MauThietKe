
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        List<SinhVien> students = generateStudents(1000);

        List<IDatabaseStrategy> strategies = new ArrayList<>();

        strategies.add(new MySQLStrategy());
        strategies.add(new SQLServerStrategy());
        strategies.add(new SQLiteStrategy());

        for (IDatabaseStrategy strategy : strategies) {

            long start = System.currentTimeMillis();

            strategy.insertStudents(students);

            long end = System.currentTimeMillis();

            System.out.println(strategy.getName()
                    + ": "
                    + (end - start)
                    + " ms");
        }
    }

    public static List<SinhVien> generateStudents(int count) {

        Random rnd = new Random();

        String[] ho = {"Nguyen", "Tran", "Le", "Pham"};
        String[] ten = {"An", "Binh", "Cuong", "Dung"};
        String[] gt = {"Nam", "Nu"};

        List<SinhVien> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            SinhVien sv = new SinhVien(
                    i,
                    ho[rnd.nextInt(ho.length)],
                    ten[rnd.nextInt(ten.length)],
                    gt[rnd.nextInt(gt.length)],
                    new Date(),
                    Math.round(rnd.nextDouble() * 10 * 100.0) / 100.0
            );

            list.add(sv);
        }

        return list;
    }
}
