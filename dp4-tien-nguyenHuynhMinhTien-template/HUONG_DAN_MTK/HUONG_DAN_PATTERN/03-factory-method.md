# 03 - Factory Method

## Khái niệm
Factory Method để subclass quyết định lớp sản phẩm cần tạo, không để lớp cha phải biết chi tiết từng class cụ thể.

## Khi nào dùng
- Muốn mở rộng loại sản phẩm mà không sửa factory cũ.
- Có nhiều nhà sản xuất khác nhau, mỗi nhà sản xuất tạo 1 loại sản phẩm riêng.

## Dấu hiệu nhận biết đề thi
- Đề có nói về nhà máy, quy trình sản xuất, từng loại sản phẩm do một lớp riêng tạo.
- Đề nhấn mạnh mở rộng bằng kế thừa.

## Vai trò class/interface
- `Product`: giao diện sản phẩm.
- `ConcreteProduct`: các sản phẩm cụ thể.
- `Creator`: lớp cha khai báo factory method.
- `ConcreteCreator`: lớp con override factory method.

## Thứ tự tạo file
1. Tạo giao diện sản phẩm.
2. Tạo sản phẩm cụ thể.
3. Tạo lớp cha có factory method.
4. Tạo lớp con override factory method.
5. Main gọi creator.

## Flow hoạt động
`Main -> Creator.anProduct() -> factoryMethod() -> ConcreteProduct`

## ASCII sơ đồ
```text
Creator
  |
  +--> factoryMethod()
          |
          +--> ConcreteProductA
          +--> ConcreteProductB
```

## Skeleton code
```java
interface Product {
    void execute();
}

class ConcreteProductA implements Product {
    public void execute() {
        System.out.println("Sản phẩm A");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();

    public void someOperation() {
        Product product = factoryMethod();
        product.execute();
    }
}

class CreatorA extends Creator {
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
```

## Ví dụ đề thi
- Các loại nhà cung cấp hóa đơn khác nhau.
- Hệ thống gửi file ra nhiều định dạng, mỗi định dạng có lớp tạo riêng.

## Checklist code nhanh lúc thi
- [ ] Có abstract creator
- [ ] Có factory method abstract/override
- [ ] Lớp con quyết định object
- [ ] Main dùng creator cụ thể
