# State Pattern - Mô phỏng Chế độ Điện thoại

Dự án này minh họa cách áp dụng Design Pattern **State** để quản lý các chế độ âm thanh của điện thoại (Chuẩn, Ngoài trời, Yên lặng).

## 1. Cấu trúc Project (Packages)
- `vn.edu.husc.s_t1020761`: Chứa file chạy chính `ChuongTrinh.java`.
- `vn.edu.husc.s_t1020761.context`: Chứa lớp `DienThoai` (Lớp ngữ cảnh).
- `vn.edu.husc.s_t1020761.state`: Chứa interface `CheDoDienThoai` và các trạng thái cụ thể.
- `vn.edu.husc.s_t1020761.utils`: Chứa các hàm tiện ích hỗ trợ (rung, phát âm thanh).

## 2. Cách chạy chương trình
Mở Terminal tại thư mục gốc của dự án và chạy các lệnh sau:

```powershell
# Biên dịch
javac -d bin -sourcepath src src\vn\edu\husc\s_t1020761\ChuongTrinh.java

# Chạy
java -cp bin vn.edu.husc.s_t1020761.ChuongTrinh
```

## 3. Nội dung các file chính

### Interface: CheDoDienThoai.java
Định nghĩa các hành động chung mà mọi trạng thái (chế độ) phải thực hiện.
```java
public interface CheDoDienThoai {
    void onCalling();
    void onSMSReceived();
    void onSystemNotification();
    String getTenCheDo();
}
```

### Context: DienThoai.java
Lớp sử dụng State Pattern. Nó không tự xử lý hành vi mà ủy thác cho đối tượng `cheDo` hiện tại.
```java
public class DienThoai {
    private CheDoDienThoai cheDo;
    public void setCheDo(CheDoDienThoai cheDo) {
        this.cheDo = cheDo;
    }
    public void coCuocGoiDen() {
        cheDo.onCalling();
    }
    // ... các phương thức khác tương tự
}
```

### Concrete State: CheDoYenLang.java (Ví dụ)
Một trạng thái cụ thể thực thi các phương thức theo cách riêng.
```java
public class CheDoYenLang implements CheDoDienThoai {
    @Override
    public void onCalling() {
        Utils.rung(); // Chỉ rung, không chuông
    }
    // ...
}
```

---
*Ghi chú: Bài tập thực hành môn Design Pattern - State Pattern.*