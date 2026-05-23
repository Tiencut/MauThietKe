# dp4-tiến-nguyễnHuỳnhMinhTiến

## Đề tài
Cài đặt chức năng đọc danh sách sinh viên ở CSDL bằng mẫu thiết kế Proxy.

## Package yêu cầu
Tất cả class và interface đều nằm trong package:

```java
vn.edu.husc.tien_nguyenhuynhminhtien
```

## Các thành phần chính

| Thành phần | Vai trò trong Proxy Pattern |
|---|---|
| `SinhVienServiceInterface` | Service Interface, khai báo hàm `getDanhSachSinhVien()` |
| `SinhVienServiceImpl` | Service thật, đọc danh sách sinh viên từ CSDL SQLite |
| `SinhVienServiceProxy` | Proxy, kiểm soát truy cập, lazy initialization và cache dữ liệu |
| `ClientDemo` | Client sử dụng service thông qua interface |
| `DatabaseInitializer` | Tạo bảng và thêm dữ liệu mẫu nếu CSDL chưa có dữ liệu |
| `DatabaseConnection` | Tạo kết nối đến SQLite |
| `SinhVien` | Model sinh viên |

## CSDL
Dự án dùng SQLite. Khi chạy chương trình lần đầu, file `sinhvien.db` sẽ được tạo tự động.

Bảng dữ liệu:

```sql
CREATE TABLE IF NOT EXISTS sinh_vien (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    ma_sinh_vien TEXT NOT NULL UNIQUE,
    ho_ten TEXT NOT NULL,
    lop TEXT NOT NULL,
    diem_trung_binh REAL NOT NULL
);
```

## Cách chạy
Yêu cầu máy đã cài Java 17+ và Maven.

```bash
mvn clean compile exec:java
```

## Ý nghĩa Proxy trong bài
Client không gọi trực tiếp `SinhVienServiceImpl`, mà gọi qua `SinhVienServiceProxy`.

Proxy thực hiện:

1. Nhận yêu cầu từ Client.
2. Khởi tạo service thật khi cần dùng lần đầu.
3. Gọi service thật để đọc dữ liệu từ CSDL.
4. Lưu cache danh sách sinh viên.
5. Những lần gọi sau trả dữ liệu từ cache, không truy vấn lại CSDL.
