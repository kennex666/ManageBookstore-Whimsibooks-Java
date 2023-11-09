/*
ASUS - 07/11/2023 06:04:27 PM
*/
CREATE DATABASE QuanLyNhaSachWhimsiBooks
GO
use QuanLyNhaSachWhimsiBooks
GO
CREATE TABLE KhuyenMai (
  CodeKhuyenMai    varchar(255) NOT NULL, 
  TenKhuyenMai     varchar(255) NULL, 
  LoaiGiamGia      varchar(255) NULL, 
  GiaTri           float(10) NOT NULL, 
  NgayKhuyenMai    datetime NULL, 
  NgayHetHanKM     datetime NULL, 
  DonHangTu        float(10) NOT NULL, 
  SoLuongKhuyenMai int NOT NULL, 
  SoLuotDaApDung   int NOT NULL, 
  PRIMARY KEY (CodeKhuyenMai));
CREATE TABLE NhanVien (
  NhanVienID  varchar(255) NOT NULL, 
  UserName    varchar(255) NULL, 
  Password    varchar(255) NULL, 
  NgayTaoTK   datetime NULL, 
  HoTen       varchar(255) NULL, 
  GioiTinh    varchar(255) NULL, 
  SoDIenThoai varchar(255) NULL, 
  ChucVu      varchar(255) NULL, 
  Email       varchar(255) NULL, 
  NgaySInh    datetime NULL, 
  DiaChi      varchar(255) NULL, 
  PRIMARY KEY (NhanVienID));
CREATE TABLE NhaCungCap (
  NhaCungCapID  varchar(255) NOT NULL, 
  TenNhaCungCap varchar(255) NULL, 
  SoDIenThoai   varchar(255) NULL, 
  Email         varchar(255) NULL, 
  DiaChi        varchar(255) NULL, 
  PRIMARY KEY (NhaCungCapID));
CREATE TABLE ChiTietTraHang (
  SoLuong     int NOT NULL, 
  HoaDonID    varchar(255) NOT NULL, 
  SanPhamID   int NOT NULL, 
  DonGia      float(10) NOT NULL, 
  LiDoTrahang varchar(255) NULL);
CREATE TABLE HoaDonTra (
  HoaDonID      varchar(255) NOT NULL, 
  KhachHangID   varchar(255) NOT NULL, 
  NgayTraHoaDon datetime NULL, 
  TongHoan      float(10) NOT NULL, 
  TrangThai     varchar(255) NULL, 
  PRIMARY KEY (HoaDonID));
CREATE TABLE KhachHang (
  KhachHangID   varchar(255) NOT NULL, 
  HoTen         varchar(255) NULL, 
  SoDienThoai   varchar(255) NULL, 
  NgaySInh      datetime NULL, 
  GioiTinh      varchar(255) NULL, 
  Email         varchar(255) NULL, 
  MaSoThue      varchar(255) NULL, 
  DiaChi        varchar(255) NULL, 
  LoaiKhachHang varchar(255) NULL, 
  PRIMARY KEY (KhachHangID));
CREATE TABLE HoaDon (
  HoaDonID      varchar(255) NOT NULL, 
  CodeKhuyenMai varchar(255) NOT NULL, 
  KhachHangID   varchar(255) NOT NULL, 
  NhanVienID    varchar(255) NOT NULL, 
  NgayLapHoaDon datetime NULL, 
  TongTien      float(10) NOT NULL, 
  TrangThai     varchar(255) NULL, 
  Thue          float(10) NOT NULL, 
  GiaKhuyenMai  float(10) NOT NULL, 
  PRIMARY KEY (HoaDonID));
