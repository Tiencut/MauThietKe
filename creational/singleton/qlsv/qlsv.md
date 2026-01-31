Sử dụng MySQL/Ms SQL Server tạo CSDL QuanLySinhVien gồm 4 bảng SinhVien, Khoa, GiangVien, NganhDaoTao


Viết 4 hàm select dữ liệu từ 4 bảng này, sử dụng kết nối có đảm bảo kết nối này là duy nhất — dùng mẫu Singleton

<!--  -->
mvn exec:java

<!--  -->
D:\TienCut\codeHoc\MauThietKe> cd d:\TienCut\codeHoc\MauThietKe\creational\singleton\qlsv
>> mvn compile
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:qlsv >--------------------------
[INFO] Building qlsv 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ qlsv ---        
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\TienCut\codeHoc\MauThietKe\creational\singleton\qlsv\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ qlsv ---
[INFO] Nothing to compile - all classes are up to date.
----
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.260 s
[INFO] Finished at: 2026-01-31T11:07:06+07:00
[INFO] ------------------------------------------------------------------------
PS D:\TienCut\codeHoc\MauThietKe\creational\singleton\qlsv> mvn exec:java  
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:qlsv >--------------------------
[INFO] Building qlsv 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.1.0:java (default-cli) @ qlsv ---
Database initialized successfully.
SinhVien:
SinhVien{id=1, name='Nguyen Van A', age=20}
SinhVien{id=2, name='Tran Thi B', age=21}
SinhVien{id=3, name='Le Van C', age=19}

Khoa:
Khoa{id=1, name='Cong Nghe Thong Tin'}
Khoa{id=2, name='Kinh Te'}
Khoa{id=3, name='Ky Thuat Dien'}

GiangVien:
GiangVien{id=1, name='Nguyen Van D'}
GiangVien{id=2, name='Tran Thi E'}
GiangVien{id=3, name='Le Van F'}

NganhDaoTao:
NganhDaoTao{id=1, name='Cong Nghe Phan Mem'}
NganhDaoTao{id=2, name='Kinh Te Doi Ngoai'}
NganhDaoTao{id=3, name='Dien Tu Vien Thong'}
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.339 s
[INFO] Finished at: 2026-01-31T11:07:22+07:00
[INFO] ------------------------------------------------------------------------