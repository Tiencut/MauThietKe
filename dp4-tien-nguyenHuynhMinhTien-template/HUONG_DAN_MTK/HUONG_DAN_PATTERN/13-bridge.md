# 13 - Bridge

## Khái niệm
Bridge tách phần trừu tượng và phần triển khai thành hai cấu trúc độc lập, để chúng có thể thay đổi riêng.

## Khi nào dùng
- Có 2 chiều biến đổi độc lập nhau.
- Muốn tránh nổ số lớp khi kết hợp nhiều biến thể.

## Dấu hiệu nhận biết đề thi
- Đề nói có nhiều loại hình trừu tượng và nhiều loại triển khai.
- Đề muốn thay đổi giao diện và implementation riêng lẻ.

## Vai trò class/interface
- `Abstraction`: lớp trừu tượng.
- `RefinedAbstraction`: lớp trừu tượng cụ thể.
- `Implementor`: giao diện triển khai.
- `ConcreteImplementor`: triển khai cụ thể.

## Thứ tự tạo file
1. Tạo Implementor.
2. Tạo ConcreteImplementor.
3. Tạo Abstraction giữ Implementor.
4. Tạo RefinedAbstraction.
5. Client kết hợp 2 phần độc lập.

## Flow hoạt động
`Abstraction -> gọi Implementor -> xử lý`

## ASCII sơ đồ
```text
Abstraction ----> Implementor
     |                 |
     v                 v
RefinedAbstraction   ConcreteImplementor
```

## Skeleton code
```java
interface Renderer {
    void renderCircle(int radius);
}

class VectorRenderer implements Renderer {
    public void renderCircle(int radius) {
        System.out.println("Vẽ vector bán kính " + radius);
    }
}

abstract class Shape {
    protected final Renderer renderer;

    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}

class Circle extends Shape {
    private final int radius;

    public Circle(Renderer renderer, int radius) {
        super(renderer);
        this.radius = radius;
    }

    public void draw() {
        renderer.renderCircle(radius);
    }
}
```

## Ví dụ đề thi
- Hình vẽ có nhiều cách render.
- Thiết bị có nhiều giao diện và nhiều loại điều khiển.

## Checklist code nhanh lúc thi
- [ ] Tách abstraction và implementation
- [ ] Không để class nổ ra quá nhiều biến thể
- [ ] Client có thể kết hợp tự do
