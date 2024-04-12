package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import connectDB.ConnectDB;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.NhaCungCap;
import entities.SanPham;
import interfaces.IChiTietKhuyenMai;
import jakarta.persistence.EntityManager;

public class ChiTietKhuyenMai_DAO implements IChiTietKhuyenMai{
	private Connection conn;
	private EntityManager em;

	@Override
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai() {
		return em.createNamedQuery("ChiTietKhuyenMai.findAll", ChiTietKhuyenMai.class).getResultList();
	}
	
	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM) {
		try {
			return em.createNamedQuery("ChiTietKhuyenMai.getChiTietKhuyenMaiTheoMa", ChiTietKhuyenMai.class).setParameter("maKM", maKM).getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Date getNgayTao(String maKM) {
		try {
			return em.createNamedQuery("ChiTietKhuyenMai.getNgayTao", ChiTietKhuyenMai.class).setParameter("maKM", maKM)
					.getSingleResult().getNgayTao();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM) {
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
	
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham) {;
		String insertCTTKM = "INSERT INTO ChiTietKhuyenMai (NgayTao, SanPhamID, CodeKhuyenMai) VALUES (?,?,?)";
		try {
			Calendar calendar = Calendar.getInstance();
			PreparedStatement preparedStatement1 = conn.prepareStatement(insertCTTKM);
			preparedStatement1.setDate(1, new java.sql.Date(calendar.getTime().getTime()));
			preparedStatement1.setInt(2, masanPham);
			preparedStatement1.setString(3, makhuyenMai);
			preparedStatement1.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ChiTietKhuyenMai_DAO() {
		conn = ConnectDB.getConnection();
		em = ConnectDB.getEntityManager();
	}
}
