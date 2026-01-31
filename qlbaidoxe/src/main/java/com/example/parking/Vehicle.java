package com.example.parking;

// Abstract class Vehicle (Xe)
public abstract class Vehicle {
    protected String licensePlate; // Biển số xe
    protected String ticketNumber; // Số vé xe (cho xe đạp)
    protected String ownerId; // Số CMND chủ nhân
    protected String ownerName; // Họ tên
    protected String gender; // Giới tính
    protected String apartmentCode; // Mã số căn hộ
    protected String manufacturer; // Hãng sản xuất
    protected String color; // Màu sơn
    protected String entryTime; // Thời gian vào
    protected String exitTime; // Thời gian ra
    protected String conditionIn; // Tình trạng khi vào
    protected String conditionOut; // Tình trạng khi ra

    public Vehicle(String licensePlate, String ticketNumber, String ownerId, String ownerName, String gender, String apartmentCode, String manufacturer, String color) {
        this.licensePlate = licensePlate;
        this.ticketNumber = ticketNumber;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.gender = gender;
        this.apartmentCode = apartmentCode;
        this.manufacturer = manufacturer;
        this.color = color;
    }

    // Abstract method để ghi nhận thông tin khi vào bãi
    public abstract void recordEntry(String timeIn, String conditionIn);

    // Abstract method để ghi nhận thông tin khi ra bãi
    public abstract void recordExit(String timeOut, String conditionOut);

    // Abstract method để tính tiền
    public abstract double calculateFee();

    // Concrete method để hiển thị thông tin xe
    public void displayInfo() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Owner ID: " + ownerId);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Gender: " + gender);
        System.out.println("Apartment Code: " + apartmentCode);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Color: " + color);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("Exit Time: " + exitTime);
        System.out.println("Condition In: " + conditionIn);
        System.out.println("Condition Out: " + conditionOut);
    }

    // Getters
    public String getLicensePlate() { return licensePlate; }
    public String getTicketNumber() { return ticketNumber; }
    public String getEntryTime() { return entryTime; }
    public String getExitTime() { return exitTime; }
    public String getConditionIn() { return conditionIn; }
    public String getConditionOut() { return conditionOut; }
}