1. Tổng quan về Simple Factory Pattern
Mục đích: Simple Factory là một mẫu thiết kế sáng tạo (creational pattern) giúp tập trung logic tạo đối tượng vào một nơi duy nhất. Thay vì code client (người dùng) phải tự tạo đối tượng bằng new, bạn gọi một phương thức factory để tạo. Điều này làm code dễ bảo trì và mở rộng.
Ví dụ thực tế: Như một nhà máy sản xuất đồ chơi – bạn nói "tôi muốn ô tô" và nhà máy trả về ô tô, không cần biết cách làm.
Ưu điểm:
Giảm sự phụ thuộc giữa client và các lớp cụ thể.
Dễ thêm logic tạo đối tượng (như kiểm tra điều kiện).
Code client sạch hơn.
Nhược điểm:
Nếu thêm loại đối tượng mới, phải sửa code factory (vi phạm nguyên tắc Open/Closed).
Không phải là factory "đầy đủ" như Factory Method hay Abstract Factory.
2. Giải thích từng file code
a. Shape.java (Interface chung)
Giải thích:
Shape là một interface (giao diện) định nghĩa hành vi chung cho tất cả các hình dạng.
Phương thức draw() là abstract (trừu tượng), nghĩa là các lớp triển khai phải định nghĩa nó.
Tại sao dùng interface? Để đảm bảo tất cả "hình dạng" đều có thể "vẽ" được, nhưng cách vẽ khác nhau.
Ví dụ: Giống như một "động vật" có phương thức makeSound(), nhưng mèo kêu "meo" còn chó sủa "gâu".
b. Circle.java, Rectangle.java, Square.java (Các lớp cụ thể)
Giải thích:
Đây là các lớp cụ thể (concrete classes) triển khai Shape.
Mỗi lớp định nghĩa cách riêng của mình cho draw(): Circle in "Vẽ hình tròn", Rectangle in "Vẽ hình chữ nhật", v.v.
implements Shape: Nghĩa là lớp này "thừa kế" giao diện Shape và phải thực hiện tất cả phương thức của nó.
Tại sao cần? Mỗi loại hình có cách vẽ khác nhau, nhưng client chỉ cần gọi draw() mà không quan tâm chi tiết.
c. SimpleFactory.java (Lớp Factory chính)
Giải thích:
SimpleFactory là lớp chứa logic tạo đối tượng. Nó có phương thức static createShape(String shapeType).
Cách hoạt động:
Nhận tham số shapeType (chuỗi như "CIRCLE").
Dùng switch để kiểm tra và tạo đối tượng tương ứng: Nếu "CIRCLE" thì new Circle().
Nếu shapeType null, trả về null.
Nếu không hợp lệ, ném exception IllegalArgumentException (lỗi đối số không hợp lệ).
Tại sao static? Để gọi mà không cần tạo instance của factory (dễ dùng hơn).
Ví dụ: Như một máy bán hàng tự động – bạn đưa tiền và chọn "nước ngọt", máy trả về chai nước.
d. Main.java (Lớp demo)
Giải thích:
Đây là nơi demo cách dùng Simple Factory.
Bước 1: Gọi SimpleFactory.createShape("CIRCLE") để tạo Circle. Lưu ý: Biến circle có kiểu Shape (interface), nhưng thực tế là Circle.
Bước 2: Gọi draw() trên mỗi đối tượng – đa hình (polymorphism) sẽ gọi phương thức đúng (Circle.draw() in "Vẽ hình tròn").
Bước 3: Thử tạo "TRIANGLE" (không tồn tại) để demo xử lý lỗi – factory ném exception và in "Lỗi: Loại hình dạng không hợp lệ: TRIANGLE".
Output mong đợi khi chạy:
3. Cách chạy và học thêm
Chạy code: Từ thư mục simple-factory, gõ mvn exec:java. Nó sẽ compile và chạy Main.
Cách học sâu hơn:
Thử nghiệm: Thêm loại hình mới (vd: Triangle) – tạo lớp Triangle.java, rồi sửa switch trong SimpleFactory.
So sánh với Factory Method: Simple Factory dùng static method, còn Factory Method dùng subclass để tạo.
Áp dụng thực tế: Dùng cho tạo database connections, logger, hoặc UI components.
Nếu bạn muốn thêm tính năng (vd: thêm tham số cho draw như màu sắc), tôi có thể giúp sửa code!
Bạn hiểu chưa? Có phần nào cần giải thích thêm không? 😊### 3. Cách chạy và học thêm

Chạy code: Từ thư mục simple-factory, gõ mvn exec:java. Nó sẽ compile và chạy Main.
Cách học sâu hơn:
Thử nghiệm: Thêm loại hình mới (vd: Triangle) – tạo lớp Triangle.java, rồi sửa switch trong SimpleFactory.
So sánh với Factory Method: Simple Factory dùng static method, còn Factory Method dùng subclass để tạo.
Áp dụng thực tế: Dùng cho tạo database connections, logger, hoặc UI components.
Nếu bạn muốn thêm tính năng (vd: thêm tham số cho draw như màu sắc), tôi có thể giúp sửa code!
Bạn hiểu chưa? Có phần nào cần giải thích thêm không? 😊