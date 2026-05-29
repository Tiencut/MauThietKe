-- Doi MaSinhVien thanh MSSV cua ban, vi du: BaiThiDP_22T1020761
CREATE DATABASE BaiThiDP_MaSinhVien;
GO

USE BaiThiDP_MaSinhVien;
GO

-- Bang mau, sua theo de thi
CREATE TABLE MauDoiTuong (
    id INT IDENTITY(1,1) PRIMARY KEY,
    ten NVARCHAR(100) NOT NULL,
    gia DECIMAL(18,2) NOT NULL
);
GO

CREATE TABLE ChucNangThem (
    id INT IDENTITY(1,1) PRIMARY KEY,
    ten NVARCHAR(100) NOT NULL,
    mo_ta NVARCHAR(255),
    chi_phi DECIMAL(18,2) NOT NULL
);
GO

CREATE TABLE CauHinh (
    id INT IDENTITY(1,1) PRIMARY KEY,
    mau_id INT NOT NULL,
    ten_khach_hang NVARCHAR(100) NOT NULL,
    FOREIGN KEY (mau_id) REFERENCES MauDoiTuong(id)
);
GO

CREATE TABLE CauHinh_ChucNang (
    id INT IDENTITY(1,1) PRIMARY KEY,
    cau_hinh_id INT NOT NULL,
    chuc_nang_id INT NOT NULL,
    thu_tu INT NOT NULL,
    FOREIGN KEY (cau_hinh_id) REFERENCES CauHinh(id),
    FOREIGN KEY (chuc_nang_id) REFERENCES ChucNangThem(id)
);
GO

INSERT INTO MauDoiTuong(ten, gia) VALUES
(N'Mau 1', 1000000),
(N'Mau 2', 2000000),
(N'Mau 3', 3000000),
(N'Mau 4', 4000000),
(N'Mau 5', 5000000);

INSERT INTO ChucNangThem(ten, mo_ta, chi_phi) VALUES
(N'Chuc nang 1', N'Mo ta 1', 100000),
(N'Chuc nang 2', N'Mo ta 2', 200000),
(N'Chuc nang 3', N'Mo ta 3', 300000),
(N'Chuc nang 4', N'Mo ta 4', 400000),
(N'Chuc nang 5', N'Mo ta 5', 500000);

INSERT INTO CauHinh(mau_id, ten_khach_hang) VALUES
(1, N'Khach hang 1'),
(2, N'Khach hang 2'),
(3, N'Khach hang 3'),
(4, N'Khach hang 4'),
(5, N'Khach hang 5');

INSERT INTO CauHinh_ChucNang(cau_hinh_id, chuc_nang_id, thu_tu) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 3, 1),
(3, 4, 1),
(4, 5, 1),
(5, 1, 1),
(5, 3, 2);
GO
