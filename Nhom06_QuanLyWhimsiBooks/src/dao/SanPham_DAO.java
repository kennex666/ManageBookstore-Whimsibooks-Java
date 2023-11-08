package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.DanhMuc;
import entities.NhaCungCap;
import entities.NhaXuatBan;
import entities.SanPham;
import entities.TacGia;
import entities.TheLoai;
import entities.ThuongHieu;
import interfaces.ISanPham;

public class SanPham_DAO implements ISanPham{

	private Connection conn;
	@Override
	public ArrayList<SanPham> getDanhSachSanPham(String query) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		
		try {
			Statement stm = conn.createStatement();
			
			//query = "SELECT * FROM SanPham";
			
			TacGia tg = new TacGia();
			NhaCungCap ncc = new NhaCungCap();
			TheLoai tl = new TheLoai();
			NhaXuatBan nxb = new NhaXuatBan();
			DanhMuc dm = new DanhMuc();
			ThuongHieu th = new ThuongHieu();
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				try {
					int sanphamid = rs.getInt("sanphamid");
					int soLuongTon = rs.getInt("soluongton");
					int namsx = rs.getInt("namsanxuat"); 
					int sotrang = rs.getInt("sotrang"); 
					Date ngaynhap =  rs.getDate("ngaynhap"); 
					double gianhap = rs.getDouble("gianhap"); 
					double thue = rs.getDouble("thue"); 
					String tensanpham = rs.getString("tensanpham"); 
					String loaidoitra = rs.getString("loaidoitra");
					String barcode = rs.getString("barcode"); 
					String img = rs.getString("imgpath"); 
					String tinhtrang = rs.getString("tinhtrang"); 
					String loaisanpham = rs.getString("loaisanpham"); 
					String donvidoluong = rs.getString("donvidoluong"); 
					String kichthuoc = rs.getString("kichthuoc"); 
					String xuatxu = rs.getString("xuatxu"); 
					String ngongu = rs.getString("ngonngu"); 
					String loaibia = rs.getString("loaibia"); 
					
					int tacgiaid = rs.getInt("tacgiaid"); 
					int theloaiid = rs.getInt("theloaiid"); 
					int nhaxuatbanid = rs.getInt("nhaxuatbanid"); 
					int thuonghieuid = rs.getInt("thuonghieuid"); 
					int danhmucid = rs.getInt("danhmucid"); 
					String nhacungcapid = rs.getString("nhacungcapid");
					
					tg.setTacGiaID(tacgiaid);
					tl.setTheLoaiID(theloaiid);
					nxb.setNhaXuatBanID(nhaxuatbanid);
					th.setThuongHieuID(thuonghieuid);
					dm.setDanhMucID(danhmucid);
					ncc.setNhaCungCapID(nhacungcapid);
					
					
//					tg.setTacGiaID(1);
//					tl.setTheLoaiID(1);
//					nxb.setNhaXuatBanID(1);
//					th.setThuongHieuID(1);
//					dm.setDanhMucID(1);
//					ncc.setNhaCungCapID("1");
					
					SanPham sanPham = new SanPham(sanphamid, soLuongTon, namsx, 
							 sotrang, ngaynhap, gianhap, thue, tensanpham, 
							loaidoitra, barcode, img, tinhtrang, loaisanpham, donvidoluong, 
							kichthuoc, xuatxu, ngongu, loaibia,
							tg, tl, nxb, th, dm, ncc);
					list.add(sanPham);
					
//					SanPham sanPham = new SanPham(sanphamid, soLuongTon, namsx, 
//							daban, 2, ngaynhap, dongia, thue, tensanpham, 
//							loaidoitra, "abc", img, tinhtrang, loaisanpham, donvidoluong, 
//							kichthuoc, xuatxu, ngongu, loaibia,
//							tg, tl, nxb, th, dm, ncc);
//					list.add(sanPham);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return list;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
	}
	

	@Override
	public boolean addSanPham(SanPham sp) {
		try {
			String sql = "INSERT INTO SanPham(TenSanPham, NgayNhap, GiaNhap, Thue, "
					+ "LoaiDoiTra, Barcode, ImgPath, TinhTrang, SoLuongTon, NamSanXuat, "
					+ "LoaiSanPham, DonViDoLuong, KichThuoc, XuatXu, NgonNgu, "
					+ "SoTrang, LoaiBia)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, sp.getTenSanPham());
				pstm.setDate(2, (Date) sp.getNgayNhap());
				pstm.setDouble(3, sp.getGiaNhap());
				pstm.setDouble(4, sp.getThue());
				pstm.setString(5, sp.getLoaiDoiTra());
				pstm.setString(6, sp.getBarcode());
				pstm.setString(7, sp.getImgPath());
				pstm.setString(8, sp.getTinhTrang());
				pstm.setInt(9, sp.getSoLuongTon());
				pstm.setInt(10, sp.getNamSanXuat());
				pstm.setString(11,  sp.getLoaiSanPham());
				pstm.setString(12, sp.getDonViDoLuong());
				pstm.setString(13, sp.getKichThuoc());
				pstm.setString(14, sp.getXuatXu());
				pstm.setString(15, sp.getNgonNgu());
				pstm.setInt(16, sp.getSoTrang());
				pstm.setString(17, sp.getLoaiBia());
				return(pstm.executeUpdate()>0)?true:false;
				
			} catch (Exception e) {
				e.printStackTrace();
//				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi");
		}
		return false;
	}

	@Override
	public boolean editSanPham(SanPham sp) {
		int id = sp.getSanPhamID();
		try {			
				
			String sql = "UPDATE SanPham "
					+ "SET  TenSanPham = ?, NgayNhap  = ?, GiaNhap = ?, Thue = ?, LoaiDoiTra = ?,"
					+ "Barcode = ?, ImgPath = ?, TinhTrang = ?, SoLuongTon = ?, NamSanXuat = ?, LoaiSanPham = ?,"
					+ "DonViDoLuong = ?, KichThuoc = ?, XuatXu = ?, NgonNgu = ?, SoTrang = ?, LoaiBia = ? WHERE NhanVienID = ?";

			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, sp.getTenSanPham());
				pstm.setDate(2, (Date) sp.getNgayNhap());
				pstm.setDouble(3, sp.getGiaNhap());
				pstm.setDouble(4, sp.getThue());
				pstm.setString(5, sp.getLoaiDoiTra());
				pstm.setString(6, sp.getBarcode());
				pstm.setString(7, sp.getImgPath());
				pstm.setString(8, sp.getTinhTrang());
				pstm.setInt(9, sp.getSoLuongTon());
				pstm.setInt(10, sp.getNamSanXuat());
				pstm.setString(11,  sp.getLoaiSanPham());
				pstm.setString(12, sp.getDonViDoLuong());
				pstm.setString(13, sp.getKichThuoc());
				pstm.setString(14, sp.getXuatXu());
				pstm.setString(15, sp.getNgonNgu());
				pstm.setInt(16, sp.getSoTrang());
				pstm.setString(17, sp.getLoaiBia());
				pstm.setInt(18, id);
				return(pstm.executeUpdate()>0)?true:false;
			} catch (Exception e) {
				e.printStackTrace();
//				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi");
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<SanPham> getDanhSachSanPhamSapHet() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		
		//Statement stm = conn.createStatement();
		String query = "SELECT * FROM SanPham WHERE SoLuongTon <= 10";
		
		list = getDanhSachSanPham(query);
		return list;		
		
	}

	public SanPham_DAO() {
		super();
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}


	@Override
	public ArrayList<SanPham> searchSanPham(String sanPhamID) {
		ArrayList<SanPham> list;
		list = new ArrayList<SanPham>();
		
		//Statement stm = conn.createStatement();
		String query = "SELECT * FROM SanPham WHERE SanPhamID = " + sanPhamID;
		
		list = getDanhSachSanPham(query);
		return list;
	}


	@Override
	public ArrayList<SanPham> getDanhSachSanPham() {
		ArrayList<SanPham> list = new ArrayList<>();
		String query = "SELECT * FROM SANPHAM";
		list = getDanhSachSanPham(query);
		return list;
	}
	
}
