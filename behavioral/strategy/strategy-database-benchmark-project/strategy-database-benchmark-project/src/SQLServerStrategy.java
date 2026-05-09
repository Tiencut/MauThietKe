
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class SQLServerStrategy implements IDatabaseStrategy {

    private final String url =
            "jdbc:sqlserver://localhost:1433;" +
            "databaseName=BenchmarkDB;" +
            "encrypt=true;" +
            "trustServerCertificate=true";

    @Override
    public String getName() {
        return "SQL Server";
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
