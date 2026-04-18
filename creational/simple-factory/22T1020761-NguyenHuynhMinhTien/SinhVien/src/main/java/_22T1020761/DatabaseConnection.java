package _22T1020761;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class cho ket noi co so du lieu.
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(String connectionString) throws SQLException {
        this.connection = DriverManager.getConnection(connectionString);
    }

    public static DatabaseConnection getInstance(String connectionString) throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection(connectionString);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}