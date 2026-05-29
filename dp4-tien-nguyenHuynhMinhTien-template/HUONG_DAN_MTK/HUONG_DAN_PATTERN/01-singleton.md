# 01 - Singleton

## Khái niệm
Singleton đảm bảo 1 class chỉ có duy nhất 1 instance và có điểm truy cập toàn cục.

## Khi nào dùng
- Cần quản lý 1 tài nguyên chung: config, connection manager, cache, logger.
- Cần tránh tạo nhiều object tốn RAM hoặc gây xung đột.

## Dấu hiệu nhận biết đề thi
- Đề nói chỉ có 1 đối tượng dùng chung toàn chương trình.
- Đề có từ khóa: duy nhất, toàn cục, quản lý trung tâm.

## Vai trò class/interface
- `Singleton`: class tự quản lý instance.
- Thường có `private` constructor.
- Có `getInstance()` để lấy object.

## Thứ tự tạo file
1. Tạo class `Singleton`.
2. Đặt constructor `private`.
3. Tạo biến static lưu instance.
4. Tạo `getInstance()`.
5. Gọi từ `Main` để test.

## Flow hoạt động
`Main -> getInstance() -> nếu chưa có thì tạo mới -> trả về cùng 1 object`

## ASCII sơ đồ
```text
Main
  |
  v
Singleton.getInstance()
  |
  +--> tạo mới nếu chưa có
  |
  +--> trả về instance cũ
```

## Skeleton code
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void action() {
        System.out.println("Singleton đang chạy");
    }
}
```

## Ví dụ đề thi
- Quản lý cấu hình ứng dụng.
- Quản lý kết nối database trung tâm.

## Checklist code nhanh lúc thi
- [ ] Constructor `private`
- [ ] Biến `static instance`
- [ ] `getInstance()`
- [ ] Test in ra 2 lần cùng địa chỉ object
