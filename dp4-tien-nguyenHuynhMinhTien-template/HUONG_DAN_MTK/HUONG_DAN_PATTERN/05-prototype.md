# 05 - Prototype

## Khái niệm
Prototype tạo object mới bằng cách sao chép từ object mẫu sẵn có.

## Khi nào dùng
- Tạo object tốn kém chi phí khởi tạo.
- Có object có cấu hình trùng lặp, chỉ cần clone và sửa nhẹ.

## Dấu hiệu nhận biết đề thi
- Đề nói copy đối tượng thay vì tạo mới từ đầu.
- Đề có lập đối tượng mẫu, bản sao, nhân bản.

## Vai trò class/interface
- `Prototype`: khai báo `clone()`.
- `ConcretePrototype`: lớp cụ thể có thể sao chép.
- Client gọi `clone()` để lấy object mới.

## Thứ tự tạo file
1. Tạo interface có `clone()`.
2. Tạo class implement `Cloneable` hoặc tự xử lý bản sao.
3. Cài đặt copy constructor hoặc `clone()`.
4. Dùng trong `Main`.

## Flow hoạt động
`Main -> có prototype mẫu -> clone() -> sửa thông số -> dùng`

## ASCII sơ đồ
```text
Prototype gốc
    |
    +--> clone() -> Bản sao 1
    |
    +--> clone() -> Bản sao 2
```

## Skeleton code
```java
class Document implements Cloneable {
    private String title;

    public Document(String title) {
        this.title = title;
    }

    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## Ví dụ đề thi
- Tạo mẫu đơn hàng, mẫu biên bản, mẫu cấu hình.
- Sao chép đối tượng để tiết kiệm thời gian khởi tạo.

## Checklist code nhanh lúc thi
- [ ] Có object mẫu
- [ ] Có `clone()` hoặc copy constructor
- [ ] Sửa bản sao sau khi clone
