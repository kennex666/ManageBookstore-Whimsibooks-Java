USE [QuanLyNhaSachWhimsiBooks]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/12/2023 4:44:15 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[NhanVienID] [nvarchar](255) NOT NULL,
	[UserName] [nvarchar](255) NULL,
	[Password] [nvarchar](255) NULL,
	[NgayTaoTK] [datetime] NULL,
	[HoTen] [nvarchar](255) NULL,
	[GioiTinh] [nvarchar](255) NULL,
	[SoDIenThoai] [nvarchar](255) NULL,
	[ChucVu] [nvarchar](255) NULL,
	[Email] [nvarchar](255) NULL,
	[NgaySInh] [datetime] NULL,
	[DiaChi] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[NhanVienID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0001', N'congquy17', N'123456', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Chu Công Quý', N'Nam', N'0847911569', N'Người quản lý', N'chucongquy17@gmail.com', CAST(N'2003-12-17T00:00:00.000' AS DateTime), N'44, Thôn 4, Hà Mòn, Đăk Hà Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0002', N'thanhluan17', N'thanhquy', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Nguyễn Thành Luân', N'Nam', N'0831231482', N'Người quản lý', N'thanhluan@gmail.com', CAST(N'2003-12-17T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0003', N'thaibao17', N'duongthaibao', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Dương Thái Bảo', N'Nam', N'0847212352', N'Người quản lý', N'thaibao17@gmail.com', CAST(N'2003-12-13T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0004', N'nhathuy17', N'nhathuy', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Lê Nguyễn Nhật Huy', N'Nam', N'0831231482', N'Người quản lý', N'nhathuy@gmail.com', CAST(N'2003-03-13T00:00:00.000' AS DateTime), N'17 Văn Hóm, Đồng nai')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0005', N'thanhlphu17', N'123456', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Nguyễn Thành Phú', N'Nam', N'0831234121', N'Nhân viên bán hàng', N'thanhphu@gmail.com', CAST(N'2003-03-12T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0006', N'thuydung1', N'123214124', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Nguyễn Thuỳ Dung', N'Nữ', N'0831232412', N'Nhân viên bán hàng', N'thuydung@gmail.com', CAST(N'2003-03-12T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0007', N'thuytrang', N'12321421', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Nguyễn Thuỳ Trang', N'Nữ', N'0831232412', N'Nhân viên bán hàng', N'thuydung@gmail.com', CAST(N'2003-03-12T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0008', N'thuyan', N'21312421', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Đồ Thuý Ân', N'Nữ', N'0831232412', N'Nhân viên bán hàng', N'thuyan@gmail.com', CAST(N'2003-03-22T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0009', N'tuanhai', N'12312421412', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Phạm Tuấn Hải', N'Nữ', N'0831232412', N'Nhân viên bán hàng', N'tuanhai@gmail.com', CAST(N'2003-03-14T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
INSERT [dbo].[NhanVien] ([NhanVienID], [UserName], [Password], [NgayTaoTK], [HoTen], [GioiTinh], [SoDIenThoai], [ChucVu], [Email], [NgaySInh], [DiaChi]) VALUES (N'NV0010', N'congtrung', N'12321312412', CAST(N'2023-12-11T00:00:00.000' AS DateTime), N'Phạm Tuấn Trung', N'Nữ', N'0831232412', N'Nhân viên bán hàng', N'tuanhai@gmail.com', CAST(N'2003-03-14T00:00:00.000' AS DateTime), N'Đăk Ngọc, Hà Mòn, Đăk Hà, Kon Tum')
GO
