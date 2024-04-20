package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entities.NhanVien;
import interfaces.INhanVien;
import jakarta.persistence.EntityManager;
import ultilities.ProcessingEnumDBForQuy;
import ultilities.QueryBuilder;
import ultilities.QueryBuilder.Enum_DataType;

import java.time.LocalDate;
import java.util.List;

public class NhanVien_DAO extends UnicastRemoteObject implements INhanVien{

    private EntityManager em;

    public List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai,
            String gioiTinh, String chucVu) throws RemoteException{
    	
    	gioiTinh = ProcessingEnumDBForQuy.gioiTinhToEnum(gioiTinh);

    	chucVu = ProcessingEnumDBForQuy.convertNhanVienRolesToEnum(chucVu);
        List<NhanVien> listNhanVien = new ArrayList<>();

        String query = "SELECT nv FROM NhanVien nv WHERE nhanVienID LIKE :id AND hoTen LIKE :hoTen AND soDienThoai LIKE :sdt ";

        // Tạo một danh sách tham số để lưu giữ các tham số có thể trống
        List<String> parameters = new ArrayList<>();

        // Thêm các giá trị vào danh sách tham số
        parameters.add(maNhanVien.isBlank() ? "%" : "%" + maNhanVien + "%");
        parameters.add(tenNhanVien.isBlank() ? "%" : "%" + tenNhanVien + "%");
        parameters.add(soDienThoai.isBlank() ? "%" : "%" + soDienThoai + "%");
        
        // GioiTinh: bug Nu - Male
        
//        parameters.add(gioiTinh.isBlank() ? "%" : "%" + gioiTinh + "%");
        if(gioiTinh.isBlank())
        	query += "AND gioiTinh like '%' ";
        else {
			if (gioiTinh.equalsIgnoreCase("NAM"))
				query += "AND gioiTinh like 'NAM' ";
			else
				query += "AND gioiTinh not like 'NAM' ";
        }
        //Chuc vu: 
//        parameters.add(chucVu.isBlank() ? "%" : "%" + chucVu + "%");
        if(chucVu.isBlank())
        	query += "AND chucVu like '%' ";
        else {
			if (chucVu.equals("NHAN_VIEN_BAN_HANG"))
				query += "AND chucVu like 'NHAN_VIEN_BAN_HANG' ";
			else
				query += "AND chucVu not like 'NHAN_VIEN_BAN_HANG' ";
        }

        try {
        	
			listNhanVien = em.createQuery(query, NhanVien.class).setParameter("id", parameters.get(0))
					.setParameter("hoTen", parameters.get(1)).setParameter("sdt", parameters.get(2)).getResultList();
	
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    @Override
    public List<NhanVien> getAllEmployees() throws RemoteException{
    	try {
			return em.createQuery("FROM NhanVien", NhanVien.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public int totalNhanVien() throws RemoteException{
        // TODO Auto-generated method stub
    	try {
    	    Long count = em.createQuery("SELECT COUNT(nv) FROM NhanVien nv", Long.class).getSingleResult();
    	    return count.intValue(); 
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    return 0;
    	}
    }

    @Override
    public boolean addNhanVien(NhanVien x) throws RemoteException{
    	try {
			em.getTransaction().begin();
			em.persist(x);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
    	}
    }

    @Override
    public boolean editNhanVien(NhanVien x) throws RemoteException{
		try {
			em.getTransaction().begin();
			em.merge(x);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public boolean deleteNhanVien(NhanVien x) throws RemoteException{
		try {
			em.getTransaction().begin();
			em.remove(x);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public String getTenTuMa(String x) throws RemoteException{
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NhanVien getNhanVienByNhanVienID(String x) throws RemoteException{
		try {
			em.getTransaction().begin();
			NhanVien nv = em.find(NhanVien.class, x);
			em.getTransaction().commit();
			return nv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public boolean isMaNhanVienExists(String x) throws RemoteException {
		try {
			return em.find(NhanVien.class, x) != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
    }

    @Override
    public int phatSinhMaNhanVien() throws RemoteException {
        try {
        	Long count = em.createQuery("SELECT COUNT(nv) FROM NhanVien nv", Long.class).getSingleResult();
        	return count.intValue() + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // Trả về 1 nếu có lỗi
        }

    }

    @Override
    public List<NhanVien> findEmployee(String x) throws RemoteException{
        // TODO Auto-generated method stub
        return null;
    }

    public boolean chuyenChucVuNhanVienCu(String maNhanVien) throws RemoteException{
    	try {
			return em.createQuery("UPDATE NhanVien SET chucVu = ? WHERE nhanVienID = ?")
					.setParameter(1, "NHAN_VIEN_CU")
					.setParameter(2, maNhanVien).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    
    }

    public NhanVien_DAO() throws RemoteException{
    	em = ConnectDB.getEntityManager();
    }

    @Override
    public NhanVien dangNhapNhanVien(String user, String password) throws RemoteException{

		try {
			return em.createQuery("FROM NhanVien WHERE userName = :user AND password = :password", NhanVien.class)
					.setParameter("user", user).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public String getNhanVienEmailViaUsername(String username) throws RemoteException{
    	try {
			return em.createQuery("SELECT email FROM NhanVien WHERE userName = :username", String.class)
					.setParameter("username", username).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public boolean resetUserPassword(String username, String newPassword) throws RemoteException{
    	try {
			return em.createQuery("UPDATE NhanVien SET password = :newPassword WHERE userName = :username")
					.setParameter("newPassword", newPassword).setParameter("username", username).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

}
