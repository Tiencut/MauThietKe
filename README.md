hệ thống quản lý bãi đỗ xe của khu căn hộ phức hợp (chung cư):

Xe vào gửi là xe của cư dân sống tại chung cư
Xe
+ Biển số xe(xe đạp không có biển số), 
+ số CMND của chủ nhân, họ tên, giới tính, mã số căn hộ, 
+ hãng sản xuất (Xe đạp thì không bắt buộc phải có hãng sản xuất), 
+ màu sơn.

BaiDoXe, 2 loại: 
+ xe 4 bánh (xe ô tô)
    Đối với xe 4 bánh thì khi đỗ xe hoặc lấy xe, 
    nhân viên quản lý bãi đỗ xe phải ghi nhận các thông tin: 
    biển số xe (biển kiểm soát), thời gian vào bãi, thời gian ra bãi, tình trạng xe lúc vào bãi, tình trạng xe lúc ra bãi.
+ xe 2 bánh.
    Xe 2 bánh được chia thành 2 loại: xe gắn máy và xe đạp.
    + Đối với xe gắn máy, nhân viên quản lý cần ghi nhận các thông tin: 
        biển số xe, thời gian vào bãi, thời gian ra bãi.
    + Đối với xe đạp, nhân viên quản lý cần ghi nhận các thông tin: 
        số vé xe (do nhân viên quản lý bãi tự cấp cho chủ xe khi giao vé giữ xe), thời gian vào bãi, thời gian ra bãi.

Yêu cầu đối với thí sinh:
code java (Lưu ý: không cần xử lý tiếng Việt có dấu khi đọc/ghi file dữ liệu)

Yêu cầu 1 (2 điểm): Thí sinh phải biết cách lập trình theo hướng đối tượng. Yêu cầu cụ thể như sau:
- Biết cách chia các class và tạo quan hệ kế thừa giữa các class một cách hợp lý (1 điểm)
- Biết cách xác định class trừu tượng (abstract class) và class cụ thể (0.5 điểm)
- Biết cách xác định hàm trừu tượng (abstract method) và hàm cụ thể. Biết cách override các hàm ở các class con để xử lý nghiệp vụ của chương trình (0.5 điểm)

Yêu cầu 2 (1 điểm): Đọc được file dữ liệu đầu vào cho chương trình có tên là input1.txt, cấu
trúc của file này được mô tả như sau:
Mỗi dòng của file tương ứng với dữ liệu của một xe đi vào bãi đỗ xe. Dữ liệu được mô tả
theo thứ tự như sau:
 Loại xe, biển số xe, số vé xe, thời gian vào bãi, tình trạng xe lúc vào bãi. Tùy vào từng
loại xe mà một số thông tin sẽ không có giá trị. Những thông tin nào không có thì sẽ nhận giá trị là
"Not Available". Các thông tin trên được phân cách với nhau bởi dấu chấm phẩy (;).
 Loại xe được quy định như sau: 4 là xe 4 bánh, 2 là xe gắn máy, 0 là xe đạp.
 Tình trạng xe lúc vào bãi được quy định như sau: Nếu xe không có bất thường nào thì
có giá trị là "Binh thuong". Nếu xe có bất kỳ bất thường nào (ví dụ bị trầy xướt, mất kính
chiếu hậu...) thì phải mô tả rõ.


Yêu cầu 3 (1 điểm): Thiết kế cơ sở dữ liệu quan hệ (tạo đầy đủ các bảng, khóa chính, khóa
ngoại...), đặt tên cơ sở dữ liệu này là parking để lưu trữ được dữ liệu trong file input1.txt và
thỏa mãn yêu cầu chung của toàn bộ bài toán.

Yêu cầu 4 (1 điểm): Đưa dữ liệu hợp lệ trong file input1.txt vào cơ sở dữ liệu parking đã tạo
theo yêu cầu như sau:
- Xác định được dòng dữ liệu hợp lệ thì được 0.5 điểm. Dòng hợp lệ là dòng thỏa mãn
nguyên tắc về dữ liệu như sau: Dòng dữ liệu đang dành cho xe loại nào thì chỉ chứa thông tin
tương ứng với loại xe đó, không chứa dữ liệu dư thừa. Ví dụ: dòng dữ liệu đang dành cho loại
xe 4 bánh thì không được chứa thông tin Số vé xe...
- Đưa được các dòng dữ liệu hợp lệ từ file input1.txt vào cơ sở dữ liệu thì được 0.5 điểm

