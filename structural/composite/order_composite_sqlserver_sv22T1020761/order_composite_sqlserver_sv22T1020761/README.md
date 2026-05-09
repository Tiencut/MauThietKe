# Bài tập 2 - Quản lý đơn hàng bằng Composite + SQL Server

Project Java Maven sử dụng **Composite Pattern** để quản lý đơn hàng gồm:
- `Product` (lá)
- `Combo` (composite)

Dữ liệu được lưu trong **SQL Server** bằng **JDBC**.

## Cấu trúc chính

- `OrderComponent`: interface chung cho mọi thành phần đơn hàng
- `Product`: sản phẩm đơn lẻ, có tên, đơn giá, số lượng
- `Combo`: bộ sản phẩm, chứa nhiều `OrderComponent` con
- `DatabaseInitializer`: tạo database và bảng nếu chưa tồn tại
- `OrderRepository`: lưu cây đơn hàng vào DB và đọc lại theo ID
- `SampleDataFactory`: tạo dữ liệu mẫu đúng theo đề bài
- `Main`: chạy demo

## Yêu cầu môi trường

- Java 17+
- Maven 3.9+
- SQL Server đang chạy ở `localhost:1433`
- Tài khoản SQL Server:
  - username: `sa`
  - password: `sa`

## Database dùng trong project

Tên database được tạo tự động:

`OrderCompositeDB`

Bảng dữ liệu:

`dbo.order_components`

## Cách chạy

```bash
mvn compile
mvn exec:java
```

## Kết quả chính

Chương trình sẽ:
1. Tạo database nếu chưa có
2. Tạo bảng nếu chưa có
3. Xóa dữ liệu cũ
4. Sinh cây đơn hàng mẫu
5. Lưu toàn bộ cây vào SQL Server
6. In cây đơn hàng ra màn hình
7. Đọc lại đối tượng theo ID từ database
8. In lại cây đã đọc từ database
9. Tính tổng tiền của toàn bộ đơn hàng

## Ghi chú

- Root combo mẫu có ID = `105`
- Bạn có thể đổi dữ liệu mẫu trong `SampleDataFactory`
- Nếu SQL Server của bạn không dùng `sa/sa`, sửa trong `DatabaseConfig`
