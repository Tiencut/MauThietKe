# 08 - Strategy

## Khái niệm
Strategy đóng gói các thuật toán khác nhau và cho phép đổi thuật toán lúc runtime.

## Khi nào dùng
- Có nhiều cách xử lý cùng 1 vấn đề.
- Muốn đổi cách làm mà không sửa logic client.

## Dấu hiệu nhận biết đề thi
- Đề nói có nhiều công thức tính, nhiều cách sắp xếp, nhiều cách lọc, nhiều cách giao hàng.
- Đề có từ khóa: chọn thuật toán, đổi cách xử lý.

## Vai trò class/interface
- `Strategy`: giao diện thuật toán.
- `ConcreteStrategy`: từng cách xử lý.
- `Context`: giữ strategy hiện tại và gọi nó.

## Thứ tự tạo file
1. Tạo interface Strategy.
2. Tạo các class strategy cụ thể.
3. Tạo Context có `setStrategy()`.
4. Main đổi strategy và chạy.

## Flow hoạt động
`Main -> Context.setStrategy(...) -> Context.execute() -> Strategy cụ thể`

## ASCII sơ đồ
```text
Context
  |
  +--> StrategyA
  +--> StrategyB
  +--> StrategyC
```

## Skeleton code
```java
interface Strategy {
    void execute();
}

class StrategyA implements Strategy {
    public void execute() {
        System.out.println("Chiến lược A");
    }
}

class ContextStrategy {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        ContextStrategy context = new ContextStrategy();

        context.setStrategy(new StrategyA());
        context.execute(); // Chiến lược A

        context.setStrategy(new StrategyB());
        context.execute(); // Chiến lược B
    }
}
```

## Ví dụ đề thi
- Tính giá theo nhiều chính sách.
- Sắp xếp theo nhiều kiểu.

## Checklist code nhanh lúc thi
- [ ] Có interface strategy
- [ ] Có nhiều strategy cụ thể
- [ ] Context thay đổi được strategy
