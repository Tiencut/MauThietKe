# Tổng hợp tài liệu project CRUD Sinh viên

## 1. Mã nguồn các class, interface

### ChuongTrinh.java
```java
package _22T1020761;

import _22T1020761.dao.IDao;
import _22T1020761.entity.SinhVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Chuong trinh chinh thuc hien kich ban.
 */
public class ChuongTrinh {
    public static void main(String[] args) {
        try {
            // Doc cau hinh tu config.txt
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String type = br.readLine().trim();
            String source = br.readLine().trim();
            br.close();

            // Tao DAO bang Simple Factory
            IDao dao = SimpleFactory.createDao(type, source);

            // 1. Doc danh sach sinh vien
            System.out.println("Danh sach sinh vien:");
            List<SinhVien> list = dao.getAll();
            for (SinhVien sv : list) {
                System.out.println(sv);
            }

            // 2. Insert sinh vien moi
            SinhVien newSV = new SinhVien("SV099", "John Smith", true, LocalDate.of(2000, 11, 30));
            dao.insert(newSV);
            System.out.println("Da insert sinh vien: " + newSV);

            // 3. Delete sinh vien
            dao.delete("SV082");
            System.out.println("Da delete sinh vien: SV082");

            // Doc lai danh sach sau thay doi
            System.out.println("Danh sach sau thay doi:");
            list = dao.getAll();
            for (SinhVien sv : list) {
                System.out.println(sv);
            }

        } catch (IOException | SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
```

### DatabaseConnection.java
```java
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
```

### SimpleFactory.java
```java
package _22T1020761;

import _22T1020761.dao.IDao;
import _22T1020761.dao.TextFileDao;
import _22T1020761.dao.SqlServerDao;

import java.sql.SQLException;

/**
 * Simple Factory de tao DAO dua tren loai nguon du lieu.
 */
public class SimpleFactory {

    public static IDao createDao(String type, String source) throws SQLException {
        switch (type.toUpperCase()) {
            case "TEXT_FILE":
                return new TextFileDao(source);
            case "MS_SQLSERVER":
                return new SqlServerDao(source);
            default:
                throw new IllegalArgumentException("Loai nguon du lieu khong hop le: " + type);
        }
    }
}
```

### IDao.java
```java
package _22T1020761.dao;

import java.util.List;

import _22T1020761.entity.SinhVien;

/**
 * Interface cho Data Access Object của SinhVien.
 */
public interface IDao {
    List<SinhVien> getAll();
    void insert(SinhVien sv);
    void delete(String maSV);
}
```

### SqlServerDao.java
```java
package _22T1020761.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import _22T1020761.DatabaseConnection;
import _22T1020761.entity.SinhVien;

/**
 * DAO cho nguon du lieu SQL Server.
 */
public class SqlServerDao implements IDao {
    private DatabaseConnection dbConn;

    public SqlServerDao(String connectionString) throws SQLException {
        this.dbConn = DatabaseConnection.getInstance(connectionString);
    }

    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        String query = "SELECT MaSinhVien, HoTen, GioiTinhNam, NgaySinh FROM SinhVien";
        try (Statement stmt = dbConn.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String maSV = rs.getString("MaSinhVien");
                String hoTen = rs.getString("HoTen");
                boolean gioiTinhNam = rs.getBoolean("GioiTinhNam");
                LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
                list.add(new SinhVien(maSV, hoTen, gioiTinhNam, ngaySinh));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            SqlServerDao dao = new SqlServerDao("jdbc:sqlserver://localhost;databaseName=QLSV;user=sa;password=your_password");
            List<SinhVien> sinhViens = dao.getAll();
            for (SinhVien sv : sinhViens) {
                System.out.println(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(SinhVien sv) {
        String query = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(query)) {
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getHoTen());
            pstmt.setBoolean(3, sv.isGioiTinhNam());
            pstmt.setDate(4, Date.valueOf(sv.getNgaySinh()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSV) {
        String query = "DELETE FROM SinhVien WHERE MaSinhVien = ?";
        try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(query)) {
            pstmt.setString(1, maSV);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### TextFileDao.java
```java
package _22T1020761.dao;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import _22T1020761.entity.SinhVien;

/**
 * DAO cho nguon du lieu file van ban.
 */
public class TextFileDao implements IDao {
    private String filePath;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public TextFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String maSV = parts[0];
                    String hoTen = parts[1];
                    boolean gioiTinhNam = Boolean.parseBoolean(parts[2]);
                    LocalDate ngaySinh = LocalDate.parse(parts[3], FORMATTER);
                    list.add(new SinhVien(maSV, hoTen, gioiTinhNam, ngaySinh));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(SinhVien sv) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(sv.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSV) {
        List<SinhVien> list = getAll();
        list.removeIf(sv -> sv.getMaSV().equals(maSV));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (SinhVien sv : list) {
                bw.write(sv.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### SinhVien.java
```java
package _22T1020761.entity;

import java.time.LocalDate;

/**
 * Entity class cho SinhVien.
 */
public class SinhVien {
    private String maSV;
    private String hoTen;
    private boolean gioiTinhNam;
    private LocalDate ngaySinh;

    public SinhVien(String maSV, String hoTen, boolean gioiTinhNam, LocalDate ngaySinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinhNam = gioiTinhNam;
        this.ngaySinh = ngaySinh;
    }

    // Getters and setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public boolean isGioiTinhNam() { return gioiTinhNam; }
    public void setGioiTinhNam(boolean gioiTinhNam) { this.gioiTinhNam = gioiTinhNam; }

    public LocalDate getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(LocalDate ngaySinh) { this.ngaySinh = ngaySinh; }

    @Override
    public String toString() {
        return maSV + "," + hoTen + "," + gioiTinhNam + "," + ngaySinh;
    }
}
```

## 2. File tài nguyên

### config.txt
```
TEXT_FILE
sinhvien.txt
```

### sinhvien.txt
```
T012001,Nguyễn Thị Hoa,false,2001-10-30
T012005,Trần Văn Huy,true,2000-02-29
T102002,Lê Văn Nam,true,2001-09-02
```

## 3. Script cơ sở dữ liệu (lược đồ & dữ liệu)
```sql
CREATE DATABASE MTK_SinhVien;
GO;

-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
    MaSinhVien NVARCHAR(10) PRIMARY KEY,
    HoTen NVARCHAR(50) NOT NULL,
    GioiTinhNam BIT NOT NULL,
    NgaySinh DATE NOT NULL
);

-- Thêm dữ liệu mẫu
INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES
('T012001', N'Nguyễn Thị Hoa', 0, '2001-10-30'),
('T012005', N'Trần Văn Huy', 1, '2000-02-29'),
('T102002', N'Lê Văn Nam', 1, '2001-09-02'),
('SV082', N'Test Student', 1, '1999-05-15');
```

## 4. Hướng dẫn minh hoạ chạy chương trình
- Chạy `ChuongTrinh.java` trong Eclipse.
- Chụp ảnh cửa sổ Console sau khi chạy xong để minh hoạ kết quả.

---
Bạn chỉ cần copy các đoạn trên vào báo cáo hoặc tài liệu của mình. Nếu cần chi tiết code từng class, hãy yêu cầu thêm!