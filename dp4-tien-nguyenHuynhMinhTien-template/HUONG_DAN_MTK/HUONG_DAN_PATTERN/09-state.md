# 09 - State

## Khái niệm
State cho object thay đổi hành vi khi trạng thái nội tại của nó thay đổi.

## Khi nào dùng
- Một object có nhiều trạng thái và mỗi trạng thái có cách xử lý khác.
- Muốn tránh `if/else` quá nhiều trong 1 lớp.

## Dấu hiệu nhận biết đề thi
- Đề nói đang mở khóa, khóa, tạm dừng, đang xử lý, đã hoàn thành.
- Đề thấy hành vi đổi theo trạng thái.

## Vai trò class/interface
- `State`: giao diện trạng thái.
- `ConcreteState`: từng trạng thái cụ thể.
- `Context`: giữ trạng thái hiện tại và chuyển trạng thái.

## Thứ tự tạo file
1. Tạo interface TrangThai.
2. Tạo các state cụ thể.
3. Tạo Context có biến state.
4. Khi có sự kiện thì đổi state.

## Flow hoạt động
`Context` nhận sự kiện -> gọi state hiện tại -> state có thể đổi sang state khác

## ASCII sơ đồ
```text
Context
  |
  v
State hiện tại
  |
  +--> đổi sang State mới nếu cần
```

## Skeleton code
```java
interface State {
    void handle(ContextState context);
}

class TrangThaiA implements State {
    public void handle(ContextState context) {
        System.out.println("Đang ở trạng thái A");
        context.setState(this);
    }
}

class ContextState {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}

class Main {
    public static void main(String[] args) {
        ContextState context = new ContextState();
        State stateA = new TrangThaiA();
        context.setState(stateA);
        context.request(); // Output: Đang ở trạng thái A
    }
}
```

## Ví dụ đề thi
- Trạng thái đơn hàng.
- Trạng thái máy bán vé.
- Trạng thái token đang hiệu lực/hết hạn.

## Checklist code nhanh lúc thi
- [ ] Có interface State
- [ ] Có nhiều state cụ thể
- [ ] Context giữ state hiện tại
- [ ] Có chuyển state khi cần
