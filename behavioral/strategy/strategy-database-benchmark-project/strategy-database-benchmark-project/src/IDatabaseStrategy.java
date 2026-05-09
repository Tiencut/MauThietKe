
import java.util.List;

public interface IDatabaseStrategy {
    void insertStudents(List<SinhVien> students) throws Exception;
    String getName();
}
