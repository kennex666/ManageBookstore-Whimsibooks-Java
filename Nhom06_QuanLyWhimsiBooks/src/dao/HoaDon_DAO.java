package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entities.HoaDon;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import interfaces.IHoaDon;
import utilities.QueryBuilder;

public class HoaDon_DAO implements IHoaDon{
	private Connection conn;
	
	public HoaDon_DAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}
	
	@Override
	public boolean createHoaDon(HoaDon x) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO HoaDon(HoaDonID, CodeKhuyenMai, KhachHangID, NhanVienID, NgayLapHoaDon, TongTien, TrangThai, Thue, GiaKhuyenMai) VALUES(?, ? ,? ,?, ?, ? ,? ,?, ?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, x.getHoaDonID());
			pstm.setString(2, (x.getKhuyenMai() == null ) ? "NO_APPLY" : x.getKhuyenMai().getCodeKhuyenMai());
			pstm.setString(3, (x.getKhachHang() == null ) ? "KH0001" : x.getKhachHang().getKhachHangID());
			pstm.setString(4, (x.getNhanVien() == null ) ? "NV0001" : x.getNhanVien().getNhanVienID());
			java.sql.Timestamp now = new java.sql.Timestamp(new Date().getTime());
			pstm.setTimestamp(5, now);
			pstm.setDouble(6, x.tinhThanhTien());
			pstm.setString(7, x.getTrangThai());
			pstm.setDouble(8, x.getThue());
			pstm.setDouble(9, x.getGiaKhuyenMai());
			return (pstm.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                        e.printStackTrace();
			return false;
		}
	}

        @Override
        public boolean updateHoaDon(HoaDon x) {
            String query = "UPDATE HoaDon SET CodeKhuyenMai = ?, KhachHangID = ?, NhanVienID = ?, NgayLapHoaDon = ?, TongTien = ?, TrangThai = ?, Thue = ?, GiaKhuyenMai = ? WHERE HoaDonID = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(9, x.getHoaDonID());
			pstm.setString(1, (x.getKhuyenMai() == null || x.getKhuyenMai().getCodeKhuyenMai() == null) ? "NO_APPLY" : x.getKhuyenMai().getCodeKhuyenMai());
			pstm.setString(2, (x.getKhachHang() == null ||  x.getKhachHang().getKhachHangID() == null) ? "KH0001" : x.getKhachHang().getKhachHangID());
			pstm.setString(3, (x.getNhanVien() == null ||  x.getNhanVien().getNhanVienID() ==null ) ? "NV0001" : x.getNhanVien().getNhanVienID());
            java.sql.Timestamp now = new java.sql.Timestamp(new Date().getTime());
			pstm.setTimestamp(4, now);
			pstm.setDouble(5, x.tinhThanhTien());
			pstm.setString(6, x.getTrangThai());
			pstm.setDouble(7, x.getThue());
			pstm.setDouble(8, x.getGiaKhuyenMai());
                        pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                        e.printStackTrace();
			return false;
		}
        }

        @Override
        public boolean cancelHoaDon(HoaDon x) {
            String query = "UPDATE HoaDon SET TrangThai = ? WHERE HoaDonID = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, "TRA_HANG");
			pstm.setString(2, x.getHoaDonID());
                        pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                        e.printStackTrace();
			return false;
		}
        }

        
        
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDon() {
		ArrayList<HoaDon> listHoaDon = new ArrayList<HoaDon>();
		String query = "SELECT TOP 100 * FROM HoaDon hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID JOIN KhuyenMai km ON km.CodeKhuyenMai = hd.CodeKhuyenMai  WHERE YEAR(NgayLapHoaDon) = YEAR(GETDATE()) AND MONTH(NgayLapHoaDon) = MONTH(GETDATE()) AND DAY(NgayLapHoaDon) = DAY(GETDATE()) ORDER BY NgayLapHoaDon DESC";
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				HoaDon hd = new HoaDon();
			
				String hoaDonID = rs.getString("HoaDonID");
				String codeKM = rs.getString("CodeKhuyenMai");
				String khachHangID = rs.getString("KhachHangID");
				String nhanVienID = rs.getString("NhanVienID");
				Date ngayLapHoaDon = rs.getTimestamp("NgayLapHoaDon");
				double tongTien = rs.getDouble("tongTien");
				String trangThai = rs.getString("TrangThai");
				double thue = rs.getDouble("thue");
				double giaKhuyenMai = rs.getDouble("giaKhuyenMai");
				
				hd.setHoaDonID(hoaDonID);
				hd.setNgayLapHoaDon(ngayLapHoaDon);
				hd.setTongTien(tongTien);
				hd.setTrangThai(trangThai);
				hd.setThue(thue);
				hd.setGiaKhuyenMai(giaKhuyenMai);
				
				
				String hoTenNhanVien = rs.getString("HoTen");
				String chucVu = rs.getString("chucvu");
				
				NhanVien nv = new NhanVien(nhanVienID);
				nv.setHoTen(hoTenNhanVien);
				nv.setChucVu(chucVu);
				hd.setNhanVien(nv);
				
	
				String hoTenKH = rs.getString(22);
				String maSoThue = rs.getString("MaSoThue");
				String diaChi = rs.getString("diaChi");
				String loaiKH = rs.getString("LoaiKhachHang");
				String sdtKH = rs.getString("SoDienThoai");
				String emailKH = rs.getString("Email");
				
				KhachHang kh = new KhachHang(khachHangID);
				kh.setHoTen(hoTenKH);
				kh.setMaSoThue(maSoThue);
				kh.setDiaChi(diaChi);
				kh.setLoaiKhachHang(loaiKH);
				kh.setSoDienThoai(sdtKH);
				kh.setEmail(emailKH);
				hd.setKhachHang(kh);
				
				String tenKhuyenMai = rs.getString("TenKhuyenMai");
				
				KhuyenMai km = new KhuyenMai(codeKM);
				km.setTenKhuyenMai(tenKhuyenMai);
				hd.setKhuyenMai(km);
				
				listHoaDon.add(hd);

			}
			return listHoaDon;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listHoaDon;
		}
	}
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
		// TODO Auto-generated method stub
		ArrayList<HoaDon> listHoaDon = new ArrayList<HoaDon>();
                
		String query = "SELECT * FROM HoaDon hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID JOIN KhuyenMai km ON km.CodeKhuyenMai = hd.CodeKhuyenMai ?";
                
		try {
                    QueryBuilder queryBuilder = new QueryBuilder(query);
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.TIMESTAMP, 
                            "NgayLapHoaDon", 
                            ">=", 
                            batDau
                    );
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.TIMESTAMP, 
                            "NgayLapHoaDon", 
                            "<=", 
                            ketThuc
                    );   
			ResultSet rs = queryBuilder.setParamsForPrepairedStament(conn, "AND").executeQuery();
			
			while (rs.next()) {
				HoaDon hd = new HoaDon();
			
				String hoaDonID = rs.getString("HoaDonID");
				String codeKM = rs.getString("CodeKhuyenMai");
				String khachHangID = rs.getString("KhachHangID");
				String nhanVienID = rs.getString("NhanVienID");
				Date ngayLapHoaDon = rs.getTimestamp("NgayLapHoaDon");
				double tongTien = rs.getDouble("tongTien");
				String trangThai = rs.getString("TrangThai");
				double thue = rs.getDouble("thue");
				double giaKhuyenMai = rs.getDouble("giaKhuyenMai");
				
				hd.setHoaDonID(hoaDonID);
				hd.setNgayLapHoaDon(ngayLapHoaDon);
				hd.setTongTien(tongTien);
				hd.setTrangThai(trangThai);
				hd.setThue(thue);
				hd.setGiaKhuyenMai(giaKhuyenMai);
				
				
				String hoTenNhanVien = rs.getString("HoTen");
				String chucVu = rs.getString("chucvu");
				
				NhanVien nv = new NhanVien(nhanVienID);
				nv.setHoTen(hoTenNhanVien);
				nv.setChucVu(chucVu);
				hd.setNhanVien(nv);
				
	
				String hoTenKH = rs.getString(22);
				String maSoThue = rs.getString("MaSoThue");
				String diaChi = rs.getString("diaChi");
				String loaiKH = rs.getString("LoaiKhachHang");
				String sdtKH = rs.getString("SoDienThoai");
				String emailKH = rs.getString("Email");
				
				KhachHang kh = new KhachHang(khachHangID);
				kh.setHoTen(hoTenKH);
				kh.setMaSoThue(maSoThue);
				kh.setDiaChi(diaChi);
				kh.setLoaiKhachHang(loaiKH);
				kh.setSoDienThoai(sdtKH);
				kh.setEmail(emailKH);
				hd.setKhachHang(kh);
				
				String tenKhuyenMai = rs.getString("TenKhuyenMai");
				
				KhuyenMai km = new KhuyenMai(codeKM);
				km.setTenKhuyenMai(tenKhuyenMai);
				hd.setKhuyenMai(km);
				
				listHoaDon.add(hd);

			}
			return listHoaDon;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listHoaDon;
		}
	}
	
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDonNangCao(Object[] params) {
		// TODO Auto-generated method stub
		ArrayList<HoaDon> listHoaDon = new ArrayList<HoaDon>();
                
		String query = "SELECT * FROM HoaDon hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID JOIN KhuyenMai km ON km.CodeKhuyenMai = hd.CodeKhuyenMai ?";
                
		try {
                    QueryBuilder queryBuilder = new QueryBuilder(query);
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.TIMESTAMP, 
                            "NgayLapHoaDon", 
                            ">", 
                            params[0]
                    );
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.TIMESTAMP, 
                            "NgayLapHoaDon", 
                            "<=", 
                            params[1]
                    );
                    
                    queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING, 
                    "TrangThai", 
                    "=", 
                        params[2]
                    );
                   
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.DOUBLE, 
                            "TongTien", 
                            ">=", 
                            params[3]
                    );
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.DOUBLE, 
                            "TongTien", 
                            "<=", 
                            params[4]
                    );
                    
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.STRING, 
                            "HoaDonID", 
                            "%?%", 
                            params[5]
                    );
                    
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.STRING, 
                            "hd.KhachHangID", 
                            "%?%", 
                            params[6]
                    );
                    
                    queryBuilder.addParameter(
                            QueryBuilder.Enum_DataType.STRING, 
                            "hd.NhanVienID", 
                            "%?%", 
                            params[7]
                    );
                    
			ResultSet rs = queryBuilder.setParamsForPrepairedStament(conn, "AND").executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon();
			
				String hdID = rs.getString("HoaDonID");
				String codeKM = rs.getString("CodeKhuyenMai");
				String khachHangID = rs.getString("KhachHangID");
				String nhanVienID = rs.getString("NhanVienID");
				Date ngayLapHoaDon = rs.getTimestamp("NgayLapHoaDon");
				double tongTien = rs.getDouble("tongTien");
				String trangThaiHD = rs.getString("TrangThai");
				double thue = rs.getDouble("thue");
				double giaKhuyenMai = rs.getDouble("giaKhuyenMai");
				
				hd.setHoaDonID(hdID);
				hd.setNgayLapHoaDon(ngayLapHoaDon);
				hd.setTongTien(tongTien);
				hd.setTrangThai(trangThaiHD);
				hd.setThue(thue);
				hd.setGiaKhuyenMai(giaKhuyenMai);
				
				
				String hoTenNhanVien = rs.getString("HoTen");
				String chucVu = rs.getString("chucvu");
				
				NhanVien nv = new NhanVien(nhanVienID);
				nv.setHoTen(hoTenNhanVien);
				nv.setChucVu(chucVu);
				hd.setNhanVien(nv);
				
	
				String hoTenKH = rs.getString(22);
				String maSoThue = rs.getString("MaSoThue");
				String diaChi = rs.getString("diaChi");
				String loaiKH = rs.getString("LoaiKhachHang");
				String sdtKH = rs.getString("SoDienThoai");
				String emailKH = rs.getString("Email");
				
				KhachHang kh = new KhachHang(khachHangID);
				kh.setHoTen(hoTenKH);
				kh.setMaSoThue(maSoThue);
				kh.setDiaChi(diaChi);
				kh.setLoaiKhachHang(loaiKH);
				kh.setSoDienThoai(sdtKH);
				kh.setEmail(emailKH);
				hd.setKhachHang(kh);
				
				String tenKhuyenMai = rs.getString("TenKhuyenMai");
				
				KhuyenMai km = new KhuyenMai(codeKM);
				km.setTenKhuyenMai(tenKhuyenMai);
				hd.setKhuyenMai(km);
				
				listHoaDon.add(hd);

			}
			return listHoaDon;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listHoaDon;
		}
	}
	
	@Override
	public HoaDon getHoaDonByID(HoaDon hd) {
		String query = "SELECT * FROM HoaDon hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID JOIN KhuyenMai km ON km.CodeKhuyenMai = hd.CodeKhuyenMai WHERE HoaDonID = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, hd.getHoaDonID());
			ResultSet rs = pstm.executeQuery();
			
			if (!rs.next())
				return null;
			
			String hoaDonID = rs.getString("HoaDonID");
				String codeKM = rs.getString("CodeKhuyenMai");
				String khachHangID = rs.getString("KhachHangID");
				String nhanVienID = rs.getString("NhanVienID");
				Date ngayLapHoaDon = rs.getTimestamp("NgayLapHoaDon");
				double tongTien = rs.getDouble("tongTien");
				String trangThai = rs.getString("TrangThai");
				double thue = rs.getDouble("thue");
				double giaKhuyenMai = rs.getDouble("giaKhuyenMai");
				
				hd.setHoaDonID(hoaDonID);
				hd.setNgayLapHoaDon(ngayLapHoaDon);
				hd.setTongTien(tongTien);
				hd.setTrangThai(trangThai);
				hd.setThue(thue);
				hd.setGiaKhuyenMai(giaKhuyenMai);
				
				
				String hoTenNhanVien = rs.getString("HoTen");
				String chucVu = rs.getString("chucvu");
				
				NhanVien nv = new NhanVien(nhanVienID);
				nv.setHoTen(hoTenNhanVien);
				nv.setChucVu(chucVu);
				hd.setNhanVien(nv);
				
	
				String hoTenKH = rs.getString(22);
				String maSoThue = rs.getString("MaSoThue");
				String diaChi = rs.getString("diaChi");
				String loaiKH = rs.getString("LoaiKhachHang");
				String sdtKH = rs.getString("SoDienThoai");
				String emailKH = rs.getString("Email");
				
				KhachHang kh = new KhachHang(khachHangID);
				kh.setHoTen(hoTenKH);
				kh.setMaSoThue(maSoThue);
				kh.setDiaChi(diaChi);
				kh.setLoaiKhachHang(loaiKH);
				kh.setSoDienThoai(sdtKH);
				kh.setEmail(emailKH);
				hd.setKhachHang(kh);
				
				String tenKhuyenMai = rs.getString("TenKhuyenMai");
				
				KhuyenMai km = new KhuyenMai(codeKM);
				km.setTenKhuyenMai(tenKhuyenMai);
				hd.setKhuyenMai(km);
			
			
			return hd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getSoHoaDonTrongNgay() {
		// TODO Auto-generated method stub
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS [SoLuong] FROM HoaDon WHERE YEAR(NgayLapHoaDon) = YEAR(GETDATE()) AND MONTH(NgayLapHoaDon) = MONTH(GETDATE()) AND DAY(NgayLapHoaDon) = DAY(GETDATE())");
			rs.next();
			return rs.getInt("SoLuong");
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
}
