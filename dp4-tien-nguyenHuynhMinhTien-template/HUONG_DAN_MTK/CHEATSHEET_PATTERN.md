# Cheat Sheet Pattern Mẫu Thiết Kế

## 1. Nhóm tạo đối tượng
- Singleton: 1 instance duy nhất.
- Simple Factory: 1 lớp tạo object theo tham số.
- Factory Method: subclass quyết định lớp cần tạo.
- Abstract Factory: tạo cả cụm sản phẩm liên quan.
- Prototype: copy đối tượng sẵn có.

## 2. Nhóm cấu trúc
- Adapter: chuyển giao diện cũ sang giao diện mới.
- Composite: cây đối tượng, node và leaf cùng kiểu.
- Decorator: bọc thêm tính năng động.
- Proxy: lớp gián tiếp trước đối tượng thật.
- Facade: lớp mặt tiền, gọi nhiều subsystem.
- Bridge: tách abstraction và implementation.

## 3. Nhóm hành vi
- Strategy: đổi thuật toán lúc runtime.
- State: đổi hành vi theo trạng thái.

## 4. Dấu hiệu đề thi
- Đề nói 1 đối tượng có nhiều biến thể -> Factory/Prototype/Bridge.
- Đề nói bọc thêm chức năng -> Decorator.
- Đề nói kiểm tra quyền, cache, lazy load -> Proxy.
- Đề nói đổi cách xử lý theo điều kiện -> Strategy.
- Đề nói đổi trạng thái dẫn đến hành vi khác -> State.
- Đề nói gom nhiều object thành cây -> Composite.
- Đề nói tách hệ thống phức tạp thành 1 cửa sổ dễ dùng -> Facade.

## 5. Công thức làm bài
1. Đọc đề và tìm từ khóa trong đề.
2. Chọn đúng package.
3. Tạo interface chung.
4. Tạo class cụ thể.
5. Nếu cần runtime thì có `Context` hoặc `Proxy/Decorator`.
6. Test bằng `Main` và in kết quả rõ ràng.

## 6. Câu lệnh nhớ nhanh
- `new`: tạo object.
- `setXxx(...)`: đổi chiến lược/trạng thái.
- `execute()/request()/operation()`: hàm xử lý chính.
