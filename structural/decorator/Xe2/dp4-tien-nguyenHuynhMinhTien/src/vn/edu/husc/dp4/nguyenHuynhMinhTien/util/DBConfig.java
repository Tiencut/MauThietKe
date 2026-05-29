package vn.edu.husc.dp4.nguyenHuynhMinhTien.util;

public class DBConfig {
    public static final String SERVER = "localhost";
    public static final String DATABASE = "BaiThiDP_22T1020761";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456";

    public static String getConnectionUrl() {
        return "jdbc:sqlserver://" + SERVER + ":1433;"
                + "databaseName=" + DATABASE + ";"
                + "encrypt=true;"
                + "trustServerCertificate=true;";
    }
}
