# ĐỒ ÁN KẾT THÚC HỌC PHẦN: MẪU THIẾT KẾ (DESIGN PATTERNS)

* **Học phần:** Mẫu thiết kế (Mã HP: TIN4253)
* **Học kỳ:** II - Năm học: 2024-2025
* **Trường:** Đại học Khoa học - Khoa Công nghệ thông tin
* **Sinh viên thực hiện:** [Điền Họ và Tên của bạn]
* **Mã số sinh viên:** [Điền MSSV của bạn]
* **Lớp/Nhóm:** Nhóm [Điền Nhóm 1, 2, 3 hoặc 4]
* **Đề số:** I

---

## 📝 Tổng Quan Đề Tài

Hệ thống quản lý thông tin cấu hình xe và trang bị phụ kiện đi kèm cho khách hàng, áp dụng mẫu thiết kế cấu trúc **Decorator Pattern** để mở rộng tính năng (thêm phụ kiện) cho thực thể xe cơ bản một cách linh hoạt.

### Các thực thể chính trong hệ thống:
1.  **XeCoBan:** Lớp thành phần gốc (Component) chứa thông tin cốt lõi của xe.
2.  **PhuKienCuaXe:** Lớp Decorator kế thừa và bao bọc `XeCoBan`, bổ sung thuộc tính chi phí phụ kiện.
3.  **CauHinhXe:** Quản lý thông tin xe đã được cá nhân hóa của từng khách hàng kèm danh sách phụ kiện.

---

## 📁 Cấu Trúc Thư Mục Dự Án

```text
📂 BaiThiDP_[MaSinhVien]
 ├── 📂 database/
 │    └── dbscript_[masinhvien].sql    # Script tạo CSDL và chèn dữ liệu mẫu (MS SQL Server)
 ├── 📂 src/
 │    └── 📂 com/
 │         └── 📂 cardecorator/
 │              ├── 📂 config/          # Cấu hình kết nối Cơ sở dữ liệu (JDBC)
 │              ├── 📂 decorator/       # Chứa các Class áp dụng Decorator Pattern (XeCoBan, PhuKien,...)
 │              ├── 📂 model/           # Các lớp thực thể quản lý nghiệp vụ (CauHinhXe, KhachHang,...)
 │              ├── 📂 repository/      # Các lớp đảm nhiệm truy xuất dữ liệu từ SQL Server
 │              └── Main.java           # Chương trình chạy chính (Hiển thị Menu Console)
 ├── 📂 screenshots/                    # Thư mục chứa ảnh minh họa kết quả chạy ứng dụng trên IDE
 └── README.md                          # Tài liệu hướng dẫn này