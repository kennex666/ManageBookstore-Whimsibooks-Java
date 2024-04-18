package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import interfaces.IHoaDon;
import interfaces.IHoaDonTra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ultilities.QueryBuilder;

public class HoaDonTra_DAO extends UnicastRemoteObject implements IHoaDonTra {

    private EntityManager em;
    
    public HoaDonTra_DAO() throws RemoteException{
        // TODO Auto-generated constructor stub
        em = ConnectDB.getEntityManager();
    }

    @Override
    public boolean createHoaDon(HoaDonTra x) throws RemoteException{
        // TODO Auto-generated method stub
    	boolean isThisSession = em.getTransaction().isActive();
		if (x.getKhachHang() == null) {
			x.setKhachHang(new KhachHang("KH0001"));
		}

		if (x.getNhanVien() == null) {
			x.setNhanVien(new NhanVien("NV0001"));
		}
		
		x.setTongHoan(x.tinhTongHoan());
		x.setNgayTraHoaDon(new Date());

	
        try {
			if (isThisSession == false)
				em.getTransaction().begin();
			em.persist(x);
			if (isThisSession == false)
				em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
        
	}

    @Override
    public boolean updateHoaDon(HoaDonTra x) throws RemoteException{
    	boolean isThisSession = em.getTransaction().isActive();
		try {
			if (x.getKhachHang() == null) {
				x.setKhachHang(new KhachHang("KH0001"));
			}

			if (x.getNhanVien() == null) {
				x.setNhanVien(new NhanVien("NV0001"));
			}


			x.setNgayTraHoaDon(new Date());

			x.setTongHoan(x.tinhTongHoan());

			if (isThisSession == false)
				em.getTransaction().begin();

			List<ChiTietTraHang> tempList = x.getListChiTietHoaDon();
			x.setListChiTietHoaDon(null);
			em.merge(x);
			if (isThisSession == false)
				em.getTransaction().commit();

			x.setListChiTietHoaDon(tempList);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public boolean cancelHoaDon(HoaDonTra x) throws RemoteException{
      
        boolean isThisSession = em.getTransaction().isActive();
		try {
			x.setTrangThai("HUY_BO");
			if (isThisSession == false)
				em.getTransaction().begin();

			List<ChiTietTraHang> tempList = x.getListChiTietHoaDon();
			x.setListChiTietHoaDon(null);
			em.merge(x);
			if (isThisSession == false)
				em.getTransaction().commit();

			x.setListChiTietHoaDon(tempList);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
    }

    @Override
    public List<HoaDonTra> getDanhSachHoaDon() throws RemoteException{
        List<HoaDonTra> listHoaDon = new ArrayList<HoaDonTra>();
        try {
            listHoaDon = em.createNamedQuery("HoaDonTra.findAll").getResultList();
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return listHoaDon;
        }
    }

    @Override
    public List<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) throws RemoteException{
        // TODO Auto-generated method stub
        List<HoaDonTra> listHoaDon = new ArrayList<HoaDonTra>();

        String query = "SELECT * FROM HoaDonTra hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID ?";

        try {
            QueryBuilder queryBuilder = new QueryBuilder(query);
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    ">=",
                    batDau
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    "<=",
                    ketThuc
            );
            String nativeQuery = (String) queryBuilder.generateQueryWithValue("AND")[1];
            
            listHoaDon = em.createNativeQuery(nativeQuery, HoaDonTra.class).getResultList();
            
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return listHoaDon;
        }
    }

    public HashMap<String, Object[]> getObjectThongKeXuHuong(Date batDau, Date ketThuc) throws RemoteException{
        // TODO Auto-generated1 method stub
        HashMap<String, Object[]> listHoaDon = new HashMap<String, Object[]>();

        String query = "SELECT sp.Barcode, SUM(SoLuong) AS SoLuongTraHang, SUM(DonGia * SoLuong) AS TongGiaTriTra FROM SanPham sp JOIN ChiTietTraHang ctth ON sp.SanPhamID = ctth.SanPhamID JOIN HoaDonTra hdt ON ctth.HoaDonID = hdt.HoaDonID ? GROUP BY Barcode";

        try {
            QueryBuilder queryBuilder = new QueryBuilder(query);
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    ">=",
                    batDau
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    "<=",
                    ketThuc
            );
            
            String nativeQuery = (String) queryBuilder.generateQueryWithValue("AND")[1];

	        TypedQuery<Object[]> tq = em.createNamedQuery(nativeQuery, Object[].class);
	        
	        tq.getResultList().forEach(obj -> {
				Object[] tempObj = { (long) obj[1], (double) obj[2] };
				listHoaDon.put((String) obj[0], tempObj);
			});
            
    
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return new HashMap<String, Object[]>();
        }
    }

    @Override
    public List<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params) throws RemoteException{
        // TODO Auto-generated method stub
        List<HoaDonTra> listHoaDon = new ArrayList<HoaDonTra>();

        String query = "SELECT * FROM HoaDonTra hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID ?";

        try {
            QueryBuilder queryBuilder = new QueryBuilder(query);
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    ">",
                    params[0]
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    "<=",
                    params[1]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "TrangThai",
                    "=",
                    params[2]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.DOUBLE,
                    "TongTien",
                    ">=",
                    params[3]
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.DOUBLE,
                    "TongTien",
                    "<=",
                    params[4]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "HoaDonID",
                    "%?%",
                    params[5]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "hd.KhachHangID",
                    "%?%",
                    params[6]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "hd.NhanVienID",
                    "%?%",
                    params[7]
            );

            String nativeQuery = (String) queryBuilder.generateQueryWithValue("AND")[0];
        
            listHoaDon = em.createNamedQuery(nativeQuery, HoaDonTra.class).getResultList();
            
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return listHoaDon;
        }
    }

    @Override
    public HoaDonTra getHoaDonByID(HoaDonTra hd) throws RemoteException{
        try {
            hd = (HoaDonTra) em.createNamedQuery("HoaDonTra.findByID").setParameter("hoaDonID", hd.getHoaDonID()).getSingleResult();

            return hd;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getSoHoaDonTrongNgay() throws RemoteException{
        // TODO Auto-generated method stub
        try {
            return (int) em.createNamedQuery("HoaDonTra.countToday").getSingleResult();
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

}
