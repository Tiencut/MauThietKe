package com.sv22T1020761.ordercomposite.db;

public final class DatabaseConfig {
    public static final String SERVER = "localhost";
    public static final String PORT = "1433";
    public static final String DATABASE = "OrderCompositeDB";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "sa";

    private DatabaseConfig() {
    }

    public static String getMasterConnectionString() {
        return String.format(
                "jdbc:sqlserver://%s:%s;databaseName=master;encrypt=true;trustServerCertificate=true",
                SERVER, PORT
        );
    }

    public static String getDatabaseConnectionString() {
        return String.format(
                "jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=true;trustServerCertificate=true",
                SERVER, PORT, DATABASE
        );
    }
}
