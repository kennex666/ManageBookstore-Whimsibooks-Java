package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.KhachHang;
import entities.NhanVien;
import interfaces.IKhachHang;

public class KhachHang_DAO implements IKhachHang {
	Connection conn = ConnectDB.getConnection();

	public ArrayList<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) {
		ArrayList<KhachHang> listKhachHang = new ArrayList<>();
		// TODO Auto-generated method stub
		return listKhachHang;
	}

	@Override
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> listKhachHang = new ArrayList<>();
		String query = "SELECT * FROM KhachHang";
		try (PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {

				KhachHang khachHang = new KhachHang();
				khachHang.setKhachHangID(rs.getString("khachHangID"));
				khachHang.setHoTen(rs.getString("hoTen"));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));

				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				if (ngaySinh != null) {
					khachHang.setNgaySinh(ngaySinh.toLocalDate());
				}
				khachHang.setGioiTinh(rs.getString("gioiTinh"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setMaSoThue(rs.getString("maSoThue"));
				;
				khachHang.setDiaChi(rs.getString("diaChi"));
				khachHang.setLoaiKhachHang(rs.getString("loaiKhachHang"));

				listKhachHang.add(khachHang);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listKhachHang;
	}

	@Override
	public int totalKhachHang() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addKhachHang(KhachHang kh) {

		boolean result = false;
		Connection conn = ConnectDB.getConnection();
		String query = "INSERT INTO KhachHang(KhachHangID,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,MaSoThue,DiaChi,LoaiKhachHang) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pretm = conn.prepareStatement(query);
			pretm.setString(1, kh.getKhachHangID());
			pretm.setString(2, kh.getHoTen());
			pretm.setString(3, kh.getSoDienThoai());
			pretm.setDate(4, Date.valueOf(kh.getNgaySinh()));
			pretm.setString(5, kh.getGioiTinh());
			pretm.setString(6, kh.getEmail());
			pretm.setString(7, kh.getMaSoThue());
			pretm.setString(8, kh.getDiaChi());
			pretm.setString(9, kh.getLoaiKhachHang());

			return (pretm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean editKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLayTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<NhanVien> findKhachHang(String x) {
		// TODO Auto-generated method stub
		return null;
	}
}
