# 12 - Facade

## Khái niệm
Facade cung cấp 1 giao diện đơn giản để làm việc với một tập hợp hệ thống con phức tạp.

## Khi nào dùng
- Hệ thống có nhiều subsystem, client không muốn gọi nhiều lớp riêng lẻ.
- Muốn giảm độ phức tạp của client.

## Dấu hiệu nhận biết đề thi
- Đề nói 1 class điều khiển nhiều module con.
- Đề có các bước xử lý liên tiếp, nhiều lớp phụ trợ.

## Vai trò class/interface
- `Facade`: lớp mặt tiền đơn giản.
- `Subsystem`: các lớp bên dưới làm việc thật.
- Client chỉ gọi `Facade`.

## Thứ tự tạo file
1. Tạo các subsystem.
2. Tạo facade giữ các subsystem.
3. Tạo method tổng hợp trong facade.
4. Client gọi facade.

## Flow hoạt động
`Client -> Facade -> subsystem1/subsystem2/subsystem3 -> kết quả`

## ASCII sơ đồ
```text
Client
  |
  v
Facade
  |
  +--> Subsystem A
  +--> Subsystem B
  +--> Subsystem C
```

## Skeleton code
```java
class SubsystemA {
    public void stepA() { System.out.println("A"); }
}

class SubsystemB {
    public void stepB() { System.out.println("B"); }
}

class SubsystemC {
    public void stepC() { System.out.println("C"); }
}

class FacadeService {
    private final SubsystemA a = new SubsystemA();
    private final SubsystemB b = new SubsystemB();
    private final SubsystemC c = new SubsystemC();

    public void runAll() {
        a.stepA();
        b.stepB();
        c.stepC();
    }
}
```

## Ví dụ đề thi
- Đặt hàng: kiểm tra tồn kho, tính tiền, tạo hóa đơn.
- Đăng nhập: kiểm tra tài khoản, phân quyền, log.

## Checklist code nhanh lúc thi
- [ ] Có lớp mặt tiền
- [ ] Client không chạm trực tiếp subsystem
- [ ] Facade gom luồng xử lý
