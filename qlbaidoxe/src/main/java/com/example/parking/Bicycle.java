package com.example.parking;

// Class Bicycle kế thừa từ Vehicle (xe đạp)
public class Bicycle extends Vehicle {
    public Bicycle(String ticketNumber, String ownerId, String ownerName, String gender, String apartmentCode, String manufacturer, String color) {
        super("Not Available", ticketNumber, ownerId, ownerName, gender, apartmentCode, manufacturer, color);
    }

    // Override abstract method recordEntry
    @Override
    public void recordEntry(String timeIn, String conditionIn) {
        this.entryTime = timeIn;
        this.conditionIn = "Not Available"; // Xe đạp không ghi nhận condition
    }

    // Override abstract method recordExit
    @Override
    public void recordExit(String timeOut, String conditionOut) {
        this.exitTime = timeOut;
        this.conditionOut = "Not Available";
    }

    // Override calculateFee: 1000 đồng / ngày, làm tròn
    @Override
    public double calculateFee() {
        // Giả sử tính số ngày
        double days = Double.parseDouble(exitTime) - Double.parseDouble(entryTime);
        double roundedDays = Math.ceil(days);
        return roundedDays * 1000;
    }
}