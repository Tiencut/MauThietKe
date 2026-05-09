
# Java Benchmark Database Insert - Strategy Pattern

Bài này sử dụng Strategy Pattern để benchmark tốc độ insert 1000 sinh viên vào:
- MySQL
- SQL Server
- SQLite

## Thêm thư viện JDBC

### MySQL
mysql-connector-j

### SQL Server
mssql-jdbc

### SQLite
sqlite-jdbc

## Tạo bảng SinhVien

```sql
CREATE TABLE SinhVien (
    ID INT PRIMARY KEY,
    HoDem VARCHAR(100),
    Ten VARCHAR(50),
    GioiTinh VARCHAR(10),
    NgaySinh DATE,
    DTB FLOAT
);
```
