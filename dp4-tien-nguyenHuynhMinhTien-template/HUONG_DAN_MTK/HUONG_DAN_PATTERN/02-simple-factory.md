# 02 - Simple Factory

## Khái niệm
Simple Factory là cách tách logic tạo object vào 1 lớp factory, object được chọn bằng tham số đầu vào.

## Khi nào dùng
- Có nhiều loại object cùng chung giao diện.
- Muốn giảm `new` trực tiếp trong `Main`.

## Dấu hiệu nhận biết đề thi
- Đề cho 1 nhãn vào, trả về đúng loại đối tượng.
- Đề nói chọn loại theo mã, tên, kiểu sản phẩm.

## Vai trò class/interface
- `Product`: giao diện chung.
- `ConcreteProductA/B`: các lớp cụ thể.
- `Factory`: hàm tạo object theo điều kiện.

## Thứ tự tạo file
1. Tạo interface chung.
2. Tạo các class cụ thể.
3. Tạo lớp factory có hàm `create(...)`.
4. Gọi factory trong `Main`.

## Flow hoạt động
`Main -> Factory.create(type) -> Product cụ thể -> xử lý`

## ASCII sơ đồ
```text
Main
  |
  v
Factory.create(type)
  |
  +--> ProductA
  +--> ProductB
```

## Skeleton code
```java
interface Product {
    void execute();
}

class ProductA implements Product {
    public void execute() {
        System.out.println("A");
    }
}

class ProductB implements Product {
    public void execute() {
        System.out.println("B");
    }
}

class ProductFactory {
    public static Product create(String type) {
        if ("A".equalsIgnoreCase(type)) return new ProductA();
        if ("B".equalsIgnoreCase(type)) return new ProductB();
        throw new IllegalArgumentException("Loại không hợp lệ");
    }
}
```

## Ví dụ đề thi
- Chọn hình thức thanh toán.
- Chọn loại thông báo.

## Checklist code nhanh lúc thi
- [ ] Có interface chung
- [ ] Có class factory
- [ ] Có `switch/if` tạo object
- [ ] Main chỉ gọi factory
