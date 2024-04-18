package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import connectDB.ConnectDB;
import entities.ChiTietKhuyenMai;
import entities.HoaDon;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import entities.SanPham;
import interfaces.IKhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import ultilities.QueryBuilder;

public class KhuyenMai_DAO extends UnicastRemoteObject implements IKhuyenMai {
	private EntityManager em;
	private SanPham_DAO sanPham_DAO;
	
	// convert string to date
	private Date parsedFormatDate(String date) throws ParseException, RemoteException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date pasredDate = sdf.parse(date);
		return new Date(pasredDate.getTime());
	}

	@Override
	public List<KhuyenMai> getAllKhuyenMai() throws RemoteException{
		return em.createNamedQuery("KhuyenMai.getALL", KhuyenMai.class).getResultList();
	}
	@Override
	public List<KhuyenMai> getRecentKhuyenMai(int limit) throws RemoteException{
	   return em.createNamedQuery("KhuyenMai.getRecentKhuyenMai", KhuyenMai.class).setMaxResults(limit).getResultList();
	}
	@Override
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			KhuyenMai km = em.find(KhuyenMai.class, makhuyenMai);
			SanPham sp = em.find(SanPham.class, masanPham);
			ChiTietKhuyenMai ctkm = new ChiTietKhuyenMai(km, sp, Date.valueOf(LocalDate.now()));
			em.persist(ctkm);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
            tx.rollback();
            return false;
		}
	}
	@Override
	public boolean xoaSanPhamKhuyenMai(String makhuyenMai) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createNamedQuery("KhuyenMai.xoaSanPhamKhuyenMai").setParameter("maKM", makhuyenMai).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
	@Override
	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM) throws RemoteException{
		try {
			return em.createNamedQuery("KhuyenMai.getChiTietKhuyenMaiTheoMa", ChiTietKhuyenMai.class).setParameter("maKM", maKM).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) throws RemoteException{
		try {
			return em.createNamedQuery("KhuyenMai.getKhuyenMaiByID", KhuyenMai.class).setParameter("maKM", maKhuyenMai).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM) throws RemoteException{
		try {
			return em.createNamedQuery("KhuyenMai.getKhuyenMaiByIDAndName", KhuyenMai.class)
					.setParameter("maKM", maKhuyenMai)
					.setParameter("tenKM", tenKM)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query) throws RemoteException{
		try {
			return em.createQuery(query, KhuyenMai.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<KhuyenMai> getKhuyenMaiTheoTen1(String tenSK) throws RemoteException{
		try {
			return em.createNamedQuery("KhuyenMai.getKhuyenMaiTheoTen", KhuyenMai.class).setParameter("tenKM", tenSK)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<KhuyenMai> SapXepKhuyenMaiTheoGiaTri(String maKhuyenMai) throws RemoteException{
		try {
			return em.createNamedQuery("KhuyenMai.SapXepKhuyenMaiTheoGiaTri", KhuyenMai.class).setParameter("maKM", maKhuyenMai)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addKhuyenMai(KhuyenMai khuyenMai) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(khuyenMai);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(khuyenMai);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
	
	@Override
	public boolean deleteKhuyenMai(String codeKhuyenMai) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			KhuyenMai km = em.find(KhuyenMai.class, codeKhuyenMai);
			em.remove(km);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) throws RemoteException{
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			return list = em.createNamedQuery("KhuyenMai.getKhuyenMaiFollowDay", KhuyenMai.class)
					.setParameter("startDay", startDay).setParameter("expriedDay", expriedDay).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public long layMaNCCCuoiCung() throws RemoteException{

		try {
			return em.createQuery("SELECT COUNT(km) FROM KhuyenMai km", Long.class).getSingleResult().intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai) throws RemoteException{
		KhuyenMai km = null;
		List<ChiTietKhuyenMai> listCT = new ArrayList<ChiTietKhuyenMai>();
		try {
			km = em.createQuery("SELECT km FROM KhuyenMai km WHERE km.codeKhuyenMai = :maKM", KhuyenMai.class)
					.setParameter("maKM", maKhuyenMai).getSingleResult();
			listCT = em.createNamedQuery("KhuyenMai.getChiTietKhuyenMaiTheoMa", ChiTietKhuyenMai.class)
                    .setParameter("maKM", maKhuyenMai).getResultList();
			km.setListApDung(listCT);
			return km;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiByName(String name) throws RemoteException{
		try {
			return em.createQuery("SELECT km FROM KhuyenMai km WHERE km.tenKhuyenMai = :tenKM", KhuyenMai.class)
					.setParameter("tenKM", name).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params) throws ParseException, RemoteException{
		// TODO Auto-generated method stub
		List<KhuyenMai> list = new ArrayList<>();
		
		// get number of params
		int lenghtParams = params.length;
		
		Map<String, Object> paramsInQuery = new HashMap<String, Object>(); // store params for query
		
		String where = "WHERE ";

		// parames 0
		if (params[0] != null) {
			where = where.concat("ngayKhuyenMai >= :startDay");
			paramsInQuery.put("startDay", parsedFormatDate(params[0].toString()));
		}
		// parames 1
		if (params[1] != null) {
		    if (!where.equals("WHERE ")) {
		        where = where.concat(" AND ");
		    }
		    where = where.concat("ngayKhuyenMai <= :endDay");
			paramsInQuery.put("endDay", parsedFormatDate(params[1].toString()));
		}
		// parames 2
		if (params[2] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("giaTri >= :giaTriMin");
			paramsInQuery.put("giaTriMin", params[2]);
		}
		// parames 3
		if (params[3] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("giaTri <= :giaTriMax");
			paramsInQuery.put("giaTriMax", params[3]);
		}
		// parames 4
		if (params[4] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("codeKhuyenMai LIKE :maKhuyenMai");
			paramsInQuery.put("maKhuyenMai", "%" + params[4] + "%");
		}
		// parames 5
		if (params[5] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("tenKhuyenMai LIKE :tenKhuyenMai");
			paramsInQuery.put("tenKhuyenMai", "%" + params[5] + "%");
		}

		// remove WHERE if there is no condition
		try {
			String query = null;
			// create query
			if (!where.equals("WHERE "))
				query = "SELECT km FROM KhuyenMai km " + where;
			// if there is no condition
			else
				query = "SELECT km FROM KhuyenMai km";
			
			Query queryToAddParmas = em.createQuery(query, KhuyenMai.class);
			for (Map.Entry<String, Object> entry : paramsInQuery.entrySet()) {
				queryToAddParmas.setParameter(entry.getKey(), entry.getValue());
			}
			list = queryToAddParmas.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
}
	
	public int getSoLuongChuaSD(Object[] params) throws RemoteException{
		Map<String, Object> paramsInQuery = new HashMap<String, Object>(); // store params for query
	    String addWhere = "";

	    if (params[0] != null) {
	        addWhere = addWhere.concat(" and tenKhuyenMai = :tenKhuyenMai");
	        paramsInQuery.put("tenKhuyenMai", params[0].toString());
	    }
	    if (params[1] != null) {
	        addWhere = addWhere.concat(" and codeKhuyenMai = :codeKhuyenMai");
	        paramsInQuery.put("codeKhuyenMai", params[1].toString());
	    }

	    String query = "SELECT COUNT(*) FROM KhuyenMai WHERE soLuotDaApDung = 0 " + addWhere;

	    try {
			Query queryToGetCount = em.createQuery(query);
			for (Map.Entry<String, Object> entry : paramsInQuery.entrySet()) {
				queryToGetCount.setParameter(entry.getKey(), entry.getValue());
			}
			return ((Long) queryToGetCount.getSingleResult()).intValue();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
        
    @Override
    public KhuyenMai getKhuyenMaiViaSanPhamAutoApply(int maSanPham) throws RemoteException {
    	// TODO Auto-generated method stub
//    	KhuyenMai km = null;
//		try {
//			String query = "SELECT TOP 1 * from KhuyenMai km JOIN ChiTietKhuyenMai ct ON km.CodeKhuyenMai = ct.CodeKhuyenMai WHERE SanPhamID = ? AND NgayKhuyenMai <= GETDATE() AND NgayHetHanKM >= GETDATE() AND SoLuongKhuyenMai > 1 AND SoLuotDaApDung < SoLuongKhuyenMai ORDER BY NgayKhuyenMai DESC";
//			
//            PreparedStatement pstm = conn.prepareStatement(query);
//                        pstm.setInt(1, maSanPham);
//			ResultSet rs = pstm.executeQuery();
//			if(!rs.next()) {
//				return null;
//			}
//            km = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"), rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"), rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"), rs.getInt("SoLuotDaApDung"));
//
//	        return km;
//		} catch (Exception e) {
//			e.printStackTrace();
//                        
//		}
//    	return null;
    	try {
			return em.createNamedQuery("KhuyenMai.getKhuyenMaiViaSanPhamAutoApply", KhuyenMai.class).setParameter("sanPhamID", maSanPham).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

	public KhuyenMai_DAO() throws RemoteException {
		em = ConnectDB.getEntityManager();
		this.sanPham_DAO = new SanPham_DAO();
	}
	
	@Override
	public List<KhuyenMai> getKhuyenMaiTheoTen(String tenSK) throws RemoteException {
		String query = "Select km from KhuyenMai km WHERE tenKhuyenMai = '"+tenSK+"'";
		return TimKiemKhuyenMaiTheoDieuKien(query);
	}
	@Override
	public List<SanPham> laySanPhamTheoMa(String txt) throws RemoteException {
		List<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_DAO.getDanhSachSanPham("SELECT sp FROM SanPham sp WHERE SanPhamID LIKE '%"+txt+"%'");
		return list;
	}
	@Override
	public List<SanPham> laySanPhamTheoTen(String txt) throws RemoteException {
		List<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_DAO.getDanhSachSanPham("SELECT sp FROM SanPham sp WHERE SanPhamID LIKE '%"+txt+"%'");
		return list;
	}
	@Override
	public List<KhuyenMai> TimKiemTheoDieuKien(String ma, String loai) throws RemoteException {
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		String queryTong = "FROM KhuyenMai";
		String queryma = "Select km from KhuyenMai km WHERE codeKhuyenMai like '%"+ma+"%'";
		String querymagt = "Select km from KhuyenMai km WHERE codeKhuyenMai like '%"+ma+"%' and LoaiGiamGia = 'Fixed'";
		String querymapt = "Select km from KhuyenMai km WHERE codeKhuyenMai like '%"+ma+"%' and LoaiGiamGia = 'Percentage'";
		String queryPhanTram = "Select km from KhuyenMai km WHERE km.loaiKhuyenMai = 'Percentage'";
		String queryGiaTri = "Select km from KhuyenMai km WHERE km.loaiKhuyenMai = 'Fixed'";
		if(ma.length() > 0) {
			switch (loai) {
		    case "Tất cả":
		        break;
		    case "Giá trị":
		        list = TimKiemKhuyenMaiTheoDieuKien(querymagt);
		        break;
		    case "Phần trăm":
		        list = TimKiemKhuyenMaiTheoDieuKien(querymapt);
		        break;
			}
		}
		else if(ma.length() <= 0) {
			switch (loai) {
		    case "Tất cả":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryTong);
		        break;
		    case "Giá trị":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		        break;
		    case "Phần trăm":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryGiaTri);
		        break;
			}
		}
		return list;
	}
	@Override
	public List<KhuyenMai> TimKiemTheoLoai(String hinhThuc) throws RemoteException {
		// TODO Auto-generated method stub
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		String queryTong = "FROM KhuyenMai";
		String queryPhanTram = "SELECT km FROM KhuyenMai km WHERE km.loaiKhuyenMai = 'PHAN_TRAM'";
		String queryGiaTri = "SELECT km FROM KhuyenMai km WHERE km.loaiKhuyenMai = 'GIA_TRI'";
		if(hinhThuc.equals("ALL")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryTong);
		}
		if(hinhThuc.equals("Percentage")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		}
		if(hinhThuc.equals("Fixed")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		}
		return list = null;
	}

}
