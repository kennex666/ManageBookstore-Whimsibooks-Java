/*
	Database Version 2.4 - Update 12/11/2023
	[2.2]
		Fix some issue. Fixed Boolean Entity
		Fixed display Vietnamese
		Fixed value some Table
	[2.3] Update HoaDonTra
	[2.4] Add trigger
*/
CREATE DATABASE QuanLyNhaSachWhimsiBooks
GO
use QuanLyNhaSachWhimsiBooks
GO
CREATE TABLE KhuyenMai (
  CodeKhuyenMai    nvarchar(255) NOT NULL, 
  TenKhuyenMai     nvarchar(255) NULL, 
  LoaiGiamGia      nvarchar(255) NULL, 
  GiaTri           float(10) NOT NULL, 
  NgayKhuyenMai    datetime NULL, 
  NgayHetHanKM     datetime NULL, 
  DonHangTu        float(10) NOT NULL, 
  SoLuongKhuyenMai int NOT NULL, 
  SoLuotDaApDung   int NOT NULL, 
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
CREATE TABLE NhaCungCap (
  NhaCungCapID  nvarchar(255) NOT NULL, 
  TenNhaCungCap nvarchar(255) NULL, 
  SoDIenThoai   nvarchar(255) NULL, 
  Email         nvarchar(255) NULL, 
  DiaChi        nvarchar(255) NULL, 
  PRIMARY KEY (NhaCungCapID));
CREATE TABLE ChiTietTraHang (
  SoLuong     int NOT NULL, 
  HoaDonID    nvarchar(255) NOT NULL, 
  SanPhamID   int NOT NULL, 
  DonGia      float(10) NOT NULL, 
  LiDoTrahang nvarchar(255) NULL);
CREATE TABLE HoaDonTra (
  HoaDonID      nvarchar(255) NOT NULL, 
  KhachHangID   nvarchar(255) NOT NULL, 
  NhanVienID   nvarchar(255) NOT NULL, 
  NgayTraHoaDon datetime NULL, 
  TongHoan      float(10) NOT NULL, 
  TrangThai     nvarchar(255) NULL, 
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
  HoaDonID      nvarchar(255) NOT NULL, 
  CodeKhuyenMai nvarchar(255) NOT NULL, 
  KhachHangID   nvarchar(255) NOT NULL, 
  NhanVienID    nvarchar(255) NOT NULL, 
  NgayLapHoaDon datetime NULL, 
  TongTien      float(10) NOT NULL, 
  TrangThai     nvarchar(255) NULL, 
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
  NhaCungCapID nvarchar(255) NOT NULL, 
  TenSanPham   nvarchar(255) NULL, 
  NgayNhap     datetime NULL, 
  Thue         float(10) NOT NULL, 
  LoaiDoiTra      nvarchar(255) NULL,
  Barcode      nvarchar(255) NULL, 
  ImgPath      nvarchar(255) NULL, 
  TinhTrang    nvarchar(255) NULL, 
  SoLuongTon   int NOT NULL, 
  NamSanXuat   int NOT NULL, 
  LoaiSanPham  nvarchar(255) NULL, 
  DonViDoLuong nvarchar(255) NULL, 
  KichThuoc    nvarchar(255) NULL, 
  XuatXu       nvarchar(255) NULL, 
  NgonNgu      nvarchar(255) NULL, 
  SoTrang      int NOT NULL, 
  LoaiBia      nvarchar(255) NULL, 
  GiaNhap      float(10) NOT NULL, 
  PRIMARY KEY (SanPhamID));
CREATE TABLE ChiTietHoaDon (
  SoLuong   int NOT NULL, 
  HoaDonID  nvarchar(255) NOT NULL, 
  SanPhamID int NOT NULL, 
  DonGia    float(10) NOT NULL);
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
CREATE TABLE ChiTietKhuyenMai (
  NgayTao                datetime NULL, 
  SanPhamSanPhamID       int NOT NULL, 
  KhuyenMaiCodeKhuyenMai nvarchar(255) NOT NULL);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham819527 FOREIGN KEY (NhaCungCapID) REFERENCES NhaCungCap (NhaCungCapID);
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKChiTietHoa598636 FOREIGN KEY (SanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietTraHang ADD CONSTRAINT FKChiTietTra137106 FOREIGN KEY (SanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE ChiTietTraHang ADD CONSTRAINT FKChiTietTra144876 FOREIGN KEY (HoaDonID) REFERENCES HoaDonTra (HoaDonID);
ALTER TABLE HoaDonTra ADD CONSTRAINT FKHoaDonTra123873 FOREIGN KEY (NhanVienID) REFERENCES NhanVien (NhanVienID);
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
    ('NO_APPLY', 'Không áp dụng', 'PHAN_TRAM', 0, '2023-11-01', '2023-11-30', 1.0, 100, 0),
    ('KM0001', 'Discount 10%', 'Percentage', 10.0, '2023-11-01', '2023-11-30', 1.0, 100, 0),
    ('KM0002', 'Black Friday', 'Fixed', 50.0, '2023-11-25', '2023-11-27', 1.0, 200, 0);

-- Sample data for NhanVien table
INSERT INTO NhanVien (NhanVienID, UserName, Password, NgayTaoTK, HoTen, GioiTinh, SoDIenThoai, ChucVu, Email, NgaySInh, DiaChi)
VALUES
    ('NV0001', 'nhanvien01', '123456', '2023-11-01', N'Dương Thái Bảo', 'Male', '1234567890', 'Manager', 'john.doe@example.com', '1990-01-15', '123 Main St'),
    ('NV0002', 'user2', 'password2', '2023-11-02', N'Nguyễn Lê Nhật Huy', 'Female', '9876543210', 'Sales Rep', 'jane.smith@example.com', '1985-05-20', '456 Elm St');

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

-- Sample data for NhaXuatBan table
INSERT INTO NhaXuatBan (TenNhaXuatBan, DiaChi, SoDienThoai, Email, Website, NamThanhLap, LinhVucXuatBan, QuocGia)
VALUES
    ('Publisher 1', '123 Publisher St', '111-222-3333', 'publisher1@example.com', 'www.publisher1.com', 1990, 'Fiction', 'USA'),
    ('Publisher 2', '456 Publisher Ave', '444-555-6666', 'publisher2@example.com', 'www.publisher2.com', 1985, 'Mystery', 'UK');

-- Sample data for ThuongHieu table
INSERT INTO ThuongHieu (TenThuongHieu)
VALUES
    ('Brand A'),
    ('Brand B');


-- Sample data for KhachHang table
INSERT INTO KhachHang (KhachHangID, HoTen, SoDienThoai, NgaySInh, GioiTinh, Email, MaSoThue, DiaChi, LoaiKhachHang)
VALUES
    ('KH0001', N'Nguyễn Thành Luân', '111-111-1111', '1990-05-15', 'Male', 'customer1@example.com', '1234567890', '123 Customer St', 'DOANH_NGHIEP'),
    ('KH0002', N'Chu Công Quý', '222-222-2222', '1985-10-20', 'Female', 'customer2@example.com', '9876543210', '456 Shopper Ave', 'CA_NHAN');
	

-- Sample data for SanPham table
INSERT INTO SanPham (TacGiaID, TheLoaiID, NhaXuatBanID, ThuongHieuID, DanhMucID, NhaCungCapID, TenSanPham, NgayNhap, Thue, LoaiDoiTra, Barcode, ImgPath, TinhTrang, SoLuongTon, NamSanXuat, LoaiSanPham, DonViDoLuong, KichThuoc, XuatXu, NgonNgu, SoTrang, LoaiBia, GiaNhap)
VALUES
    (1, 1, 1, 1, 1, 'NCC00001', N'Vì tôi yêu cậu', '2023-11-01', 8.0, 'KHONG_DOI_TRA', '123456789', 'img/book1.jpg', 'New', 100, 2023, 'Fiction', 'pcs', 'A5', 'USA', 'English', 250, 'Hardcover', 150000),
    (2, 2, 2, 2, 2, 'NCC00002', N'Phải lòng với cô đơn', '2023-11-02', 10.0, 'DUOC_DOI_TRA', '9876543210987', 'img/book2.jpg', 'Used', 50, 2022, 'Mystery', 'pcs', 'A4', 'UK', 'English', 300, 'Paperback', 80000);
-- Sample data for HoaDonTra table
INSERT INTO HoaDonTra (HoaDonID, KhachHangID, NhanVienID, NgayTraHoaDon, TongHoan, TrangThai)
VALUES
    ('HD04112301', 'KH0001', 'NV0002','2023-11-04', 100000, 'DA_XU_LY'),
    ('HD04112302', 'KH0002', 'NV0001','2023-11-04', 80000, 'DA_XU_LY');


-- Sample data for HoaDon table
INSERT INTO HoaDon (HoaDonID, CodeKhuyenMai, KhachHangID, NhanVienID, NgayLapHoaDon, TongTien, TrangThai, Thue, GiaKhuyenMai)
VALUES
   ('HD04112301', 'NO_APPLY', 'KH0001', 'NV0001', '2023-11-04', 100000, 'DA_XU_LY', 10000, 0),
   ('HD04112302', 'NO_APPLY', 'KH0002', 'NV0002', '2023-11-04', 80000, 'HUY_BO', 8000, 0),
   ('HD07112301', 'NO_APPLY', 'KH0001', 'NV0001', '2023-11-07', 100000, 'CHO_XU_LY', 10000, 0),
   ('HD07112302', 'NO_APPLY', 'KH0002', 'NV0002', '2023-11-07', 80000, 'DA_XU_LY', 8000, 0);


 --Sample data for ChiTietHoaDon table
INSERT INTO ChiTietHoaDon (SoLuong, HoaDonID, SanPhamID, DonGia)
VALUES
	(8, 'HD04112301', 1, 100000),
   (4, 'HD04112302', 1, 100000),
   (4, 'HD04112302', 2, 80000),
   (19, 'HD07112301', 1, 100000),
   (14, 'HD07112302', 2, 80000);
	
-- Sample data for ChiTietTraHang table
INSERT INTO ChiTietTraHang (SoLuong, HoaDonID, SanPhamID, DonGia, LiDoTrahang)
VALUES
    (1, 'HD04112301', 1, 100000, 'Defective product'),
    (1, 'HD04112302', 2, 80000, 'Wrong item delivered');



-- SCRIPT BY BẢO
GO

--- Trigger kích hoạt khi cập nhật hoá đơn
--CREATE TRIGGER trg_SuaHoaDon
--ON HoaDon
--AFTER UPDATE
--AS BEGIN

--	declare @HoaDonID AS nvarchar(255), @TrangThai AS nvarchar(255)
--	declare @SanPhamID AS nvarchar(255), @SoLuong AS INT
	
--	SET @HoaDonID = (SELECT HoaDonID FROM inserted)
--	SET @TrangThai = (SELECT TrangThai FROM inserted)
		
--	IF @TrangThai <> 'HUY_BO'
--		BEGIN
--			RETURN
--		END

--	DECLARE chitietcapnhat CURSOR FOR (SELECT SanPhamID, SoLuong FROM ChiTietHoaDon WHERE HoaDonID = @HoaDonID)
--	OPEN chitietcapnhat;  
--	FETCH NEXT FROM chitietcapnhat  
--	INTO @SanPhamID, @SoLuong
--	WHILE @@FETCH_STATUS = 0  
--	BEGIN
--		UPDATE SanPham SET SoLuongTon += @SoLuong WHERE SanPhamID = @SanPhamID
--		FETCH NEXT FROM chitietcapnhat  
--		INTO @SanPhamID, @SoLuong
--	END
--	CLOSE chitietcapnhat;  
--	DEALLOCATE chitietcapnhat;
--END
--GO



--- Trigger kích hoạt khi thêm chi tiết hoá đơn
CREATE TRIGGER trg_ThemChiTietHoaDon
ON ChiTietHoaDon
AFTER INSERT
AS BEGIN	
	declare @SanPhamID AS nvarchar(255), @SoLuongLayDi AS int
	SET @SanPhamID = (SELECT SanPhamID FROM inserted)
	SET @SoLuongLayDi = (SELECT SoLuong FROM inserted)
	IF 'HUY_BO' = (SELECT TrangThai FROM HoaDon WHERE HoaDonID =  (SELECT HoaDonID FROM inserted))
	BEGIN
		RETURN
	END
	UPDATE SanPham SET SoLuongTon = SoLuongTon - @SoLuongLayDi
	WHERE @SanPhamID = SanPhamID
END
GO

--- Trigger kích hoạt khi sửa chi tiết hoá đơn
CREATE TRIGGER trg_SuaChiTietHoaDon
ON ChiTietHoaDon
AFTER UPDATE
AS BEGIN	
	declare @SanPhamIDTra AS nvarchar(255), @SanPhamIDLay AS nvarchar(255), @SoLuongLayDi AS int, @SoLuongTraLai AS int
	SET @SanPhamIDLay = (SELECT SanPhamID FROM inserted)
	SET @SanPhamIDTra = (SELECT SanPhamID FROM deleted)
	SET @SoLuongTraLai = (SELECT SoLuong FROM deleted)
	SET @SoLuongLayDi = (SELECT SoLuong FROM inserted)
	IF 'HUY_BO' = (SELECT TrangThai FROM HoaDon WHERE HoaDonID =  (SELECT HoaDonID FROM inserted))
	BEGIN
		RETURN
	END
	UPDATE SanPham SET SoLuongTon = SoLuongTon - @SoLuongLayDi
	WHERE @SanPhamIDLay = SanPhamID
	UPDATE SanPham SET SoLuongTon = SoLuongTon + @SoLuongTraLai
	WHERE @SanPhamIDTra = SanPhamID
END
GO
--- Trigger kích hoạt khi xoá chi tiết hoá đơn
CREATE TRIGGER trg_XoaChiTietHoaDon
ON ChiTietHoaDon
AFTER DELETE
AS BEGIN	
	declare @SanPhamID AS nvarchar(255), @SoLuongTraLai AS int
	SET @SanPhamID = (SELECT SanPhamID FROM deleted)
	SET @SoLuongTraLai = (SELECT SoLuong FROM deleted)
	UPDATE SanPham SET SoLuongTon = SoLuongTon + @SoLuongTraLai
	WHERE @SanPhamID = SanPhamID
END
GO

--- Trigger kích hoạt khi thêm chi tiết trả hoá đơn
CREATE TRIGGER trg_ThemChiTietTraHang
ON ChiTietTraHang
AFTER INSERT
AS BEGIN	
	declare @SanPhamID AS nvarchar(255), @SoLuongTraLai AS int
	SET @SanPhamID = (SELECT SanPhamID FROM inserted)
	SET @SoLuongTraLai = (SELECT SoLuong FROM inserted)
	UPDATE SanPham SET SoLuongTon = SoLuongTon + @SoLuongTraLai
	WHERE @SanPhamID = SanPhamID
END
GO


--- Trigger kích hoạt khi xoá chi tiết trả hoá đơn
CREATE TRIGGER trg_XoaChiTietTraHang
ON ChiTietTraHang
AFTER INSERT
AS BEGIN	
	declare @SanPhamID AS nvarchar(255), @SoLuongTraLai AS int
	SET @SanPhamID = (SELECT SanPhamID FROM deleted)
	SET @SoLuongTraLai = (SELECT SoLuong FROM deleted)
	UPDATE SanPham SET SoLuongTon = SoLuongTon - @SoLuongTraLai
	WHERE @SanPhamID = SanPhamID
END
GO