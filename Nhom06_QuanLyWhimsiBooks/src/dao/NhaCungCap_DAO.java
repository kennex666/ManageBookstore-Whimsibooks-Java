package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entities.KhuyenMai;
import entities.NhaCungCap;
import interfaces.INhaCungCap;
import jakarta.persistence.EntityManager;

public class NhaCungCap_DAO implements INhaCungCap{
	private EntityManager em;
	
	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		
		try {
			list = em.createNamedQuery("NhaCungCap.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NhaCungCap> getNCCByID(String maNCC) {
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			list = em.createNamedQuery("NhaCungCap.findByID").setParameter("id", maNCC).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NhaCungCap> getNCCByPhone(String sdt) {
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			list = em.createNamedQuery("NhaCungCap.findByPhone").setParameter("soDienThoai", "%"+sdt+"%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<NhaCungCap> getNCCByEmail(String email) {
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			list = em.createNamedQuery("NhaCungCap.findByEmail").setParameter("email" , "%" + email + "%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<NhaCungCap> getNCCByName(String name) {
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			list = em.createNamedQuery("NhaCungCap.findByName").setParameter("name", name).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public boolean addNhaCungCap(NhaCungCap ncc) {
		
		try {
			em.getTransaction().begin();
			em.persist(ncc);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Trùng mã nhà cung cấp");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap ncc) {
//		String maNCC = ncc.getNhaCungCapID();
//		String tenNCC = ncc.getTenNhaCungCap();
//		String SDT = ncc.getSoDienThoai();
//		String email = ncc.getEmail();
//		String diaChi = ncc.getDiaChi();
//		
		try {
			em.getTransaction().begin();
			em.merge(ncc);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public long layMaNCCCuoiCung() {
		try {
			return (long) em.createNamedQuery("NhaCungCap.getNCCCC").getSingleResult();
		} catch (Exception e) {
			return 0;
		}
	}

	public NhaCungCap_DAO() {
		em = ConnectDB.getEntityManager();
	}
}
