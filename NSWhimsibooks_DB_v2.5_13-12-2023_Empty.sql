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
  SanPhamID       int NOT NULL, 
  CodeKhuyenMai nvarchar(255) NOT NULL);
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
ALTER TABLE ChiTietKhuyenMai ADD CONSTRAINT FKChiTietKhu684005 FOREIGN KEY (CodeKhuyenMai) REFERENCES KhuyenMai (CodeKhuyenMai);
ALTER TABLE ChiTietKhuyenMai ADD CONSTRAINT FKChiTietKhu322684 FOREIGN KEY (SanPhamID) REFERENCES SanPham (SanPhamID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham192103 FOREIGN KEY (ThuongHieuID) REFERENCES ThuongHieu (ThuongHieuID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham842816 FOREIGN KEY (NhaXuatBanID) REFERENCES NhaXuatBan (NhaXuatBanID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham889734 FOREIGN KEY (TheLoaiID) REFERENCES TheLoai (TheLoaiID);
ALTER TABLE SanPham ADD CONSTRAINT FKSanPham553584 FOREIGN KEY (TacGiaID) REFERENCES TacGia (TacGiaID);

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
	IF 'DA_XU_LY' = (SELECT TrangThai FROM HoaDon WHERE HoaDonID =  (SELECT HoaDonID FROM inserted))
	BEGIN
		UPDATE SanPham SET SoLuongTon = SoLuongTon - @SoLuongLayDi
		WHERE @SanPhamID = SanPhamID
	END
END
GO

--- Trigger kích hoạt khi sửa chi tiết hoá đơn
--CREATE TRIGGER trg_SuaChiTietHoaDon
--ON ChiTietHoaDon
--AFTER UPDATE
--AS BEGIN	
--	declare @SanPhamIDTra AS nvarchar(255), @SanPhamIDLay AS nvarchar(255), @SoLuongLayDi AS int, @SoLuongTraLai AS int
--	SET @SanPhamIDLay = (SELECT SanPhamID FROM inserted)
--	SET @SanPhamIDTra = (SELECT SanPhamID FROM deleted)
--	SET @SoLuongTraLai = (SELECT SoLuong FROM deleted)
--	SET @SoLuongLayDi = (SELECT SoLuong FROM inserted)
--	IF 'HUY_BO' = (SELECT TrangThai FROM HoaDon WHERE HoaDonID =  (SELECT HoaDonID FROM inserted))
--	BEGIN
--		RETURN
--	END
--	UPDATE SanPham SET SoLuongTon = SoLuongTon - @SoLuongLayDi
--	WHERE @SanPhamIDLay = SanPhamID
--	UPDATE SanPham SET SoLuongTon = SoLuongTon + @SoLuongTraLai
--	WHERE @SanPhamIDTra = SanPhamID
--END
--GO
--- Trigger kích hoạt khi xoá chi tiết hoá đơn
--CREATE TRIGGER trg_XoaChiTietHoaDon
--ON ChiTietHoaDon
--AFTER DELETE
--AS BEGIN	
--	declare @SanPhamID AS nvarchar(255), @SoLuongTraLai AS int
--	SET @SanPhamID = (SELECT SanPhamID FROM deleted)
--	SET @SoLuongTraLai = (SELECT SoLuong FROM deleted)
--	UPDATE SanPham SET SoLuongTon = SoLuongTon + @SoLuongTraLai
--	WHERE @SanPhamID = SanPhamID
--END
--GO

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
--CREATE TRIGGER trg_XoaChiTietTraHang
--ON ChiTietTraHang
--AFTER INSERT
--AS BEGIN	
--	declare @SanPhamID AS nvarchar(255), @SoLuongTraLai AS int
--	SET @SanPhamID = (SELECT SanPhamID FROM deleted)
--	SET @SoLuongTraLai = (SELECT SoLuong FROM deleted)
--	UPDATE SanPham SET SoLuongTon = SoLuongTon - @SoLuongTraLai
--	WHERE @SanPhamID = SanPhamID
--END
--GO


-- DATA

INSERT INTO KhachHang (KhachHangID, HoTen, SoDienThoai, NgaySInh, GioiTinh, Email, MaSoThue, DiaChi, LoaiKhachHang)
VALUES
    ('KH0001', N'Khách lẻ', '0000', '1990-05-15', 'NAM', '', '', '', 'DOANH_NGHIEP'),
    ('KH0002', N'Nguyễn Thành Luân', '0123456789', '1990-05-15', 'NAM', 'customer1@example.com', '1234567890', '123 Customer St', 'DOANH_NGHIEP'),
    ('KH0003', N'Chu Công Quý', '0123456788', '1985-10-20', 'NAM', 'customer2@example.com', '9876543210', '456 Shopper Ave', 'CA_NHAN'), 
    ('KH0004', N'Dương Thái Bảo', '0123456777', '1985-10-20', 'NAM', 'customer3@example.com', '', '', 'CA_NHAN');
	

-- THUONG HIEU
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Hồng Hạnh Books')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Kim Yên Cung cấp')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Luân Providers')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Công ty Một mình tôi')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Công ty Họ nhà Báo')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Công ty Si mê')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Công ty Học chăm')
INSERT [dbo].[ThuongHieu] ([TenThuongHieu]) VALUES (N'Nhà cung cấp Hồng')

