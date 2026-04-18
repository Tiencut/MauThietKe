package _22T1020761;

import _22T1020761.dao.IDao;
import _22T1020761.dao.TextFileDao;
import _22T1020761.dao.SqlServerDao;

import java.sql.SQLException;

/**
 * Simple Factory de tao DAO dua tren loai nguon du lieu.
 */
public class SimpleFactory {

    public static IDao createDao(String type, String source) throws SQLException {
        switch (type.toUpperCase()) {
            case "TEXT_FILE":
                return new TextFileDao(source);
            case "MS_SQLSERVER":
                return new SqlServerDao(source);
            default:
                throw new IllegalArgumentException("Loai nguon du lieu khong hop le: " + type);
        }
    }
}