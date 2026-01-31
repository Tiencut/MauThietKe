package com.example.parking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:h2:~/parking";
    private static final String USER = "sa";
    private static final String PASS = "";

    private Connection connection;

    public DatabaseHelper() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        createTables();
    }

    private void createTables() throws SQLException {
        String createVehicleTable = "CREATE TABLE IF NOT EXISTS vehicles (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "type INT," +
            "license_plate VARCHAR(255)," +
            "ticket_number VARCHAR(255)," +
            "owner_id VARCHAR(255)," +
            "owner_name VARCHAR(255)," +
            "gender VARCHAR(10)," +
            "apartment_code VARCHAR(255)," +
            "manufacturer VARCHAR(255)," +
            "color VARCHAR(255)," +
            "entry_time VARCHAR(255)," +
            "exit_time VARCHAR(255)," +
            "condition_in VARCHAR(255)," +
            "condition_out VARCHAR(255)," +
            "fee DOUBLE" +
            ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createVehicleTable);
        }
    }

    public void insertVehicle(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO vehicles (type, license_plate, ticket_number, owner_id, owner_name, gender, apartment_code, manufacturer, color, entry_time, exit_time, condition_in, condition_out, fee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            int type = 0;
            if (vehicle instanceof Car) type = 4;
            else if (vehicle instanceof Motorcycle) type = 2;
            else if (vehicle instanceof Bicycle) type = 0;

            pstmt.setInt(1, type);
            pstmt.setString(2, vehicle.getLicensePlate());
            pstmt.setString(3, vehicle.getTicketNumber());
            pstmt.setString(4, vehicle.ownerId);
            pstmt.setString(5, vehicle.ownerName);
            pstmt.setString(6, vehicle.gender);
            pstmt.setString(7, vehicle.apartmentCode);
            pstmt.setString(8, vehicle.manufacturer);
            pstmt.setString(9, vehicle.color);
            pstmt.setString(10, vehicle.getEntryTime());
            pstmt.setString(11, vehicle.getExitTime());
            pstmt.setString(12, vehicle.getConditionIn());
            pstmt.setString(13, vehicle.getConditionOut());
            pstmt.setDouble(14, vehicle.calculateFee());
            pstmt.executeUpdate();
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int type = rs.getInt("type");
                Vehicle vehicle = null;
                if (type == 4) {
                    vehicle = new Car(rs.getString("license_plate"), rs.getString("owner_id"), rs.getString("owner_name"), rs.getString("gender"), rs.getString("apartment_code"), rs.getString("manufacturer"), rs.getString("color"));
                } else if (type == 2) {
                    vehicle = new Motorcycle(rs.getString("license_plate"), rs.getString("owner_id"), rs.getString("owner_name"), rs.getString("gender"), rs.getString("apartment_code"), rs.getString("manufacturer"), rs.getString("color"));
                } else if (type == 0) {
                    vehicle = new Bicycle(rs.getString("ticket_number"), rs.getString("owner_id"), rs.getString("owner_name"), rs.getString("gender"), rs.getString("apartment_code"), rs.getString("manufacturer"), rs.getString("color"));
                }
                if (vehicle != null) {
                    vehicle.entryTime = rs.getString("entry_time");
                    vehicle.exitTime = rs.getString("exit_time");
                    vehicle.conditionIn = rs.getString("condition_in");
                    vehicle.conditionOut = rs.getString("condition_out");
                    vehicles.add(vehicle);
                }
            }
        }
        return vehicles;
    }

    public void close() throws SQLException {
        if (connection != null) connection.close();
    }
}