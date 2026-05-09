
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class SQLiteStrategy implements IDatabaseStrategy {

    private final String url =
            "jdbc:sqlite:students.db";

    @Override
    public String getName() {
        return "SQLite";
    }

    @Override
    public void insertStudents(List<SinhVien> students) throws Exception {

        Connection conn = DriverManager.getConnection(url);

        String sql = "INSERT INTO SinhVien VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        for (SinhVien sv : students) {

            ps.setInt(1, sv.ID);
            ps.setString(2, sv.HoDem);
            ps.setString(3, sv.Ten);
            ps.setString(4, sv.GioiTinh);

            ps.setDate(5,
                    new java.sql.Date(sv.NgaySinh.getTime()));

            ps.setDouble(6, sv.DTB);

            ps.executeUpdate();
        }

        conn.close();
    }
}
