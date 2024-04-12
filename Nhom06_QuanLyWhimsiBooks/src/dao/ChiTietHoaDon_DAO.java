package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import entities.DanhMuc;
import entities.NhaCungCap;
import entities.NhaXuatBan;
import entities.SanPham;
import entities.TacGia;
import entities.TheLoai;
import entities.ThuongHieu;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;
import jakarta.persistence.EntityManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDon_DAO implements IChiTietHoaDon {
	private EntityManager em;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
        boolean isThisSession = em.getTransaction().isActive();

		try {
        	if (isThisSession == false)
        		em.getTransaction().begin();
				x.setDonGia(x.getSanPham().getGiaBan());
				em.persist(x);
				
            if (isThisSession == false)
				em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietHoaDon> x) {
            boolean isThisSession = em.getTransaction().isActive();
            // Xoá chi tiết hoá đơn cũ để cập nhật lại
            if (x.size() < 1)
                return true;
            try {
                // TODO Auto-generated method stub
            	if (isThisSession == false)
            		em.getTransaction().begin();
				em.createNamedQuery("ChiTietHoaDon.deleteAllByHoaDonID")
				.setParameter("hoaDonID", x.get(0).getHoaDon().getHoaDonID()) .executeUpdate();
				for (ChiTietHoaDon y : x) {
					if (!addMotChiTietCuaHoaDon(y))
						return false;
				}

            if (isThisSession == false)
				em.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                em.getTransaction().rollback();
                return false;
            }
            
            // Cập nhật chi tiết hoá đơn mới
	
		return true;
	}
	@Override
	public List<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		List<ChiTietHoaDon> listCT = new ArrayList<ChiTietHoaDon>();

		try {

			listCT = em.createNamedQuery("ChiTietHoaDon.findAllByHoaDonID", ChiTietHoaDon.class)
					.setParameter("hoaDonID", maHoaDon).getResultList();
			
			return listCT;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listCT;
		}
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ChiTietHoaDon_DAO() {
		// TODO Auto-generated constructor stub
		em = ConnectDB.getEntityManager();
	}

}
