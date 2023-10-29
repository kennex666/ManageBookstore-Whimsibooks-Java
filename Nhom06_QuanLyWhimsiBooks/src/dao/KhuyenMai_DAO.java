package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.KhuyenMai;
import interfaces.IKhuyenMai;

public class KhuyenMai_DAO implements IKhuyenMai{
	private Connection conn;

	
	@Override
	public ArrayList<KhuyenMai> getAllKhuyenMai() {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm =  conn.createStatement();
			String query = "SELECT * FROM KhuyenMai";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"), rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"), rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm =  conn.createStatement();
			String query = "Select * from KhachHang WHERE MaKH = '" + maKhuyenMai + "'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"), rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"), rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean addKhuyenMai(KhuyenMai khuyenMai) {
		String codeKhuyenMai = khuyenMai.getCodeKhuyenMai();
		String tenKhuyenMai = khuyenMai.getTenKhuyenMai();
		String loaiKhuyenMai = khuyenMai.getLoaiKhuyenMai();
		double giaTri = khuyenMai.getGiaTri();
		Date ngayKhuyenMai = khuyenMai.getNgayKhuyenMai();
		Date ngayHetHanKM = khuyenMai.getNgayHetHanKM();
		double donHangTu = khuyenMai.getDonHangTu();
		
		String insert = "INSERT INTO KhuyenMai (CodeKhuyenMai, TenKhuyenMai, LoaiGiamGia, GiaTri,NgayKhuyenMai, NgayHetHanKM, DonHangTu) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, codeKhuyenMai);
			preparedStatement.setString(2, tenKhuyenMai);
			preparedStatement.setString(3, loaiKhuyenMai);
			preparedStatement.setDouble(4, giaTri);
			preparedStatement.setDate(5, ngayKhuyenMai);
			preparedStatement.setDate(6, ngayHetHanKM);
			preparedStatement.setDouble(7, donHangTu);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) {
		String update = "UPDATE KhuyenMai SET TenKhuyenMai = ?, LoaiGiamGia = ?, GiaTri = ?, NgayKhuyenMai = ?, NgayHetHanKM = ?, DonHangTu = ? Where CodeKhuyenMai =  ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, khuyenMai.getTenKhuyenMai());
			preparedStatement.setString(2, khuyenMai.getLoaiKhuyenMai());
			preparedStatement.setDouble(3, khuyenMai.getGiaTri());
			preparedStatement.setDate(4, khuyenMai.getNgayKhuyenMai());
			preparedStatement.setDate(5, khuyenMai.getNgayHetHanKM());
			preparedStatement.setDouble(6, khuyenMai.getDonHangTu());
			preparedStatement.setString(7, khuyenMai.getCodeKhuyenMai());
		return (preparedStatement.executeUpdate() > 0) ? true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			String query = "	String query = \"SELECT * FROM KhuyenMai WHERE NgayKhuyenMai BETWEEN '?' AND '?'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setDate(1, startDay);
			preparedStatement.setDate(2, expriedDay);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"), rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"), rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public KhuyenMai_DAO() {
		this.conn = ConnectDB.getConnection();
	}

}
