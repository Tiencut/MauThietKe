CREATE DATABASE MTK_SinhVien;
GO;

-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
    MaSinhVien NVARCHAR(10) PRIMARY KEY,
    HoTen NVARCHAR(50) NOT NULL,
    GioiTinhNam BIT NOT NULL,
    NgaySinh DATE NOT NULL
);

-- Thêm dữ liệu mẫu
INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES
('T012001', N'Nguyễn Thị Hoa', 0, '2001-10-30'),
('T012005', N'Trần Văn Huy', 1, '2000-02-29'),
('T102002', N'Lê Văn Nam', 1, '2001-09-02'),
('SV082', N'Test Student', 1, '1999-05-15');