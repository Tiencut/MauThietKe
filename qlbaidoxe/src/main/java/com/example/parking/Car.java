package com.example.parking;

// Class Car kế thừa từ Vehicle (xe 4 bánh)
public class Car extends Vehicle {
    public Car(String licensePlate, String ownerId, String ownerName, String gender, String apartmentCode, String manufacturer, String color) {
        super(licensePlate, "Not Available", ownerId, ownerName, gender, apartmentCode, manufacturer, color);
    }

    // Override abstract method recordEntry
    @Override
    public void recordEntry(String timeIn, String conditionIn) {
        this.entryTime = timeIn;
        this.conditionIn = conditionIn;
    }

    // Override abstract method recordExit
    @Override
    public void recordExit(String timeOut, String conditionOut) {
        this.exitTime = timeOut;
        this.conditionOut = conditionOut;
    }

    // Override calculateFee: 5000 đồng / 0.5 giờ, làm tròn
    @Override
    public double calculateFee() {
        if ("Chua xac dinh - Dang xu ly boi thuong".equals(conditionOut)) {
            return 0; // Hoặc giá trị đặc biệt
        }
        // Tính thời gian (giả sử format đơn giản)
        // Ở đây giả sử tính số giờ, cần parse time
        // Để đơn giản, giả sử entryTime và exitTime là số giờ
        double hours = Double.parseDouble(exitTime) - Double.parseDouble(entryTime);
        double halfHours = Math.ceil(hours / 0.5);
        return halfHours * 5000;
    }
}