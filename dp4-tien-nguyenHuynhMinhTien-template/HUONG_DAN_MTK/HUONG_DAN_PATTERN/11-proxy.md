# 11 - Proxy

## Khái niệm
Proxy là đối tượng đại diện trung gian, cùng interface với đối tượng thật, dùng để kiểm soát truy cập hoặc thêm hành vi phụ.

## Khi nào dùng
- Cần kiểm tra quyền truy cập.
- Cần lazy load, cache, log, đếm số lần gọi.

## Dấu hiệu nhận biết đề thi
- Đề nói truy cập có điều kiện, chỉ xem được nếu đủ quyền.
- Đề nói đối tượng thật nặng, chỉ tải khi cần.

## Vai trò class/interface
- `Subject`: giao diện chung.
- `RealSubject`: đối tượng thật.
- `Proxy`: đối tượng trung gian, giữ `RealSubject`.

## Thứ tự tạo file
1. Tạo interface Subject.
2. Tạo RealSubject.
3. Tạo Proxy cùng implement Subject.
4. Proxy kiểm tra điều kiện và forward.

## Flow hoạt động
`Client -> Proxy -> nếu hợp lệ thì gọi RealSubject -> trả kết quả`

## ASCII sơ đồ
```text
Client
  |
  v
Proxy
  |
  +--> kiểm tra quyền / cache / lazy load
  |
  v
RealSubject
```

## Skeleton code
```java
interface DichVu {
    void request();
}

class DichVuThat implements DichVu {
    public void request() {
        System.out.println("Xử lý thật");
    }
}

class DichVuProxy implements DichVu {
    private final String role;
    private DichVuThat realSubject;

    public DichVuProxy(String role) {
        this.role = role;
    }

    public void request() {
        if (!"admin".equalsIgnoreCase(role)) {
            System.out.println("Không đủ quyền");
            return;
        }
        if (realSubject == null) {
            realSubject = new DichVuThat();
        }
        realSubject.request();
    }
}

class Client {
    public static void main(String[] args) {
        DichVu proxy = new DichVuProxy("user");
        proxy.request(); // Không đủ quyền

        DichVu adminProxy = new DichVuProxy("admin");
        adminProxy.request(); // Xử lý thật
    }
}
```

## Ví dụ đề thi
- Phân quyền người dùng.
- Tải file lớn khi cần.
- Đệm dữ liệu trung gian.

## Checklist code nhanh lúc thi
- [ ] Có Subject
- [ ] Có RealSubject
- [ ] Có Proxy trung gian
- [ ] Có điều kiện trước khi gọi object thật
