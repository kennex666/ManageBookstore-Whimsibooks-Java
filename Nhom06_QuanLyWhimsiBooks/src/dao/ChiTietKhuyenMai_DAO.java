package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import connectDB.ConnectDB;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.NhaCungCap;
import entities.SanPham;
import interfaces.IChiTietKhuyenMai;

public class ChiTietKhuyenMai_DAO implements IChiTietKhuyenMai{
	private Connection conn;

	@Override
	public ArrayList<ChiTietKhuyenMai> getAllChiTietKhuyenMai() {
		ArrayList<ChiTietKhuyenMai> list = new ArrayList<ChiTietKhuyenMai>();
		try {
			Statement stm =  conn.createStatement();
			String query = "SELECT * FROM ChiTietKhuyenMai";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("SanPhamSanPhamID"));
					SanPham sanPham = new SanPham(rs.getInt("KhuyenMaiCodeKhuyenMai"));
					ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(khuyenMai, sanPham,rs.getDate("NgayTao"));
					list.add(chiTietKhuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, ArrayList<SanPham> danhSachSPKM) {
		if(danhSachSPKM.size() > 0) {
			for(int i = 0; i  < danhSachSPKM.size(); i++) {
				addSanPhamKhuyenMai(khuyenMai, danhSachSPKM.get(i));
			}
			return true;
		}
		return false;
	}
	
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) {
		String codeKhuyenMai = khuyenMai.getCodeKhuyenMai();
		int maSP = sanPham.getSanPhamID();
		String insertCTTKM = "INSERT INTO ChiTietKhuyenMai (NgayTao, SanPhamID, CodeKhuyenMai) VALUES (?,?,?)";
		try {
			Calendar calendar = Calendar.getInstance();
			PreparedStatement preparedStatement1 = conn.prepareStatement(insertCTTKM);
			preparedStatement1.setDate(1, new java.sql.Date(calendar.getTime().getTime()));
			preparedStatement1.setInt(2, maSP);
			preparedStatement1.setString(3, codeKhuyenMai);
			preparedStatement1.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ChiTietKhuyenMai_DAO() {
		conn = ConnectDB.getConnection();
	}
}