CREATE TABLE SanPham (
  SanPhamID    int IDENTITY NOT NULL, 
  TacGiaID     int NOT NULL, 
  TheLoaiID    int NOT NULL, 
  NhaXuatBanID int NOT NULL, 
  ThuongHieuID int NOT NULL, 
  DanhMucID    int NOT NULL, 
  NhaCungCapID varchar(255) NOT NULL, 
  TenSanPham   varchar(255) NULL, 
  NgayNhap     datetime NULL, 
  Thue         float(10) NOT NULL, 
  LoaiDoiTra   bit NOT NULL, 
  Barcode      varchar(255) NULL, 
  ImgPath      varchar(255) NULL, 
  TinhTrang    varchar(255) NULL, 
  SoLuongTon   int NOT NULL, 
  NamSanXuat   int NOT NULL, 
  LoaiSanPham  varchar(255) NULL, 
  DonViDoLuong varchar(255) NULL, 
  KichThuoc    varchar(255) NULL, 
  XuatXu       varchar(255) NULL, 
  NgonNgu      varchar(255) NULL, 
  SoTrang      int NOT NULL, 
  LoaiBia      varchar(255) NULL, 
  GiaNhap      float(10) NOT NULL, 
  PRIMARY KEY (SanPhamID));
CREATE TABLE ChiTietHoaDon (
  SoLuong   int NOT NULL, 
  HoaDonID  varchar(255) NOT NULL, 
  SanPhamID int NOT NULL, 
  DonGia    float(10) NOT NULL);
CREATE TABLE TacGia (
  TacGiaID  int IDENTITY NOT NULL, 
  TenTacGia varchar(255) NULL, 
  QuocTich  varchar(255) NULL, 
  PRIMARY KEY (TacGiaID));
CREATE TABLE TheLoai (
  TheLoaiID  int IDENTITY NOT NULL, 
  TenTheLoai varchar(255) NULL, 
  PRIMARY KEY (TheLoaiID));
CREATE TABLE DanhMuc (
  DanhMucID  int IDENTITY NOT NULL, 
  TenDanhMuc varchar(255) NULL, 
  PRIMARY KEY (DanhMucID));
CREATE TABLE ThuongHieu (
  ThuongHieuID  int IDENTITY NOT NULL, 
  TenThuongHieu varchar(255) NULL, 
  PRIMARY KEY (ThuongHieuID));
CREATE TABLE NhaXuatBan (
  NhaXuatBanID   int IDENTITY NOT NULL, 
  TenNhaXuatBan  varchar(255) NULL, 
  DiaChi         varchar(255) NULL, 
  SoDienThoai    varchar(255) NULL, 
  Email          varchar(255) NULL, 
  Website        varchar(255) NULL, 
  NamThanhLap    int NOT NULL, 
  LinhVucXuatBan varchar(255) NULL, 
  QuocGia        varchar(255) NULL, 
  PRIMARY KEY (NhaXuatBanID));
