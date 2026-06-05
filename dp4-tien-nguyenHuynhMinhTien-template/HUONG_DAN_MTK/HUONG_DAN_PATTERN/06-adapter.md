# 06 - Adapter

## Khái niệm
Adapter giúp 2 giao diện không tương thích có thể làm việc với nhau thông qua một lớp chuyển đổi.

## Khi nào dùng
- Muốn dùng thư viện cũ, class cũ, API cũ.
- Client đã có giao diện riêng và không muốn sửa code cũ.

## Dấu hiệu nhận biết đề thi
- Đề nói chuyển đổi định dạng, chuyển giao diện, bọc class cũ vào hệ thống mới.

## Vai trò class/interface
- `Target`: giao diện client đang cần.
- `Adaptee`: class cũ không hợp giao diện.
- `Adapter`: chuyển đổi Adaptee sang Target.

## Thứ tự tạo file
1. Tạo giao diện Target.
2. Có class cũ Adaptee.
3. Tạo Adapter implement Target và giữ Adaptee.
4. Client chỉ dùng Target.

## Flow hoạt động
`Client -> Target(Adapter) -> Adaptee -> kết quả`

## ASCII sơ đồ
```text
Client
  |
  v
Adapter implements Target
  |
  v
Adaptee.legacyMethod()
```

## Skeleton code
```java
interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("Hàm cũ");
    }
}

class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}
```

## Ví dụ đề thi
- Chuyển dữ liệu từ hệ cũ sang hệ mới.
- Bọc API cũ vào giao diện mới của project.

## Checklist code nhanh lúc thi
- [ ] Có Target
- [ ] Có Adaptee
- [ ] Có Adapter nối 2 bên
