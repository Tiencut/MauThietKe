# Prototype Pattern - SinhVien Example

## Cấu trúc thư mục

- src/main/java/prototype/SinhVien.java
- src/main/java/prototype/SinhVienNuocNgoai.java
- src/main/java/prototype/Main.java
- pom.xml

## Hướng dẫn chạy

1. Biên dịch dự án:
   ```sh
   mvn compile
   ```
2. Chạy chương trình:
   ```sh
   mvn exec:java -Dexec.mainClass="prototype.Main"
   ```

## Mô tả

- `SinhVien` và `SinhVienNuocNgoai` đều hỗ trợ copy constructor, hàm `taoBanSao()` và override `clone()`.
- `Main.java` minh họa các cách sao chép danh sách đối tượng theo yêu cầu README.
