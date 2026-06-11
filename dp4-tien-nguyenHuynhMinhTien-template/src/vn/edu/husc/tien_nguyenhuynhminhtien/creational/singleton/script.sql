-- Script tạo cơ sở dữ liệu QuanLySinhVien với 4 bảng
-- Chạy trong H2 Console hoặc SQL tool

-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

-- Tạo bảng Khoa
CREATE TABLE Khoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Tạo bảng GiangVien
CREATE TABLE GiangVien (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Tạo bảng NganhDaoTao
CREATE TABLE NganhDaoTao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Chèn dữ liệu mẫu vào bảng SinhVien
INSERT INTO SinhVien (name, age) VALUES
('Nguyen Van A', 20),
('Tran Thi B', 21),
('Le Van C', 19);

-- Chèn dữ liệu mẫu vào bảng Khoa
INSERT INTO Khoa (name) VALUES
('Cong Nghe Thong Tin'),
('Kinh Te'),
('Ky Thuat Dien');

-- Chèn dữ liệu mẫu vào bảng GiangVien
INSERT INTO GiangVien (name) VALUES
('Nguyen Van D'),
('Tran Thi E'),
('Le Van F');

-- Chèn dữ liệu mẫu vào bảng NganhDaoTao
INSERT INTO NganhDaoTao (name) VALUES
('Cong Nghe Phan Mem'),
('Kinh Te Doi Ngoai'),
('Dien Tu Vien Thong');