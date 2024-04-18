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
import jakarta.persistence.EntityTransaction;

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
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(khuyenMai, sanPham, new Date(Calendar.getInstance().getTime().getTime()));
			em.persist(chiTietKhuyenMai);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham) {;
		EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(em.find(KhuyenMai.class, makhuyenMai), em.find(SanPham.class, masanPham), new Date(Calendar.getInstance().getTime().getTime()));
            em.persist(chiTietKhuyenMai);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	public ChiTietKhuyenMai_DAO() {
		conn = ConnectDB.getConnection();
		em = ConnectDB.getEntityManager();
	}
}
