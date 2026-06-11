Mục đích
-----
Tập tin này mô tả phân loại các file trong thư mục `factoryMethoc` và thứ tự nên tạo/biên dịch để chạy ví dụ "Simple Factory".

Danh sách file và phân loại
---------------------------
- `entity/Shape.java` : Interface/abstract (định nghĩa hành vi chung của các hình).
- `entity/Circle.java` : Lớp cụ thể (Shape) — hình tròn.
- `entity/Rectangle.java` : Lớp cụ thể (Shape) — hình chữ nhật.
- `entity/Square.java` : Lớp cụ thể (Shape) — hình vuông.
- `factory/SimpleFactory.java` : Lớp factory (tạo đối tượng `Shape` dựa trên tham số).
- `Main.java` : Lớp chạy demo (sử dụng `SimpleFactory` để tạo và in thông tin).

Thứ tự tạo / viết file (khuyến nghị)
-----------------------------------
1. `entity/Shape.java` — viết interface/abstract đầu tiên vì các lớp khác phụ thuộc vào nó.
2. `entity/Circle.java`, `entity/Rectangle.java`, `entity/Square.java` — các lớp con triển khai `Shape`.
3. `factory/SimpleFactory.java` — sử dụng các lớp `entity` để trả về instance tương ứng.
4. `Main.java` — chương trình chính, dùng `factory.SimpleFactory` để thử nghiệm.

Ghi chú thêm
-----------
- Nếu thêm lớp mới (ví dụ `Triangle`), hãy tạo lớp đó sau `Shape` và trước `SimpleFactory` (nếu factory cần hỗ trợ nó).
- README này chỉ hướng dẫn thứ tự phát triển/biên dịch trong folder `factoryMethoc`.

Giải thích dự án & Factory pattern
---------------------------------
Mục tiêu: Đây là ví dụ nhỏ minh hoạ "Simple Factory" — tách việc tạo đối tượng ra khỏi phần sử dụng chúng.

- Các thành phần chính:
	- `entity/Shape` : giao diện chung (hàm `draw()`).
	- `entity/*` : các lớp cụ thể (`Circle`, `Rectangle`, `Square`) cài đặt `Shape`.
	- `factory/SimpleFactory` : lớp tạo (factory) trả về `Shape` phù hợp theo tham số.
	- `Main` : client, chỉ biết `Shape` (không cần biết lớp cụ thể).

- Dòng chảy (ví dụ):
	1. Client gọi `SimpleFactory.createShape("CIRCLE")`.
	2. `SimpleFactory` trả về `new Circle()` (kiểu `Shape`).
	3. Client gọi `shape.draw()` mà không quan tâm đó là `Circle` hay `Square`.

- Lợi ích:
	- Giảm phụ thuộc giữa client và lớp cụ thể.
	- Dễ mở rộng, dễ bảo trì (thêm sản phẩm mới ít ảnh hưởng client).
	- Tăng khả năng tái sử dụng mã.

- Khi không dùng Simple Factory:
	- Nếu cần mở rộng linh hoạt mà không sửa factory, cân nhắc `Factory Method` hoặc `Abstract Factory`.

Ví dụ ngắn (cách dùng):

```java
Shape s = SimpleFactory.createShape("CIRCLE");
s.draw();
```

Gợi ý bài tập tự thực hành:
- Thêm `Triangle` vào `entity` và cập nhật `factory`.
- Thử chuyển factory sang một registry-based factory (đăng ký lớp theo key) để tránh sửa mã khi mở rộng.

