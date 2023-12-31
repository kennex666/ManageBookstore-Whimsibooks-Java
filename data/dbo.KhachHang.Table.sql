USE [QuanLyNhaSachWhimsiBooks]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/12/2023 4:44:15 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[KhachHangID] [nvarchar](255) NOT NULL,
	[HoTen] [nvarchar](255) NULL,
	[SoDienThoai] [nvarchar](255) NULL,
	[NgaySinh] [datetime] NULL,
	[GioiTinh] [nvarchar](255) NULL,
	[Email] [nvarchar](255) NULL,
	[MaSoThue] [nvarchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[LoaiKhachHang] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[KhachHangID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0001', N'Nguyễn Kim Thuỳ', N'0841231224', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nữ', N'kimthuy@gmail.com', N'0400587833', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'DOANH_NGHIEP')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0002', N'Nguyễn Kim Dung', N'0841231321', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nữ', N'kimdung@gmail.com', N'0400587834', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'CA_NHAN')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0003', N'Nguyễn Trung Đức', N'0841231523', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nam', N'trungduc@gmail.com', N'0400587835', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'CA_NHAN')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0004', N'Nguyễn Văn Hoà', N'0841231322', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nam', N'vanhoa@gmail.com', N'040058786', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'DOANH_NGHIEP')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0005', N'Nguyễn Thành Nam', N'0841252121', CAST(N'2023-03-01T00:00:00.000' AS DateTime), N'Nam', N'thanhnam@gmail.com', N'0400587836', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'CA_NHAN')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0006', N'Nguyễn Thành Trung', N'0741231334', CAST(N'2023-03-01T00:00:00.000' AS DateTime), N'Nam', N'thanhtrung@gmail.com', N'0400587837', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'CA_NHAN')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0007', N'Nguyễn Thị Liên', N'0421512532', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nữ', N'kimlien@gmail.com', N'0400587839', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'CA_NHAN')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0008', N'Nguyễn Thị Hoa', N'0912421452', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nữ', N'kimlen@gmail.com', N'0400587810', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'CA_NHAN')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0009', N'Nguyễn Thị Vùng', N'0912421452', CAST(N'2023-12-21T00:00:00.000' AS DateTime), N'Nữ', N'kimlen@gmail.com', N'0400587392', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'DOANH_NGHIEP')
INSERT [dbo].[KhachHang] ([KhachHangID], [HoTen], [SoDienThoai], [NgaySinh], [GioiTinh], [Email], [MaSoThue], [DiaChi], [LoaiKhachHang]) VALUES (N'KH0010', N'Nguyễn Văn Quý', N'0841234125', CAST(N'2023-12-16T00:00:00.000' AS DateTime), N'Nam', N'vanhoa@gmail.com', N'0400587312', N'12 Nguyễn Văn Bảo, Phường 4 , Gò Vấp', N'DOANH_NGHIEP')
GO