Yêu cầu 5 (1 điểm): Đọc được file dữ liệu đầu vào thứ hai cho chương trình có tên là input2.txt,
cấu trúc của file này được mô tả như sau:
Mỗi dòng của file tương ứng với dữ liệu của một xe đi ra khỏi bãi đỗ xe. Dữ liệu được
mô tả theo thứ tự như sau:
 Loại xe, biển số xe, số vé xe, thời gian ra bãi, tình trạng xe lúc ra bãi. Tùy vào từng loại
xe mà một số thông tin sẽ không có giá trị. Những thông tin nào không có thì sẽ nhận giá trị là "Not
Available". Các thông tin trên được phân cách với nhau bởi dấu chấm phẩy (;).
 Loại xe được quy định như sau: 4 là xe 4 bánh, 2 là xe gắn máy, 0 là xe đạp.
Giá trị của thông tin "Tình trạng xe lúc ra bãi" (dành cho xe 4 bánh) được mô tả như sau:
- Nếu xe không có phát sinh bất thường nào khi ra bãi (so với lúc vào bãi) thì giá trị của thông
tin này là "Binh thuong".
- Nếu xe có phát sinh bất thường nào khi ra bãi (so với lúc vào bãi) thì giá trị của thông tin
này là những mô tả về các bất thường đó.
Ví dụ mẫu về dữ liệu của file input2.txt được mô tả như hình sau:

Yêu cầu 6 (4 điểm): Xuất thông tin ngày giờ vào/ra và tính tiền thuê bãi cho các xe:
Lưu ý:
- Nếu đã xuất được thông tin ra màn hình winform thì không cần xuất thông tin ra
file
- Giả định thông tin trong file input2.txt là những thông tin đã hợp lệ. Thí sinh không
cần kiểm tra tính hợp lệ của dữ liệu trong file input2.txt. (Ví dụ: trong file input2.txt có dữ liệu
liên quan đến 1 xe 4 bánh có biển số xe là 75A-571.47 nghĩa là giả định trong cơ sỡ dữ liệu đã
chắc chắn có dữ liệu của xe 4 bánh có biển số xe như vậy rồi)
- Cách tính tiền thuê bãi như sau:
+ Đối với xe 4 bánh: 5000 đồng / 0,5 giờ (tức là làm tròn đến 0,5 giờ - ví dụ thuê
1 giờ 5 phút thì được tính thành 1,5 giờ; thuê 35 phút thì làm tròn thành 1 giờ; thuê 5 phút cũng được làm tròn thành 0,5 giờ). Riêng trường hợp có phát sinh tình trạng bất thường của xe khi
ra bãi thì giá trị của thông tin tiền thuê bãi này được ghi là: "Chua xac dinh - Dang xu ly boi
thuong".
+ Đối với xe gắn máy: 3000 đồng / ngày đêm (tức là làm tròn đến 1 ngày - ví dụ
thuê 1 ngày 1 phút thì được tính thành 2 ngày; thuê 5 phút cũng được làm tròn thành 1 ngày)
+ Đối với xe đạp: 1000 đồng / ngày đêm (tức là làm tròn đến 1 ngày - ví dụ thuê
1 ngày 1 phút thì được tính thành 2 ngày; thuê 5 phút cũng được làm tròn thành 1 ngày)
Cách tính điểm cho yêu cầu 6:
- Nếu thí sinh tính được tiền thuê bãi theo công thức phía trên, xuất được thông tin tiền
thuê bãi ra file hoặc màn hình winform thì được 1 điểm.
- *** Nếu thí sinh xuất được thông tin vào/ra bãi cho từng xe ra file output.txt thì được 1
điểm. Cách xuất thông tin ra file output.txt được mô tả trong ví dụ ở hình sau:
Mỗi dòng của file tương ứng với dữ liệu của một xe đã vào và ra bãi đỗ xe. Dữ liệu
được mô tả theo thứ tự như sau:
 Loại xe, biển số xe, số vé xe, thời gian vào bãi, thời gian ra bãi, tiền thuê bãi. Tùy vào
từng loại xe mà một số thông tin sẽ không có giá trị. Những thông tin nào không có thì sẽ nhận giá
trị là "Not Available". Các thông tin trên được phân cách với nhau bởi dấu chấm phẩy (;).
- *** Nếu thí sinh xuất được thông tin cho từng xe ra màn hình winform (được mô tả
như hình dưới) thì được 2 điểm. Nếu giao diện winform có phối màu và tạo bố cục phức tạp thì
được cộng thêm 1 điểm. (Nếu thí sinh vừa xuất thông tin ra file output.txt vừa xuất thông tin
ra màn hình winform thì cũng chỉ được tính điểm cho phần xuất thông tin ra màn hình
winform)