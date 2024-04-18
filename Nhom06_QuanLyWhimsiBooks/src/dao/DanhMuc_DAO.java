package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entities.DanhMuc;
import interfaces.IDanhMuc;
import jakarta.persistence.EntityManager;

public class DanhMuc_DAO implements IDanhMuc{

	private Connection conn;
	private EntityManager em;
	
	@Override
	public boolean addDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(x);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean editDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<DanhMuc> getAllDanhMuc() {
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		
		try {
			list = em.createNamedQuery("DanhMuc.findAll",DanhMuc.class).getResultList();
	
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
	}
	@Override
	public List<DanhMuc> getDanhMucTheoID(int x) {
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		try {
			list = em.createNamedQuery("DanhMuc.findByID",DanhMuc.class).setParameter("danhMucID", x).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return list;
		}
		return list;
	}
	public DanhMuc_DAO() {
		// TODO Auto-generated constructor stub
		em = ConnectDB.getEntityManager();
	}
	
}