-- TÁC GIẢ
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Nguyễn Nhựt Ánh', N'Việt Nam')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Rosie Nguyễn', N'Việt Nam')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Rani Shah', N'Việt Nam')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Bảo Dương', N'Địa Ngục')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Huy Nguyễn', N'Việt Nam')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Kennex', N'USK')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Mai Rồi Viết', N'Japan')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Người Ẩn Danh', N'KOREA')
INSERT [dbo].[TacGia] ([TenTacGia], [QuocTich]) VALUES (N'Ngủ và Viết', N'Việt Nam')
--- DANH MỤC
INSERT INTO DanhMuc (TenDanhMuc)
VALUES
    (N'Danh mục 1'),
   (N'Danh mục 2'),
   (N'Danh mục 3'),
   (N'Danh mục 4'),
   (N'Danh mục 5'),
   (N'Danh mục 6'),
   (N'Danh mục 7'),
   (N'Danh mục 8');
	
-- Thể loại
-- Sample data for TheLoai table
INSERT INTO TheLoai (TenTheLoai)
VALUES
   (N'Thể loại 1'),
   (N'Thể loại 2'),
   (N'Thể loại 3'),
   (N'Thể loại 4'),
   (N'Thể loại 5'),
   (N'Thể loại 6'),
   (N'Thể loại 7'),
   (N'Thể loại 8'),
   (N'Thể loại 9'),
   (N'Thể loại 10');
	
-- Nhà xuất bản
-- Sample data for NhaXuatBan table
INSERT INTO NhaXuatBan (TenNhaXuatBan, DiaChi, SoDienThoai, Email, Website, NamThanhLap, LinhVucXuatBan, QuocGia)
VALUES
    ('Publisher 1', '123 Publisher St', '111-222-3333', 'publisher1@example.com', 'www.publisher1.com', 1990, 'Fiction', 'USA'),
    ('Publisher 2', '456 Publisher Ave', '444-555-6666', 'publisher2@example.com', 'www.publisher2.com', 1985, 'Mystery', 'UK');



