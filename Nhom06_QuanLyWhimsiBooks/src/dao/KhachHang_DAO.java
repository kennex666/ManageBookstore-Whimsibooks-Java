package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;

import connectDB.ConnectDB;
import entities.KhachHang;
import entities.NhanVien;
import gui.TAB_KhachHang;
import interfaces.IKhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ultilities.ProcessingEnumDBForQuy;
import ultilities.QueryBuilder;
import ultilities.QueryBuilder.Enum_DataType;

import java.sql.ResultSet;
import java.time.LocalDate;

public class KhachHang_DAO implements IKhachHang {

	private Connection conn;
	private EntityManager em;

	public List<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) {
		gioiTinh = ProcessingEnumDBForQuy.gioiTinhToEnum(gioiTinh);
		loaiKhachHang = ProcessingEnumDBForQuy.convertKhachHangToEnum(loaiKhachHang);

		List<KhachHang> listKhachHang = new ArrayList<>();
		String query = "SELECT * FROM KhachHang WHERE KhachHangID LIKE ? AND hoTen LIKE ? AND SoDienThoai LIKE ?";

		List<String> parameters = new ArrayList<>();
		parameters.add(maKhachHang.isBlank() ? "%" : "%" + maKhachHang + "%");
		parameters.add(tenKhachHang.isBlank() ? "%" : "%" + tenKhachHang + "%");
		parameters.add(soDienThoai.isBlank() ? "%" : "%" + soDienThoai + "%");
		if (!gioiTinh.isBlank()) {
			query += " AND GioiTinh = ?";
			parameters.add(gioiTinh);
		}
		if (!loaiKhachHang.isBlank()) {
			query += " AND LoaiKhachHang = ?";
			parameters.add(loaiKhachHang);
		}
		try {

			PreparedStatement pstmt = conn.prepareStatement(query);

			for (int i = 0; i < parameters.size(); i++) {
				pstmt.setString(i + 1, parameters.get(i));

			}

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// Tạo đối tượng KhachHang từ kết quả tìm kiếm
				KhachHang khachHang = new KhachHang(rs.getString("khachHangID"), rs.getString("hoTen"),
						rs.getString("soDienThoai"), rs.getDate("ngaySinh").toLocalDate(), rs.getString("gioiTinh"),
						rs.getString("email"), rs.getString("maSoThue"), rs.getString("diaChi"),
						rs.getString("loaiKhachHang"));

				// Thêm đối tượng KhachHang vào danh sách
				listKhachHang.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listKhachHang;
	}

	@Override
	public List<KhachHang> getAllKhachHang() {
		try {
			return em.createNamedQuery("KhachHang.getAllEmployees", KhachHang.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int totalKhachHang() {
		return 0;
	}

	@Override
	public boolean addKhachHang(KhachHang kh) {
		try {
			em.getTransaction().begin();
			em.persist(kh);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public KhachHang getKhachHangByKhachHangID(String ma) {
		try {
			return em.createNamedQuery("KhachHang.getKhachHangByID", KhachHang.class).setParameter("id", ma)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean editKhachHang(KhachHang kh) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteKhachHang(KhachHang kh) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getLayTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang getKhachHangTuMaVaSDT(String x) {
		try {
			return em.createNamedQuery("KhachHang.getKhachHangTuMaVaSDT", KhachHang.class).setParameter("id", x).setParameter("sdt", x)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<NhanVien> findKhachHang(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	public int phatSinhMaKhachHang() {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM KhachHang");
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1) + 1;
		} catch (Exception e) {
			System.out.println("Lỗi phát sinh mã bên DAO");
			return 0;
		}
	}

	public String phatSinhMaSoThue(String loaiKhachHang) {
		try {
			// Lấy số lượng khách hàng của loại đã cho
			String query = "SELECT COUNT(*) FROM KhachHang WHERE LoaiKhachHang = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, loaiKhachHang);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);

			// Phát sinh mã số thuế dựa trên loại khách hàng
			String prefix = (loaiKhachHang.equalsIgnoreCase("Cá nhân")) ? "TKH0" : "TKH1";
			return prefix + String.format("%03d", count + 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkIfKhachHangExists(String maKH) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String query = "SELECT COUNT(*) FROM KhachHang WHERE MaKH = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, maKH);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				System.out.println(resultSet.getInt(1));
				return count > 0;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean chuyenLoaiKhachHang(String maKhachHang, String loaiKhachHangMoi) {
		String query = "UPDATE KhachHang SET LoaiKhachHang = ? WHERE KhachHangID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loaiKhachHangMoi);
			pstmt.setString(2, maKhachHang);

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public KhachHang_DAO() {
		this.conn = ConnectDB.getConnection();
		em = ConnectDB.getEntityManager();
	}

}
