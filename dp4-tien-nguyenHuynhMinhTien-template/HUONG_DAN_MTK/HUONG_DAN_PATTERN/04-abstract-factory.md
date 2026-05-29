# 04 - Abstract Factory

## Khái niệm
Abstract Factory tạo ra một cụm object có liên quan với nhau mà không cần nói rõ lớp cụ thể.

## Khi nào dùng
- Cần tạo nhiều sản phẩm có liên kết theo từng bộ.
- Muốn hoàn toàn độc lập với platform, theme, style, version.

## Dấu hiệu nhận biết đề thi
- Đề cho 2 hay nhiều loại sản phẩm đi cùng nhau.
- Đề nhấn mạnh bộ sản phẩm đồng bộ.

## Vai trò class/interface
- `AbstractFactory`: khai báo các hàm tạo sản phẩm.
- `ConcreteFactory`: tạo bộ sản phẩm cụ thể.
- `AbstractProductA/B`: giao diện sản phẩm.
- `ConcreteProductA1/A2, B1/B2`: sản phẩm cụ thể.

## Thứ tự tạo file
1. Tạo interface sản phẩm.
2. Tạo sản phẩm cụ thể.
3. Tạo abstract factory.
4. Tạo concrete factory.
5. Gọi trong `Main`.

## Flow hoạt động
`Main -> ConcreteFactory -> tạo ProductA + ProductB cùng bộ -> sử dụng`

## ASCII sơ đồ
```text
Main
  |
  v
AbstractFactory
  |
  +--> createA() -> ProductA1
  +--> createB() -> ProductB1
```

## Skeleton code
```java
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

class WinButton implements Button {
    public void paint() { System.out.println("Windows button"); }
}

class WinCheckbox implements Checkbox {
    public void paint() { System.out.println("Windows checkbox"); }
}

abstract class GUIFactory {
    public abstract Button createButton();
    public abstract Checkbox createCheckbox();
}

class WinFactory extends GUIFactory {
    public Button createButton() { return new WinButton(); }
    public Checkbox createCheckbox() { return new WinCheckbox(); }
}
```

## Ví dụ đề thi
- Tạo UI bộ giống nhau trên Windows/Mac.
- Tạo bộ sản phẩm theo loại xe, loại máy, loại giao diện.

## Checklist code nhanh lúc thi
- [ ] Có nhiều product liên quan
- [ ] Mỗi factory tạo cùng 1 bộ sản phẩm
- [ ] Không dùng `new` trực tiếp trong client