--- NHÀ CUNG CẤP
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00001', N'Công Ty Cổ Phần Phát Hành Sách Tp. HCM', N'02838225798', N'fahasa-sg@hcm.vnn.vn', N'60-62 Lê Lợi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00002', N'Trí Tuệ - Công Ty Cổ Phần Sách & Thiết Bị Giáo Dục Trí Tuệ', N'02438515567', N'kinhdoanh@nhasachtritue.com', N'187 Giảng Võ, Q. Đống Đa, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00003', N'Công Ty TNHH Văn Hóa Việt Long', N'02838452708', N'info@vietlonbook.com', N'14/35, Đào Duy Anh, P.9, Q. Phú Nhuận, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00004', N'Công Ty Cổ Phần Sách Mcbooks', N'0986066630', N'thongtinsach@mcbooks.vn', N'Lô 34E, Khu Đấu Giá 3ha, P. Phúc Diễm, Q. Bắc Từ Liêm, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00005', N'Nhà Sách Trực Tuyến BOOKBUY.VN', N'02838207153', N'info@bookbuy.vn', N'147 Pasteur, P. 6, Q. 3, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00006', N'Công Ty TNHH Đăng Nguyên', N'02543716857', N'vudinh200574@yahoo.com', N'Thôn Đức Mỹ, X. Suối Nghệ, H. Châu Đức, Bà Rịa-Vũng Tàu')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00007', N'Công Ty Cổ Phần Sách Giáo Dục Tại Thành Phố Hà Nội', N'02462534308', N'hongtran27979@gmail.com', N'Công Ty Cổ Phần Sách Giáo Dục Tại Thành Phố Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00008', N'DaNaBook - Công Ty Cổ Phần Sách & Thiết Bị Trường Học Đà Nẵng', N'02363821009', N'danabook@gmail.com', N'78 Bạch Đằng, Q. Hải Châu, Tp. Đà Nẵng')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00009', N'Công Ty Cổ Phần Sách & Thiết Bị Trường Học Kiên Giang', N'02973862125', N'donghobooks@gmail.com', N'Lô E16, Số 30, 31, 32 Đường 3 Tháng 2, P. Vĩnh Lạc, TP Rạch Giá, Kiên Giang')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00010', N'Công Ty CP Sách Và Thiết Bị Trường Học Đà Nẵng', N'02363821133', N'doanhongtien@gmail.com', N'76-78 Bạch Đằng, Q. Hải Châu, Tp. Đà Nẵng')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00011', N' Công Ty Cổ Phần Dịch Vụ Xuất Bản Giáo Dục Hà Nội', N'02435121977', N'info@xbgdhn.vn', N'Tầng 4 Tòa Nhà Diamond Flower Tower 48 Lê Văn Lương, P. Nhân Chính, Q. Thanh Xuân Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00012', N'Nhà Sách Trực Tuyến Atlazbooks', N'02485857659', N'info@atlazbooks.com', N'Tầng 5, Số 23 Hoàng Văn Thái, P. Khương Mai, Q. Thanh Xuân, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00013', N'Quỳnh Phát - Công Ty TNHH Thương Mại Dịch Vụ Quỳnh Phát', N'02838612167', N'quynhphatbook@yahoo.com', N'232 Trần Thủ Độ, P. Phú Thạnh, Q. Tân Phú, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00014', N'Nhà Sách Nguyễn Du', N'02543533399', N'sales@nguyendubook.com', N'17C Nam Kỳ Khởi Nghĩa, P.3, Tp. Vũng Tàu, Bà Rịa-Vũng Tàu')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00015', N'Nhà Sách Bích Quân', N'0944566788', N'sachsichauhaiphong@gmail.com', N'249 Lý Thường Kiệt, KP. Thống Nhất 1, Dĩ An, Bình Dương')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00016', N'Công Ty Cổ Phần Phát Hành Sách Khánh Hòa', N'02583822120', N'sachsichaukhanhhoa@gmail.com', N'34-36 Thống Nhất, Tp. Nha Trang, Khánh Hòa')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00017', N'Công Ty Cổ Phần Sách - Thiết Bị Trường Học Đắk Lắk', N'02623950306', N'sachtbthdaklak@gmail.com', N'19 Trường Chinh, P. Tân Lợi, Tp. Buôn Ma Thuột, Đắk Lắk')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00018', N'Công Ty Cổ Phần Sách Và Thiết Bị Đồng Tháp', N'02773861802', N'sachthietbidt@gmail.com', N'Nguyễn Sinh Sắc, P. 2, TP. Sa Đéc, Đồng Tháp')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00019', N' Công Ty TNHH Đầu Tư Và Phát Triển Kiwi', N'0906302311', N'tuanpatc@gmail.com', N'Số 19 Lê Quý Đôn, P. Đồng Mỹ, TP. Đồng Hới, Quảng Bình')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00020', N'Công Ty Cổ Phần Sách Và Thiết Bị Trường Học Trà Vinh', N'02943862278', N'stbthtravinh@yahoo.com.vn', N'3A Trưng Nữ Vương, P. 1, TP. Trà Vinh, Trà Vinh')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00021', N'Công Ty TNHH Thiết Bị Kiên Huy Anh', N'02973876688', N'nhasachkienhuy@gmail.com', N'884B Nguyễn Trung Trực, Tp. Rạch Giá, Kiên Giang')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00022', N' Nhà Sách Tài Chính', N'0931307898', N'dinhphuongnam102@gmail.com', N'TL 37 Thạnh Lộc, Q. 12, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00023', N'Công Ty Cổ Phần Sách Và Thiết Bị Trường Học Long An', N'02723822374', N'stbthla@yahoo.com.vn', N'39 Hai Bà Trưng, P. 1, TP. Tân An, Long An')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00024', N'Công Ty Cổ Phần Truyền Thông Và Xuất Bản Amak', N'02462559966', N'info@amak.vn', N'Tầng 2, Số 46 Tân ấp, P. Phúc Xá, Q. Ba Đình, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00025', N'Công Ty Cổ Phần Sách - Thiết Bị Vĩnh Long', N'02703822373', N'sachthietbivinhlong@gmail.com', N'23 Lê Văn Tám,P. 1, TX. Vĩnh Long, Vĩnh Long')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00026', N' Công Ty Cổ Phần Sách & Thiết Bị Trường Học', N'02223821614', N'congtysachbn@gmail.com', N'Số 14, Nguyễn Đăng Đạo, Tp. Bắc Ninh, Bắc Ninh')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00027', N'Công Ty Cổ Phần Sách Thiết Bị Trường Học Thành Phố Cần Thơ', N'02923822106', N'stbcantho@gmail.com', N'179B/7, Võ Văn Kiệt, P. Long Hòa, Q. Bình Thủy, Tp. Cần Thơ')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00028', N' Nhà Sách Nguyệt Linh', N'02438252394', N'nguyetlinhbook@gmail.com', N'Gác 2, Số 5 Đinh Lễ, Phường Tràng Tiền, Quận Hoàn Kiếm, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00029', N'Nhà Sách Ngoại Văn BOA', N'0909892312', N'boa.bookstore@gmail.com', N'Phòng C26, Lầu 2, 42 Trần Cao Vân, Q.3 (Hồ Con Rùa), Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00030', N'Công Ty TNHH MTV Sách - Thiết Bị & Xây Dựng Trường Học Hà Nội', N'02439361052', N'rat.bookstore@gmail.com', N'45B Lý Thường Kiệt, Q. Hoàn Kiếm, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00031', N'Công Ty Cổ Phần Sách - Thiết Bị Bến Tre', N'02753822389', N'stbbtvn@yahoo.com', N'450E Ấp Hữu Nhơn, X. Hữu Định, Q. Châu Thành, Bến Tre')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00032', N'Công Ty TNHH Thương Mại Và Dịch Vụ Sách Gia Định', N'02873036803', N'giadinhbook@gmail.com', N'6/20A Lê Đức Thọ, P. 16, Q. Gò Vấp, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00033', N'Công Ty Cổ Phần Sách Và Thiết Bị Sóc Trăng', N'02993820093', N'sachsoctrang@gmail.com', N'47 Lê Duẩn, P. 3, Tp. Sóc Trăng, Sóc Trăng')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00034', N'Nhà Sách An Dương Vương', N'02838351939', N'thachnguyen2711@gmail.com', N'87/1 Trần Phú, P. 4, Q. 5, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00035', N'Doanh Nghiệp Tư Nhân In Ấn Nhật Đăng', N'02963842835', N'loind2015@yahoo.com', N'291/6 Hùng Vương , P. Mỹ Long, TP. Long Xuyên, An Giang')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00036', N'Công Ty Cổ Phần Sách Thiết Bị Cà Mau', N'02903831859', N'ctcpstbcamau@gmail.com', N'26-28 Lê Lợi, P. 2, Tp. Cà Mau, Cà Mau')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00037', N'Công Ty Cổ Phần Văn Hóa Nhân Văn', N'02836007777', N'sieuthisachnhanvan@gmail.com', N'1 Trường Chinh, P. 1, Q. Tân Bình, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00038', N' Công Ty CP Sách & Thiết Bị Trường Học Quảng Ninh', N'02033825130', N'congtysach.soquangninh@gmail.com', N'10 Long Tiên, Tp. Hạ Long, Quảng Ninh')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00039', N' Công Ty Cổ Phần Sách Và Thiết Bị Trường Học Thành Phố Hồ Chí Minh', N'02838554645', N'lienhe@stb.com.vn', N'223 Nguyễn Tri Phương, P. 9, Q. 5, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00040', N'Hiệu Sách Tiến Thành', N'0919196677', N'kimlong240988@gmail.com', N'Số 11-13 Đường 53, P. 10, Q. 6, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00041', N' Nhà Sách Quyết Bình', N'02835561920', N'tbgd_thanhkien@yahoo.com', N'55/5 Bình Quới, P. 28, Q. Bình Thạnh, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00042', N' Công Ty Cổ Phần Sách & Dịch Vụ Văn Hóa Bình Thuận', N'02523827545', N'sachvhbt@hcm.vnn.vn', N'284 Trần Hưng Đạo, Tp. Phan Thiết, Bình Thuận')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00043', N'Nhà Sách 19', N'02838243913', N'thienvuongcp@yahoo.com', N'64B Nguyễn Thị Minh Khai, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00044', N'Công Ty Truyền Thông Rubby Media', N'02462911322', N'info@thuvientructuyen.vn', N'183 Hoàng Văn Thái, Thanh Xuân, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00045', N'Công Ty TNHH Thương Mại Và Dịch Vụ Sách Gia Định', N'02173036803', N'giadinhboo2k@gmail.com', N'6/20A Lê Đức Thọ, P. 16, Q. Gò Vấp, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00046', N' Nhà Sách Online Sgbook.Net', N'0916574202', N'sgbook.net@sgbook.net', N'265/79 Nguyễn Thái Sơn, P. 7, Q. Gò Vấp, Tp. Hồ Chí Minh (TPHCM)')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00047', N'Công Ty TNHH MTV Sách - Thiết Bị & Xây Dựng Trường Học Hà Nội', N'02139361052', N'sgbook.com@sgbook.net', N'45B Lý Thường Kiệt, Q. Hoàn Kiếm, Hà Nội')
INSERT [dbo].[NhaCungCap] ([NhaCungCapID], [TenNhaCungCap], [SoDIenThoai], [Email], [DiaChi]) VALUES (N'NCC00048', N'Nhà Sách Thanh Niên Quy Nhơn', N'02563818295', N'tonthatkhuyet@gmail.com', N'339-341 Đường Trần Hưng Đạo, Bình Định')
GO



