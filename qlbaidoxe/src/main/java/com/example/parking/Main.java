package com.example.parking;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ParkingManager manager = new ParkingManager();

            // Process input1.txt
            manager.processInput1("input1.txt");

            // Process input2.txt
            manager.processInput2("input2.txt");

            // Export to output.txt
            manager.exportToFile("output.txt");

            manager.close();
            System.out.println("Processing complete.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}