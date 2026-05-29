package vn.edu.husc.tien_nguyenhuynhminhtien.util;

public class DBConfig {
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "sa";
	
	public static String getConnectionUrl() {
		return 	"jdbc:sqlserver://localhost:1433;databaseName=BaiThiDP_22T1020761;encrypt=true;trustServerCertificate=true;";
	}
	
}
