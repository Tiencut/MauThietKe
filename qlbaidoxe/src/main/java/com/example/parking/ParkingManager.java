package com.example.parking;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class ParkingManager {
    private DatabaseHelper dbHelper;

    public ParkingManager() throws SQLException {
        dbHelper = new DatabaseHelper();
    }

    public void processInput1(String filePath) throws IOException, SQLException {
        List<String[]> data = FileReaderUtil.readInput1(filePath);
        for (String[] row : data) {
            int type = Integer.parseInt(row[0]);
            String licensePlate = row[1].equals("Not Available") ? null : row[1];
            String ticketNumber = row[2].equals("Not Available") ? null : row[2];
            String timeIn = row[3];
            String conditionIn = row[4];

            Vehicle vehicle = null;
            if (type == 4 && licensePlate != null) {
                // Giả sử tạo vehicle với info cơ bản, sau này update khi ra
                vehicle = new Car(licensePlate, "123", "Name", "Gender", "Apt", "Manu", "Color");
                vehicle.recordEntry(timeIn, conditionIn);
            } else if (type == 2 && licensePlate != null) {
                vehicle = new Motorcycle(licensePlate, "123", "Name", "Gender", "Apt", "Manu", "Color");
                vehicle.recordEntry(timeIn, conditionIn);
            } else if (type == 0 && ticketNumber != null) {
                vehicle = new Bicycle(ticketNumber, "123", "Name", "Gender", "Apt", "Manu", "Color");
                vehicle.recordEntry(timeIn, conditionIn);
            }
            if (vehicle != null) {
                dbHelper.insertVehicle(vehicle);
            }
        }
    }

    public void processInput2(String filePath) throws IOException, SQLException {
        List<String[]> data = FileReaderUtil.readInput2(filePath);
        for (String[] row : data) {
            int type = Integer.parseInt(row[0]);
            String identifier = row[1]; // licensePlate or ticket
            String timeOut = row[3];
            String conditionOut = row[4];

            // Tìm vehicle trong DB và update
            // Giả sử update trực tiếp, nhưng để đơn giản, in ra
            System.out.println("Processing exit: " + identifier + " at " + timeOut);
        }
    }

    public void exportToFile(String filePath) throws SQLException, IOException {
        List<Vehicle> vehicles = dbHelper.getAllVehicles();
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Vehicle v : vehicles) {
                String type = v instanceof Car ? "4" : v instanceof Motorcycle ? "2" : "0";
                String fee = String.valueOf(v.calculateFee());
                pw.println(type + ";" + v.getLicensePlate() + ";" + v.getTicketNumber() + ";" + v.getEntryTime() + ";" + v.getExitTime() + ";" + fee);
            }
        }
    }

    public void close() throws SQLException {
        dbHelper.close();
    }
}