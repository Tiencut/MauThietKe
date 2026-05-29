# dp4-tien-nguyenHuynhMinhTien

Bài thi mẫu thiết kế: quản lý mẫu xe, phụ kiện xe và các lượt cấu hình xe của khách hàng.

## Thông tin nộp bài

| Thành phần | Giá trị |
|---|---|
| Project | `dp4-tien-nguyenHuynhMinhTien` |
| Package root | `vn.edu.husc.dp4.nguyenHuynhMinhTien` |
| Database | `BaiThiDP_22T1020761` |
| Script SQL | `dbscript_22T1020761.sql` |
| Pattern sử dụng | Decorator Pattern |

## Cách chạy

1. Mở SQL Server Management Studio.
2. Chạy file `dbscript_22T1020761.sql`.
3. Mở project bằng Eclipse.
4. Thêm thư viện JDBC SQL Server vào Build Path:
   - `mssql-jdbc-*.jar`
5. Sửa tài khoản SQL Server tại:

```java
src/vn/edu/husc/dp4/nguyenHuynhMinhTien/util/DBConfig.java
```

6. Chạy file:

```java
src/vn/edu/husc/dp4/nguyenHuynhMinhTien/main/Main.java
```

## Chức năng

- Đọc danh sách tất cả mẫu xe.
- Đọc danh sách tất cả phụ kiện.
- Đọc danh sách các xe được khách hàng cấu hình/mua.
- Hiển thị:
  - Tên mẫu xe
  - Tên khách hàng
  - Tổng chi phí
  - Danh sách phụ kiện theo thứ tự áp dụng
