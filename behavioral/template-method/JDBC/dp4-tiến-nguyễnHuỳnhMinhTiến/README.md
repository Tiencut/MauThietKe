# Bài tập mẫu thiết kế Template Method

## Thông tin

- Tên dự án: `dp4-tiến-nguyễnHuỳnhMinhTiến`
- Package chính: `vn.edu.husc.tien_nguyenhuynhminhtien`
- Mẫu thiết kế: Template Method Pattern
- Nhóm mẫu: Behavioral Pattern
- Ngôn ngữ: Java

## Ý tưởng bài làm

Bài làm mô phỏng quy trình pha chế đồ uống trong quán.

Các loại đồ uống khác nhau như trà sữa, trà đào, cà phê nóng đều có chung một khung quy trình:

1. Chuẩn bị ly và dụng cụ pha chế
2. Pha nguyên liệu chính
3. Thêm thành phần phụ
4. Thêm đá nếu cần
5. Đóng gói và phục vụ

Tuy nhiên, từng loại đồ uống sẽ khác nhau ở bước pha nguyên liệu chính và thêm thành phần phụ. Vì vậy, ta dùng Template Method để cố định khung quy trình chung trong lớp cha, còn lớp con chỉ cài đặt các bước thay đổi.

## Cấu trúc thư mục

```text
dp4-tiến-nguyễnHuỳnhMinhTiến/
├── README.md
└── src/
    └── vn/
        └── edu/
            └── husc/
                └── tien_nguyenhuynhminhtien/
                    ├── Main.java
                    ├── normal/
                    │   ├── DemoNormal.java
                    │   ├── TraDaoThuong.java
                    │   └── TraSuaThuong.java
                    └── templatemethod/
                        ├── DemoTemplateMethod.java
                        ├── base/
                        │   └── DoUongTemplate.java
                        └── concrete/
                            ├── CaPheNong.java
                            ├── TraDao.java
                            └── TraSuaTranChau.java
```

## Các lớp chính

| Lớp | Vai trò |
|---|---|
| `DoUongTemplate` | Abstract class, chứa template method `phaChe()` |
| `TraSuaTranChau` | Concrete class, cài đặt cách pha trà sữa trân châu |
| `TraDao` | Concrete class, cài đặt cách pha trà đào |
| `CaPheNong` | Concrete class, cài đặt cách pha cà phê nóng và ghi đè hook không thêm đá |
| `DemoNormal` | Demo cách làm thông thường, có lặp code |
| `DemoTemplateMethod` | Demo cách làm bằng Template Method |
| `Main` | Chạy cả hai phần để so sánh |

## Template Method trong bài

Trong lớp `DoUongTemplate`, phương thức `phaChe()` là Template Method:

```java
public final void phaChe() {
    chuanBiDungCu();
    phaNguyenLieuChinh();
    themThanhPhanPhu();
    if (coCanThemDa()) {
        themDa();
    }
    dongGoiVaPhucVu();
}
```

Phương thức này được đặt `final` để lớp con không được thay đổi thứ tự quy trình.

## Cách chạy

Mở terminal tại thư mục dự án và chạy:

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out vn.edu.husc.tien_nguyenhuynhminhtien.Main
```

Nếu dùng Windows CMD, có thể biên dịch theo cách thủ công hoặc mở project bằng IDE như IntelliJ IDEA, Eclipse, NetBeans.

## Kết luận

Template Method giúp:

- Cố định khung thuật toán chung.
- Cho phép lớp con thay đổi từng bước cụ thể.
- Giảm trùng lặp code giữa các lớp có quy trình giống nhau.
- Dễ mở rộng thêm loại đồ uống mới mà không sửa quy trình chung.