-- SẢN PHẨM


INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 1, 1, N'NCC00001', N'Mắt biếc', CAST(N'2023-11-01T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8933456123456', N'img\products\MatBiec.jpg', N'CON_HANG', 151, 2023, N'SACH', N'pcs', N'A5', N'USA', N'English', 250, N'Hardcover', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 2, 1, 1, 2, N'NCC00002', N'BatMan', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 4, N'DUOC_DOI_TRA', N'8936789012345', N'img\products\BatMan.png', N'CON_HANG', 150, 2022, N'SACH', N'pcs', N'A4', N'UK', N'English', 300, N'Paperback', 70)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 1, 2, 1, 1, N'NCC00001', N'Bí ẩn là mãi mãi', CAST(N'2023-11-17T00:00:00.000' AS DateTime), 4, N'DUOC_DOI_TRA', N'8939876543210', N'img\products\BiAnLaMaiMai.png', N'NGUNG_KINH_DOANH', 2, 2003, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 100, N'Hardcover', 35)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Bí ẩnn đảo lớn', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8939876543212', N'img\products\BiAnDaoLon.png', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 230, N'Paperback', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 1, 1, N'NCC00001', N'Ngồi khóc trên cây', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8938765432198', N'img\products\Cryingintrees.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 127, N'Paperback', 40)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Đắc Nhân Tâm', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8937654321987', N'img\products\DacNhanTam.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 238, N'Paperback', 40)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 5, 1, 1, 1, 1, N'NCC00001', N'Làm bạn với bầu trời', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8936543219876', N'img\products\LamBanVoiBauTroi.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 100, N'Paperback', 40)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 1, 1, 1, 1, N'NCC00001', N'Mình nói gì với hạnh phúc', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8935432198765', N'img\products\MinhNoiGiVeHanhPhuc.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 30, N'Paperback', 40)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 1, 1, 1, 1, N'NCC00001', N'Những chồi non hy vọng', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8934321987654', N'img\products\NhungChoiNonHyVong.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 100, N'Paperback', 40)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 3, 1, 1, 1, 1, N'NCC00002', N'Triết lý từ những điều tầm thường', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8933219876543', N'img\products\TrietLyTuNhungDieuTamThuong.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 98, N'Paperback', 36)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Tin học', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8931111222233', N'img\products\TinHoc.png', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 201, N'Paperback', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00002', N'Tin học 3', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8934444555566', N'img\products\TinHoc3.png', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 100, N'Paperback', 110)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Tuổi trẻ đáng giá bao nhiêu', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8937777888899', N'img\products\TuoiTreDangGiaBaoNhieu.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 200, N'Paperback', 220)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00002', N'Vừa nhắm mắt vừa mở cửa s?', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8931234567890', N'img\products\VuaNhamMatVuaMoCuaSo.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A4', N'Việt Nam', N'VietNamese', 200, N'Paperback', 110)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Chị sáu ở côn đảo', CAST(N'2023-11-01T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8932345678901', N'img\products\ChiSauOConDao.jpg', N'CON_HANG', 101, 2023, N'SACH', N'pcs', N'A5', N'USA', N'English', 250, N'Hardcover', 30)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 2, 1, 1, 2, N'NCC00002', N'Ngộ quá cái gì cũng hóa', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 6, N'DUOC_DOI_TRA', N'8933456789012', N'img\products\NgoQuaCaiGiCungHoa.jpg', N'NGUNG_KINH_DOANH', 50, 2022, N'SACH', N'pcs', N'A4', N'UK', N'English', 300, N'Paperback', 10)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 1, 1, 1, 1, N'NCC00001', N'Những đứa trẻ hiểu chuyện thường không có kẹo ăn', CAST(N'2023-11-17T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8934567890123', N'img\products\NhungDuaTreHieuChuyenThuongKhongCoKeoAn.jpg', N'CON_HANG', 2, 2003, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 200, N'Hardcover', 110)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Dế mèn phiêu lưu ký', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8935678901234', N'img\products\DeMenPhieuLuuKy.jpg', N'CON_HANG', 17, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 110, N'Hardcover', 110)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 1, 1, N'NCC00001', N'Ông già và biển cả', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8936789012345', N'img\products\OngGiaVaBienCa.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 220, N'Hardcover', 70)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Toán không hề ngán', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8937890123456', N'img\products\ToanKhongHeNgan.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 138, N'Hardcover', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 5, 1, 1, 1, 1, N'NCC00001', N'Như sao trời ôm lấy đại dương', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8938901234567', N'img\products\NhuSaoTroiOmLayDaiDuong.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 280, N'Hardcover', 40)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 1, 1, 1, 1, N'NCC00001', N'Sự im lặng của bầy cừu', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8939012345678', N'img\products\SuImLangCuaBayCuu.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 210, N'Hardcover', 55)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 1, 1, 1, 1, N'NCC00001', N'Truyện ngắn Nguyên Hồng', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8931122334455', N'img\products\TruyenNganNguyenHong.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 210, N'Hardcover', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 3, 1, 1, 1, 1, N'NCC00002', N'Đồ thị và các thuật toán', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8932233445566', N'img\products\DoThiVaCacThuatToan.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 200, N'Hardcover', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Tư duy thuật toán', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8933344556677', N'img\products\TuDuyThuatToan.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 280, N'Paperback', 201)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00002', N'Ngữ pháp Tiếng Anh', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8934455667788', N'img\products\NguPhapTiengAnh.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 120, N'Paperback', 120)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Bài tập ngữ pháp Tiếng Pháp', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8935566778899', N'img\products\BaiTapNguPhapTiengPhap.jpg', N'CON_HANG', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 300, N'Paperback', 120)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00002', N'Nhà giả kim', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 1, N'KHONG_DOI_TRA', N'8936677889900', N'img\products\NhaGiaKim.jpg', N'NGUNG_KINH_DOANH', 5, 2020, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 120)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 3, 1, N'NCC00001', N'Bút gel', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8937788990011', N'img\products\ButGelDeli.jpg', N'NGUNG_KINH_DOANH', 50, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 6, 1, N'NCC00002', N'Ghim kẹp giấy', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8938899001122', N'img\products\GhimKepGiayMeKI.jpg', N'CON_HANG', 70, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 10)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 3, 1, N'NCC00002', N'Bút xóa', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8939900112233', N'img\products\ButXoaDeli.jpg', N'CON_HANG', 100, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 6, 1, N'NCC00002', N'Bìa lá', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 2, N'DUOC_DOI_TRA', N'8931234432112', N'img\products\BiaLaMEKI.jpg', N'CON_HANG', 70, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 70)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 4, 1, N'NCC00001', N'Hộp đựng bút', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8934321123412', N'img\products\HopDungButUUMIR.jpg', N'NGUNG_KINH_DOANH', 20, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 50)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 3, 1, N'NCC00001', N'Kéo', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8939876543210', N'img\products\KeoDeli.jpg', N'CON_HANG', 27, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 35)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 5, 1, N'NCC00001', N'Nhãn dính', CAST(N'2023-11-04T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8938765432109', N'img\products\NhanDinhEELHOE.jpg', N'CON_HANG', 27, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 12)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 5, 1, N'NCC00002', N'Nhíp màu', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8937654321098', N'img\products\NhipMauEELHOE.jpg', N'CON_HANG', 60, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 25)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 5, 1, N'NCC00002', N'Viên làm sạch oxy', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8936543210987', N'img\products\VienLamSachOxyELLHOE.jpg', N'CON_HANG', 23, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 77)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 3, 1, N'NCC00001', N'Thước', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8935432109876', N'img\products\ThuocDeli.jpg', N'CON_HANG', 15, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt nam', N'1', 1, N'', 12)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 6, 1, N'NCC00002', N'Sổ ghi chú', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 2, N'DUOC_DOI_TRA', N'8934321098765', N'img\products\SoLoXoMEKI.jpg', N'CON_HANG', 60, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 23)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 5, 1, N'NCC00001', N'Sticker', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8933210987654', N'img\products\StickerEELHOE.jpg', N'CON_HANG', 33, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 56)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 6, 1, N'NCC00002', N'Hộp đựng bút', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8932109876543', N'img\products\TuiDungButMEKI.jpg', N'CON_HANG', 88, 2023, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 52)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Cây cam ngọt của tôi', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8931357924680
', N'img\products\CayCamNgotCuaToi.jpg', N'NGUNG_KINH_DOANH', 6, 2023, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 6, 1, 1, 1, 1, N'NCC00001', N'Vợ nhặt', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8932468013579', N'img\products\VoNhat.jpg', N'NGUNG_KINH_DOANH', 1, 2000, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 3, 1, N'NCC00001', N'Ô', CAST(N'2023-11-26T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8931029384756', N'img\products\ODeli.jpg', N'CON_HANG', 2, 2003, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 2, 3, 2, 1, 2, N'NCC00001', N'Vật lý siêu hấp dẫn', CAST(N'2023-12-01T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8932093847561', N'img\products\VatLySieuHapDan.jpg', N'NGUNG_KINH_DOANH', 1, 2003, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 2, 1, N'NCC00002', N'1', CAST(N'2023-12-01T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8939786543215', N'', N'CON_HANG', 1, 2003, N'SAN_PHAM_KHAC', N'', N'', N'Việt Nam', N'1', 1, N'', 100)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 9, 2, 1, 1, 2, N'NCC00002', N'Tiểu sử các quốc gia', CAST(N'2023-12-01T00:00:00.000' AS DateTime), 3, N'DUOC_DOI_TRA', N'8937654321098', N'img\products\TieuSuCacQuocGia.jpg', N'CON_HANG', 3, 2003, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 200)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 1, 2, N'NCC00001', N'1', CAST(N'2023-12-04T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8935432109876', N'img\products\BaiTapNguPhapTiengPhap.jpg', N'NGUNG_KINH_DOANH', 1, 2003, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 210)
INSERT [dbo].[SanPham] ([TacGiaID], [TheLoaiID], [NhaXuatBanID], [ThuongHieuID], [DanhMucID], [NhaCungCapID], [TenSanPham], [NgayNhap], [Thue], [LoaiDoiTra], [Barcode], [ImgPath], [TinhTrang], [SoLuongTon], [NamSanXuat], [LoaiSanPham], [DonViDoLuong], [KichThuoc], [XuatXu], [NgonNgu], [SoTrang], [LoaiBia], [GiaNhap]) VALUES ( 1, 1, 1, 1, 1, N'NCC00001', N'1', CAST(N'2023-12-09T00:00:00.000' AS DateTime), 1, N'DUOC_DOI_TRA', N'8931234512345', N'', N'CON_HANG', 1, 2003, N'SACH', N'pcs', N'A2', N'Việt Nam', N'VietNamese', 100, N'Paperback', 50)

GO




--- KHUYẾN MÃI
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'APPLY_PRODUCT_3', N'Sự kiện chào đón năm mới', N'PHAN_TRAM', 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-02-29T00:00:00.000' AS DateTime), 11200, 100, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'APPLY_PRODUCT_ONE', N'Giảm giá cuối năm 2023', N'PHAN_TRAM', 4, CAST(N'2023-11-01T00:00:00.000' AS DateTime), CAST(N'2023-12-31T00:00:00.000' AS DateTime), 10000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'APPLY_PRODUCT_TWO', N'Giảm giá đầu năm 2024', N'GIA_TRI', 40000, CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-02-29T00:00:00.000' AS DateTime), 15000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'KM0001', N'Discount 10%', N'Percentage', 10, CAST(N'2023-11-01T00:00:00.000' AS DateTime), CAST(N'2023-11-30T00:00:00.000' AS DateTime), 1, 100, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'KM0002', N'Black Friday', N'Fixed', 50, CAST(N'2023-11-25T00:00:00.000' AS DateTime), CAST(N'2023-11-27T00:00:00.000' AS DateTime), 1, 200, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'NO_APPLY', N'Không áp dụng', N'PHAN_TRAM', 0, CAST(N'2023-11-01T00:00:00.000' AS DateTime), CAST(N'2023-11-30T00:00:00.000' AS DateTime), 1, 100, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_aLvkPW', N'Sự kiện tết nguyên đám', N'PHAN_TRAM', 50000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-30T00:00:00.000' AS DateTime), 100000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_dpnzQo', N'Giảm giá cho đơn trên 20k', N'GIA_TRI', 35000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-12T00:00:00.000' AS DateTime), 10000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_H4evz9', N'Sự kiện tết nguyên đám', N'PHAN_TRAM', 50000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-30T00:00:00.000' AS DateTime), 100000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_JS3I_B', N'Giảm giá cho đơn trên 20k', N'GIA_TRI', 35000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-12T00:00:00.000' AS DateTime), 10000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_nqqRki', N'Sự kiện tết nguyên đám', N'PHAN_TRAM', 50000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-30T00:00:00.000' AS DateTime), 100000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_NZpB1Z', N'Giảm giá cho đơn trên 20k', N'GIA_TRI', 35000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-12T00:00:00.000' AS DateTime), 10000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_o71A5b', N'Sự kiện tết nguyên đám', N'PHAN_TRAM', 50000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-30T00:00:00.000' AS DateTime), 100000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_uA9lZa', N'Giảm giá cho đơn trên 20k', N'GIA_TRI', 35000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-12T00:00:00.000' AS DateTime), 10000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_W59SdW', N'Sự kiện tết nguyên đám', N'PHAN_TRAM', 50000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-30T00:00:00.000' AS DateTime), 100000, 1, 0)
INSERT [dbo].[KhuyenMai] ([CodeKhuyenMai], [TenKhuyenMai], [LoaiGiamGia], [GiaTri], [NgayKhuyenMai], [NgayHetHanKM], [DonHangTu], [SoLuongKhuyenMai], [SoLuotDaApDung]) VALUES (N'Voucher_yKgduo', N'Giảm giá cho đơn trên 20k', N'GIA_TRI', 35000, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-12T00:00:00.000' AS DateTime), 10000, 1, 0)
GO

-- CHI TIẾT KM

INSERT [dbo].[ChiTietKhuyenMai] ([NgayTao], [SanPhamID], [CodeKhuyenMai]) VALUES (CAST(N'2023-12-12T00:00:00.000' AS DateTime), 1, N'APPLY_PRODUCT_ONE')
INSERT [dbo].[ChiTietKhuyenMai] ([NgayTao], [SanPhamID], [CodeKhuyenMai]) VALUES (CAST(N'2023-12-12T00:00:00.000' AS DateTime), 2, N'APPLY_PRODUCT_ONE')
INSERT [dbo].[ChiTietKhuyenMai] ([NgayTao], [SanPhamID], [CodeKhuyenMai]) VALUES (CAST(N'2023-12-12T00:00:00.000' AS DateTime), 1, N'APPLY_PRODUCT_TWO')
INSERT [dbo].[ChiTietKhuyenMai] ([NgayTao], [SanPhamID], [CodeKhuyenMai]) VALUES (CAST(N'2023-12-12T00:00:00.000' AS DateTime), 2, N'APPLY_PRODUCT_TWO')
INSERT [dbo].[ChiTietKhuyenMai] ([NgayTao], [SanPhamID], [CodeKhuyenMai]) VALUES (CAST(N'2023-12-12T00:00:00.000' AS DateTime), 1, N'APPLY_PRODUCT_3')
INSERT [dbo].[ChiTietKhuyenMai] ([NgayTao], [SanPhamID], [CodeKhuyenMai]) VALUES (CAST(N'2023-12-12T00:00:00.000' AS DateTime), 2, N'APPLY_PRODUCT_3')
GO


-- Sample data for NhanVien table
INSERT INTO NhanVien (NhanVienID, UserName, Password, NgayTaoTK, HoTen, GioiTinh, SoDIenThoai, ChucVu, Email, NgaySInh, DiaChi)
VALUES
    ('NV0001', 'quanly01', '123456', '2023-11-01', N'Dương Thái Bảo', 'NAM', '0869510030', 'NGUOI_QUAN_LY', 'duongthaibao.job@gmail.com', '2003-12-19', N'Bình Phước'),
    ('NV0002', 'nhanvien01', '123456', '2023-11-02', N'Nguyễn Lê Nhật Huy', 'NAM', '9876543210', 'NHAN_VIEN_BAN_HANG', 'huynguyen@gmail.com', '1985-05-20', '456 Elm St');
