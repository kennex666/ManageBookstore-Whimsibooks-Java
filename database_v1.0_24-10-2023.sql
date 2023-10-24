use master
CREATE DATABASE QuanLyNhaSachWhimsiBooks
GO

use QuanLyNhaSachWhimsiBooks
GO 

CREATE TABLE KhuyenMai (
  CodeKhuyenMai nvarchar(255) NOT NULL, 
  TenKhuyenMai  nvarchar(255) NULL, 
  LoaiGiamGia   nvarchar(255) NULL, 
  GiaTri        float(10) NOT NULL, 
  NgayKhuyenMai datetime NULL, 
  NgayHetHanKM  datetime NULL, 
  DonHangTu     float(10) NOT NULL, 
  PRIMARY KEY (CodeKhuyenMai));
CREATE TABLE NhanVien (
  NhanVienID  nvarchar(255) NOT NULL, 
  UserName    nvarchar(255) NULL, 
  Password    nvarchar(255) NULL, 
  NgayTaoTK   datetime NULL, 
  HoTen       nvarchar(255) NULL, 
  GioiTinh    nvarchar(255) NULL, 
  SoDIenThoai nvarchar(255) NULL, 
  ChucVu      nvarchar(255) NULL, 
  Email       nvarchar(255) NULL, 
  NgaySInh    datetime NULL, 
  DiaChi      nvarchar(255) NULL, 
  PRIMARY KEY (NhanVienID));
CREATE TABLE HangNhap (
  HangNhapID         nvarchar(255) NOT NULL, 
  NgayNhap           datetime NULL, 
  GiaTriDon          float(10) NOT NULL, 
  MaDonDat           nvarchar(255) NULL, 
  TrangthaiNhap      nvarchar(255) NULL, 
  TrangThaiThanhToan nvarchar(255) NULL, 
  PRIMARY KEY (HangNhapID));
CREATE TABLE NhaCungCap (
  NhaCungCapID       nvarchar(255) NOT NULL, 
  HangNhapHangNhapID nvarchar(255) NOT NULL, 
  TenNhaCungCap      nvarchar(255) NULL, 
  SoDIenThoai        nvarchar(255) NULL, 
  Email              nvarchar(255) NULL, 
  DiaChi             nvarchar(255) NULL, 
  PRIMARY KEY (NhaCungCapID));
CREATE TABLE ChiTietTraHang (
  HoaDonTraHoaDonID nvarchar(255) NOT NULL, 
  SanPhamSanPhamID  int NOT NULL, 
  SoLuong           int NOT NULL, 
  DonGia            float(10) NOT NULL, 
  Thue              float(10) NOT NULL, 
  LiDoTrahang       nvarchar(255) NULL, 
  PRIMARY KEY (HoaDonTraHoaDonID, 
  SanPhamSanPhamID));
CREATE TABLE HoaDonTra (
  HoaDonID             nvarchar(255) NOT NULL, 
  KhachHangKhachHangID nvarchar(255) NOT NULL, 
  NgayTraHoaDon        datetime NULL, 
  TongHoan             float(10) NOT NULL, 
  TrangThai            nvarchar(255) NULL, 
  PRIMARY KEY (HoaDonID));
CREATE TABLE KhachHang (
  KhachHangID   nvarchar(255) NOT NULL, 
  HoTen         nvarchar(255) NULL, 
  SoDienThoai   nvarchar(255) NULL, 
  NgaySInh      datetime NULL, 
  GioiTinh      nvarchar(255) NULL, 
  Email         nvarchar(255) NULL, 
  MaSoThue      nvarchar(255) NULL, 
  DiaChi        nvarchar(255) NULL, 
  LoaiKhachHang nvarchar(255) NULL, 
  PRIMARY KEY (KhachHangID));
CREATE TABLE HoaDon (
  HoaDonID               nvarchar(255) NOT NULL, 
  KhuyenMaiCodeKhuyenMai nvarchar(255) NOT NULL, 
  KhachHangKhachHangID   nvarchar(255) NOT NULL, 
  NhanVienNhanVienID     nvarchar(255) NOT NULL, 
  NgayLapHoaDon          datetime NULL, 
  TongTien               float(10) NOT NULL, 
  TienThua               float(10) NOT NULL, 
  TrangThai              nvarchar(255) NULL, 
  PRIMARY KEY (HoaDonID));
CREATE TABLE SanPham (
  SanPhamID              int IDENTITY NOT NULL, 
  TacGiaTacGiaID         int NOT NULL, 
  TheLoaiTheLoaiID       int NOT NULL, 
  NhaXuatBanNhaXuatBanID int NOT NULL, 
  ThuongHieuThuongHieuID int NOT NULL, 
  DanhMucDanhMucID       int NOT NULL, 
  NhaCungCapNhaCungCapID nvarchar(255) NOT NULL, 
  TenSanPham             nvarchar(255) NULL, 
  NgayNhap               datetime NULL, 
  DonGia                 float(10) NOT NULL, 
  Thue                   float(10) NOT NULL, 
  LoaiDoiTra             bit NOT NULL, 
  Barcode                nvarchar(255) NULL, 
  ImgPath                nvarchar(255) NULL, 
  TinhTrang              nvarchar(255) NULL, 
  SoLuongTon             int NOT NULL, 
  NamSanXuat             int  NULL, 
  LoaiSanPham            nvarchar(255) NULL, 
  DaBan                  int NOT NULL, 
  DonViDoLuong           nvarchar(255) NULL, 
  KichThuoc              nvarchar(255) NULL, 
  XuatXu                 nvarchar(255) NULL, 
  NgonNgu                nvarchar(255) NULL, 
  SoTrang                int NOT NULL, 
  LoaiBia                nvarchar(255) NULL, 
  PRIMARY KEY (SanPhamID));
