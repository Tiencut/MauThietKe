# 10 - Decorator

## Khái niệm
Decorator bọc thêm tính năng cho object động mà không cần sửa class gốc.

## Khi nào dùng
- Muốn thêm chức năng từng lớp một, có thể chồng nhau.
- Muốn tránh nổ class con nếu thêm quá nhiều biến thể.

## Dấu hiệu nhận biết đề thi
- Đề nói vật thể gốc và các phụ kiện bọc thêm bên ngoài.
- Đề có các chức năng có thể kết hợp linh hoạt.

## Vai trò class/interface
- `Component`: giao diện chung.
- `ConcreteComponent`: đối tượng gốc.
- `Decorator`: lớp bọc, giữ 1 `Component` bên trong.
- `ConcreteDecorator`: tính năng cụ thể.

## Thứ tự tạo file
1. Tạo interface component.
2. Tạo đối tượng gốc.
3. Tạo decorator abstract giữ component.
4. Tạo concrete decorator.
5. Bọc nhiều lần trong `Main`.

## Flow hoạt động
`ConcreteComponent -> Decorator1 -> Decorator2 -> call()`

## ASCII sơ đồ
```text
Component gốc
   |
   +--> Decorator A
           |
           +--> Decorator B
```

## Skeleton code
```java
interface ThanhPhan {
    String getDescription();
}

class DoiTuongGoc implements ThanhPhan {
    public String getDescription() {
        return "Đối tượng gốc";
    }
}

abstract class ChucNangDecorator implements ThanhPhan {
    protected final ThanhPhan component;

    protected ChucNangDecorator(ThanhPhan component) {
        this.component = component;
    }
}

class ChucNangThem extends ChucNangDecorator {
    public ChucNangThem(ThanhPhan component) {
        super(component);
    }

    public String getDescription() {
        return component.getDescription() + " + chức năng thêm";
    }
}
```

## Ví dụ đề thi
- Sản phẩm có phụ kiện.
- Dịch vụ có thêm log, thêm phí, thêm thuế, thêm khuyến mãi.

## Checklist code nhanh lúc thi
- [ ] Có component gốc
- [ ] Decorator giữ component
- [ ] Bọc thêm tính năng mà không sửa class gốc
