# Hệ thống Quản lý Bãi Đỗ Xe Khu Căn Hộ Phức Hợp

## Mô tả Hệ thống
Hệ thống quản lý bãi đỗ xe dành cho khu căn hộ phức hợp (chung cư). 
Xe vào gửi là xe của cư dân sống tại chung cư.

## Thông tin mỗi Xe
- Biển số xe (xe đạp không có biển số)
- Số CMND của chủ nhân, họ tên, giới tính, mã số căn hộ
- Hãng sản xuất (xe đạp không bắt buộc)
- Màu sơn

## Loại Bãi Đỗ Xe
Có 2 loại bãi đỗ xe chính:

### Xe 4 Bánh (Ô tô)
Khi đỗ hoặc lấy xe, nhân viên ghi nhận:
- Biển số xe (biển kiểm soát)
- Thời gian vào bãi
- Thời gian ra bãi
- Tình trạng xe lúc vào bãi
- Tình trạng xe lúc ra bãi

### Xe 2 Bánh
Chia thành 2 loại: xe gắn máy và xe đạp.

#### Xe Gắn Máy
Nhân viên ghi nhận:
- Biển số xe
- Thời gian vào bãi
- Thời gian ra bãi

#### Xe Đạp
Nhân viên ghi nhận:
- Số vé xe (do nhân viên cấp)
- Thời gian vào bãi
- Thời gian ra bãi

## Yêu cầu Thí Sinh
Code Java (Lưu ý: không cần xử lý tiếng Việt có dấu khi đọc/ghi file dữ liệu)

### Yêu cầu 1 (2 điểm): code OOP
- Biết cách chia các class và tạo quan hệ kế thừa hợp lý (1 điểm)
- Biết xác định class trừu tượng (abstract class) và class cụ thể (0.5 điểm)
- Biết xác định hàm trừu tượng (abstract method) và hàm cụ thể, override ở class con (0.5 điểm)

### Yêu cầu 2 (1 điểm): Đọc File input1.txt
File input1.txt chứa dữ liệu xe vào bãi, mỗi dòng:
- Loại xe; biển số xe; số vé xe; thời gian vào bãi; tình trạng xe lúc vào bãi
- Thông tin không có: "Not Available"
- Loại xe: 4 (4 bánh), 2 (gắn máy), 0 (đạp)
- Tình trạng: "Binh thuong" nếu bình thường, mô tả nếu bất thường

### Yêu cầu 3 (1 điểm): Thiết kế Cơ sở Dữ liệu
Thiết kế CSDL quan hệ tên "parking" với đầy đủ bảng, khóa chính, khóa ngoại để lưu dữ liệu từ input1.txt và đáp ứng yêu cầu bài toán.

### Yêu cầu 4 (1 điểm): Nhập Dữ liệu vào CSDL
- Xác định dòng hợp lệ (0.5 điểm): Dữ liệu phù hợp với loại xe, không dư thừa
- Nhập dữ liệu hợp lệ từ input1.txt vào CSDL (0.5 điểm)

### Yêu cầu 5 (1 điểm): Đọc File input2.txt
File input2.txt chứa dữ liệu xe ra bãi, mỗi dòng:
- Loại xe; biển số xe; số vé xe; thời gian ra bãi; tình trạng xe lúc ra bãi
- Thông tin không có: "Not Available"
- Loại xe: 4 (4 bánh), 2 (gắn máy), 0 (đạp)
- Tình trạng ra bãi (xe 4 bánh): "Binh thuong" nếu không thay đổi, mô tả bất thường nếu có

### Yêu cầu 6 (4 điểm): Xuất Thông tin và Tính Tiền
Lưu ý:
- Xuất ra màn hình WinForm thay vì file nếu có
- Giả định dữ liệu input2.txt hợp lệ
- Cách tính tiền:
  - Xe 4 bánh: 5000 đồng / 0.5 giờ (làm tròn), "Chua xac dinh - Dang xu ly boi thuong" nếu bất thường
  - Xe gắn máy: 3000 đồng / ngày (làm tròn)
  - Xe đạp: 1000 đồng / ngày (làm tròn)

#### Cách tính điểm:
- Tính tiền và xuất ra file/màn hình: 1 điểm
- Xuất thông tin vào/ra ra file output.txt: 1 điểm (format: loại xe; biển số; vé; vào; ra; tiền)
- Xuất ra màn hình WinForm: 2 điểm (+1 điểm nếu giao diện đẹp, bố cục phức tạp)

https://file.notion.so/f/f/5edaf82f-4e36-4fb5-9f40-ee31bdbc00b3/5fcd96e1-17d0-4ff8-b26f-cf226afd5832/Java_Co_Ban_De_thi_K36.pdf?table=block&id=2f0beda3-f99a-80fc-8602-fc038d7d994a&spaceId=5edaf82f-4e36-4fb5-9f40-ee31bdbc00b3&expirationTimestamp=1769846400000&signature=tg_8FJ8JJTKYsuUspqvB7lJ06Jq3ToYfblBh3_pf0uY&downloadName=Java+Co+Ban_De+thi_K36.pdf