CREATE TABLE ChiTietHoaDon (
  HoaDonHoaDonID   nvarchar(255) NOT NULL, 
  SanPhamSanPhamID int NOT NULL, 
  SoLuong          int NOT NULL, 
  DonGia           float(10) NOT NULL, 
  Thue             float(10) NOT NULL, 
  PRIMARY KEY (HoaDonHoaDonID, 
  SanPhamSanPhamID));
CREATE TABLE TacGia (
  TacGiaID  int IDENTITY NOT NULL, 
  TenTacGia nvarchar(255) NULL, 
  QuocTich  nvarchar(255) NULL, 
  PRIMARY KEY (TacGiaID));
CREATE TABLE TheLoai (
  TheLoaiID  int IDENTITY NOT NULL, 
  TenTheLoai nvarchar(255) NULL, 
  PRIMARY KEY (TheLoaiID));
CREATE TABLE DanhMuc (
  DanhMucID  int IDENTITY NOT NULL, 
  TenDanhMuc nvarchar(255) NULL, 
  PRIMARY KEY (DanhMucID));
CREATE TABLE ThuongHieu (
  ThuongHieuID  int IDENTITY NOT NULL, 
  TenThuongHieu nvarchar(255) NULL, 
  PRIMARY KEY (ThuongHieuID));
CREATE TABLE NhaXuatBan (
  NhaXuatBanID   int IDENTITY NOT NULL, 
  TenNhaXuatBan  nvarchar(255) NULL, 
  DiaChi         nvarchar(255) NULL, 
  SoDienThoai    nvarchar(255) NULL, 
  Email          nvarchar(255) NULL, 
  Website        nvarchar(255) NULL, 
  NamThanhLap    int NOT NULL, 
  LinhVucXuatBan nvarchar(255) NULL, 
  QuocGia        nvarchar(255) NULL, 
  PRIMARY KEY (NhaXuatBanID));
CREATE TABLE ChiTietHangNhap (
  SoLuong            int NOT NULL, 
  HangNhapHangNhapID nvarchar(255) NOT NULL, 
  SanPhamSanPhamID   int NOT NULL, 
  DonGia             float(10) NOT NULL, 
  Thue               float(10) NOT NULL, 
  ChietKhau          float(10) NOT NULL, 
  PRIMARY KEY (HangNhapHangNhapID, 
  SanPhamSanPhamID));
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham151639 FOREIGN KEY (NhaCungCapNhaCungCapID) REFERENCES NhaCungCap (NhaCungCapID);
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKChiTietHoa733233 FOREIGN KEY (SanPhamSanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietTraHang ADD CONSTRAINT FKChiTietTra194764 FOREIGN KEY (SanPhamSanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietTraHang ADD CONSTRAINT FKChiTietTra407556 FOREIGN KEY (HoaDonTraHoaDonID) REFERENCES HoaDonTra (HoaDonID);
ALTER TABLE HoaDonTra ADD CONSTRAINT FKHoaDonTra829325 FOREIGN KEY (KhachHangKhachHangID) REFERENCES KhachHang (KhachHangID);
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKChiTietHoa549264 FOREIGN KEY (HoaDonHoaDonID) REFERENCES HoaDon (HoaDonID);
ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon362329 FOREIGN KEY (NhanVienNhanVienID) REFERENCES NhanVien (NhanVienID);
ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon716679 FOREIGN KEY (KhachHangKhachHangID) REFERENCES KhachHang (KhachHangID);
ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon22941 FOREIGN KEY (KhuyenMaiCodeKhuyenMai) REFERENCES KhuyenMai (CodeKhuyenMai);
ALTER TABLE NhaCungCap ADD CONSTRAINT FKNhaCungCap928869 FOREIGN KEY (HangNhapHangNhapID) REFERENCES HangNhap (HangNhapID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham699125 FOREIGN KEY (DanhMucDanhMucID) REFERENCES DanhMuc (DanhMucID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham709205 FOREIGN KEY (ThuongHieuThuongHieuID) REFERENCES ThuongHieu (ThuongHieuID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham110030 FOREIGN KEY (NhaXuatBanNhaXuatBanID) REFERENCES NhaXuatBan (NhaXuatBanID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham709851 FOREIGN KEY (TheLoaiTheLoaiID) REFERENCES TheLoai (TheLoaiID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham269069 FOREIGN KEY (TacGiaTacGiaID) REFERENCES TacGia (TacGiaID);
ALTER TABLE ChiTietHangNhap ADD CONSTRAINT FKChiTietHan62471 FOREIGN KEY (SanPhamSanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietHangNhap ADD CONSTRAINT FKChiTietHan985801 FOREIGN KEY (HangNhapHangNhapID) REFERENCES HangNhap (HangNhapID);
