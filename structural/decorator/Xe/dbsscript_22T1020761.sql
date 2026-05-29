CREATE DATABASE BaiThiDP_22T1020761;
GO

USE BaiThiDP_22T1020761;
GO

CREATE TABLE Xe (
    xe_id INT IDENTITY(1,1) PRIMARY KEY,
    ten_mau_xe VARCHAR(255) NOT NULL,
    gia_co_ban DECIMAL(10, 2) NOT NULL,
    mo_ta TEXT
);
GO

CREATE TABLE TrangTri (
    trang_tri_id INT IDENTITY(1,1) PRIMARY KEY,
    ten_trang_tri VARCHAR(255) NOT NULL,
    chi_phi_them DECIMAL(10, 2) NOT NULL,
    mo_ta TEXT
);
GO

CREATE TABLE KhachHang (
    khach_hang_id INT IDENTITY(1,1) PRIMARY KEY,
    ten_khach_hang NVARCHAR(255) NOT NULL
);
GO

CREATE TABLE CauHinhXe (
    cau_hinh_id INT IDENTITY(1,1) PRIMARY KEY,
    xe_id INT NOT NULL,
    khach_hang_id INT NOT NULL,
    ngay_cau_hinh DATETIME DEFAULT CURRENT_TIMESTAMP,
    gia_cuoi_cung DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (xe_id) REFERENCES Xe(xe_id),
    FOREIGN KEY (khach_hang_id) REFERENCES KhachHang(khach_hang_id)
);
GO

CREATE TABLE CauHinhTrangTriXe (
    cau_hinh_trang_tri_id INT IDENTITY(1,1) PRIMARY KEY,
    cau_hinh_id INT NOT NULL,
    trang_tri_id INT NOT NULL,
    thu_tu_ap_dung INT NOT NULL DEFAULT 1,
    FOREIGN KEY (cau_hinh_id) REFERENCES CauHinhXe(cau_hinh_id) ON DELETE CASCADE,
    FOREIGN KEY (trang_tri_id) REFERENCES TrangTri(trang_tri_id)
);
GO

INSERT INTO Xe (ten_mau_xe, gia_co_ban, mo_ta) VALUES
('Honda City', 560000.00, 'Xe sedan hang B, tiet kiem nhien lieu.'),
('Hyundai Grand i10', 380000.00, 'Xe nho gon, phu hop di chuyen trong do thi.'),
('Toyota Vios', 590000.00, 'Xe sedan pho bien, ben bi va giu gia.'),
('Kia Morning ABC', 350000.00, 'Xe do thi co nho, chi phi van hanh thap.'),
('Suzuki XYZ', 420000.00, 'Xe gia dinh nho gon, thiet ke linh hoat.');
GO

INSERT INTO TrangTri (ten_trang_tri, chi_phi_them, mo_ta) VALUES
('Loa', 5000.00, 'He thong loa co ban cho xe.'),
('Den LED Chieu Sang', 7000.00, 'Tang kha nang chieu sang khi di ban dem.'),
('Loa Bass', 9000.00, 'Tang chat luong am thanh va am tram.'),
('Dieu Hoa Nhiet Do Phu', 12000.00, 'He thong dieu hoa phu cho hang ghe sau.'),
('Boc Ghe Ngoi', 8000.00, 'Boc ghe da cao cap, de ve sinh.'),
('Camera Hanh Trinh', 6000.00, 'Ghi hinh hanh trinh va ho tro an toan.');
GO

INSERT INTO KhachHang (ten_khach_hang) VALUES
(N'Nguyen Van An'),
(N'Tran Thi Binh'),
(N'Le Minh Cuong'),
(N'Pham Thu Dung'),
(N'Hoang Quoc Viet');
GO

INSERT INTO CauHinhXe (xe_id, khach_hang_id, gia_cuoi_cung) VALUES
(1, 1, 572000.00),
(2, 2, 397000.00),
(3, 3, 604000.00),
(4, 4, 371000.00),
(5, 5, 446000.00);
GO

INSERT INTO CauHinhTrangTriXe (cau_hinh_id, trang_tri_id, thu_tu_ap_dung) VALUES
(1, 1, 1),
(1, 2, 2),

(2, 3, 1),
(2, 5, 2),

(3, 2, 1),
(3, 4, 2),

(4, 1, 1),
(4, 6, 2),
(4, 5, 3),

(5, 2, 1),
(5, 3, 2),
(5, 4, 3);
GO