CREATE TABLE ChiTietKhuyenMai (
  NgayTao                datetime NULL, 
  SanPhamSanPhamID       int NOT NULL, 
  KhuyenMaiCodeKhuyenMai varchar(255) NOT NULL);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham819527 FOREIGN KEY (NhaCungCapID) REFERENCES NhaCungCap (NhaCungCapID);
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKChiTietHoa598636 FOREIGN KEY (SanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietTraHang ADD CONSTRAINT FKChiTietTra137106 FOREIGN KEY (SanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietTraHang ADD CONSTRAINT FKChiTietTra144876 FOREIGN KEY (HoaDonID) REFERENCES HoaDonTra (HoaDonID);
ALTER TABLE HoaDonTra ADD CONSTRAINT FKHoaDonTra619314 FOREIGN KEY (KhachHangID) REFERENCES KhachHang (KhachHangID);
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKChiTietHoa204008 FOREIGN KEY (HoaDonID) REFERENCES HoaDon (HoaDonID);
ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon185313 FOREIGN KEY (NhanVienID) REFERENCES NhanVien (NhanVienID);
ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon506668 FOREIGN KEY (KhachHangID) REFERENCES KhachHang (KhachHangID);
ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon155213 FOREIGN KEY (CodeKhuyenMai) REFERENCES KhuyenMai (CodeKhuyenMai);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham289675 FOREIGN KEY (DanhMucID) REFERENCES DanhMuc (DanhMucID);
ALTER TABLE ChiTietKhuyenMai ADD CONSTRAINT FKChiTietKhu684005 FOREIGN KEY (KhuyenMaiCodeKhuyenMai) REFERENCES KhuyenMai (CodeKhuyenMai);
ALTER TABLE ChiTietKhuyenMai ADD CONSTRAINT FKChiTietKhu322684 FOREIGN KEY (SanPhamSanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham192103 FOREIGN KEY (ThuongHieuID) REFERENCES ThuongHieu (ThuongHieuID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham842816 FOREIGN KEY (NhaXuatBanID) REFERENCES NhaXuatBan (NhaXuatBanID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham889734 FOREIGN KEY (TheLoaiID) REFERENCES TheLoai (TheLoaiID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham553584 FOREIGN KEY (TacGiaID) REFERENCES TacGia (TacGiaID);


-- Sample data for KhuyenMai table
INSERT INTO KhuyenMai (CodeKhuyenMai, TenKhuyenMai, LoaiGiamGia, GiaTri, NgayKhuyenMai, NgayHetHanKM, DonHangTu, SoLuongKhuyenMai, SoLuotDaApDung)
VALUES 
    ('KM001', 'Discount 10%', 'Percentage', 10.0, '2023-11-01', '2023-11-30', 1.0, 100, 0),
    ('KM002', 'Black Friday', 'Fixed', 50.0, '2023-11-25', '2023-11-27', 1.0, 200, 0);

-- Sample data for NhanVien table
INSERT INTO NhanVien (NhanVienID, UserName, Password, NgayTaoTK, HoTen, GioiTinh, SoDIenThoai, ChucVu, Email, NgaySInh, DiaChi)
VALUES
    ('NV0001', 'user1', 'password1', '2023-11-01', 'John Doe', 'Male', '1234567890', 'Manager', 'john.doe@example.com', '1990-01-15', '123 Main St'),
    ('NV0002', 'user2', 'password2', '2023-11-02', 'Jane Smith', 'Female', '9876543210', 'Sales Rep', 'jane.smith@example.com', '1985-05-20', '456 Elm St');

-- Sample data for NhaCungCap table
INSERT INTO NhaCungCap (NhaCungCapID, TenNhaCungCap, SoDIenThoai, Email, DiaChi)
VALUES
    ('NCC00001', 'Supplier A', '9876543210', 'supplierA@example.com', '456 Supplier Ave'),
    ('NCC00002', 'Supplier B', '1234567890', 'supplierB@example.com', '789 Vendor St');

-- Sample data for ChiTietTraHang, HoaDonTra, KhachHang tables
-- (You can continue adding more sample data for these tables as needed)


-- Sample data for TacGia table
INSERT INTO TacGia (TenTacGia, QuocTich)
VALUES
    ('Author A', 'USA'),
    ('Author B', 'UK');

-- Sample data for TheLoai table
INSERT INTO TheLoai (TenTheLoai)
VALUES
    ('Fiction'),
    ('Mystery');

-- Sample data for DanhMuc table
INSERT INTO DanhMuc (TenDanhMuc)
VALUES
    ('Category 1'),
    ('Category 2');

-- Sample data for ThuongHieu table
INSERT INTO ThuongHieu (TenThuongHieu)
VALUES
    ('Brand A'),
    ('Brand B');

-- Sample data for NhaXuatBan table
INSERT INTO NhaXuatBan (TenNhaXuatBan, DiaChi, SoDienThoai, Email, Website, NamThanhLap, LinhVucXuatBan, QuocGia)
VALUES
    ('Publisher 1', '123 Publisher St', '111-222-3333', 'publisher1@example.com', 'www.publisher1.com', 1990, 'Fiction', 'USA'),
    ('Publisher 2', '456 Publisher Ave', '444-555-6666', 'publisher2@example.com', 'www.publisher2.com', 1985, 'Mystery', 'UK');

-- Sample data for TacGia table
INSERT INTO TacGia (TenTacGia, QuocTich)
VALUES
    ('Author A', 'USA'),
    ('Author B', 'UK');

-- Sample data for TheLoai table
INSERT INTO TheLoai (TenTheLoai)
VALUES
    ('Fiction'),
    ('Mystery');

-- Sample data for ThuongHieu table
INSERT INTO ThuongHieu (TenThuongHieu)
VALUES
    ('Brand A'),
    ('Brand B');


-- Sample data for KhachHang table
INSERT INTO KhachHang (KhachHangID, HoTen, SoDienThoai, NgaySInh, GioiTinh, Email, MaSoThue, DiaChi, LoaiKhachHang)
VALUES
    ('KH0001', 'Customer 1', '111-111-1111', '1990-05-15', 'Male', 'customer1@example.com', '1234567890', '123 Customer St', 'Regular'),
    ('KH0002', 'Customer 2', '222-222-2222', '1985-10-20', 'Female', 'customer2@example.com', '9876543210', '456 Shopper Ave', 'VIP');
	

-- Sample data for SanPham table
INSERT INTO SanPham (TacGiaID, TheLoaiID, NhaXuatBanID, ThuongHieuID, DanhMucID, NhaCungCapID, TenSanPham, NgayNhap, Thue, LoaiDoiTra, Barcode, ImgPath, TinhTrang, SoLuongTon, NamSanXuat, LoaiSanPham, DonViDoLuong, KichThuoc, XuatXu, NgonNgu, SoTrang, LoaiBia, GiaNhap)
VALUES
    (1, 1, 1, 1, 1, 'NCC00001', 'Book 1', '2023-11-01', 5.0, 0, '1234567890123', 'img/book1.jpg', 'New', 100, 2023, 'Fiction', 'pcs', 'A5', 'USA', 'English', 250, 'Hardcover', 15.0),
    (2, 2, 2, 2, 2, 'NCC00002', 'Book 2', '2023-11-02', 6.0, 1, '9876543210987', 'img/book2.jpg', 'Used', 50, 2022, 'Mystery', 'pcs', 'A4', 'UK', 'English', 300, 'Paperback', 10.0);
-- Sample data for HoaDonTra table
INSERT INTO HoaDonTra (HoaDonID, KhachHangID, NgayTraHoaDon, TongHoan, TrangThai)
VALUES
    ('HDTRA001', 'KH0001', '2023-11-10', 50.0, 'Completed'),
    ('HDTRA002', 'KH0002', '2023-11-12', 75.0, 'Completed');


-- Sample data for HoaDon table
INSERT INTO HoaDon (HoaDonID, CodeKhuyenMai, KhachHangID, NhanVienID, NgayLapHoaDon, TongTien, TrangThai, Thue, GiaKhuyenMai)
VALUES
    ('HD07112301', 'KM001', 'KH0001', 'NV0001', '2023-11-05', 40.0, 'Paid', 5.0, 10.0),
    ('HD07112302', 'KM002', 'KH0002', 'NV0002', '2023-11-07', 60.0, 'Paid', 7.5, 20.0);


-- Sample data for ChiTietHoaDon table
INSERT INTO ChiTietHoaDon (SoLuong, HoaDonID, SanPhamID, DonGia)
VALUES
    (3, 'HD07112301', 1, 12.0),
    (2, 'HD07112302', 2, 15.0);
	
-- Sample data for ChiTietTraHang table
INSERT INTO ChiTietTraHang (SoLuong, HoaDonID, SanPhamID, DonGia, LiDoTrahang)
VALUES
    (2, 'HDTRA001', 1, 8.0, 'Defective product'),
    (3, 'HDTRA002', 2, 10.0, 'Wrong item delivered');
