package com.sv22T1020761.ordercomposite.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public void initializeDatabase() throws SQLException {
        createDatabaseIfNotExists();
        createTablesIfNotExists();
    }

    private void createDatabaseIfNotExists() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getMasterConnectionString(),
                DatabaseConfig.USERNAME,
                DatabaseConfig.PASSWORD
        );
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "IF DB_ID('" + DatabaseConfig.DATABASE + "') IS NULL CREATE DATABASE " + DatabaseConfig.DATABASE
            );
        }
    }

    private void createTablesIfNotExists() throws SQLException {
        String createComponents = """
                IF OBJECT_ID('dbo.order_components', 'U') IS NULL
                BEGIN
                    CREATE TABLE dbo.order_components (
                        id INT PRIMARY KEY,
                        name NVARCHAR(255) NOT NULL,
                        component_type VARCHAR(20) NOT NULL,
                        unit_price DECIMAL(18,2) NULL,
                        quantity INT NULL,
                        parent_id INT NULL,
                        CONSTRAINT fk_order_components_parent
                            FOREIGN KEY (parent_id) REFERENCES dbo.order_components(id)
                    )
                END
                """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getDatabaseConnectionString(),
                DatabaseConfig.USERNAME,
                DatabaseConfig.PASSWORD
        );
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createComponents);
        }
    }
}
