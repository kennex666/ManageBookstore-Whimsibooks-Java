package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entities.NhanVien;
import gui.TAB_NhanVien;
import interfaces.INhanVien;
import jakarta.persistence.EntityManager;
import ultilities.ProcessingEnumDBForQuy;
import ultilities.QueryBuilder;
import ultilities.QueryBuilder.Enum_DataType;

import java.time.LocalDate;
import java.util.List;

public class NhanVien_DAO implements INhanVien {

    private EntityManager em;

    public List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai,
            String gioiTinh, String chucVu) {
    	
    	gioiTinh = ProcessingEnumDBForQuy.gioiTinhToEnum(gioiTinh);

    	chucVu = ProcessingEnumDBForQuy.convertNhanVienRolesToEnum(chucVu);
        List<NhanVien> listNhanVien = new ArrayList<>();

        String query = "SELECT nv FROM NhanVien nv WHERE nhanVienID LIKE :id AND hoTen LIKE :hoTen AND soDienThoai LIKE :sdt AND gioiTinh LIKE :gioiTinh AND chucVu LIKE :chucVu";

        // Tạo một danh sách tham số để lưu giữ các tham số có thể trống
        List<String> parameters = new ArrayList<>();

        // Thêm các giá trị vào danh sách tham số
        parameters.add(maNhanVien.isBlank() ? "%" : "%" + maNhanVien + "%");
        parameters.add(tenNhanVien.isBlank() ? "%" : "%" + tenNhanVien + "%");
        parameters.add(soDienThoai.isBlank() ? "%" : "%" + soDienThoai + "%");
        parameters.add(gioiTinh.isBlank() ? "%" : "%" + gioiTinh + "%");
        parameters.add(chucVu.isBlank() ? "%" : "%" + chucVu + "%");


        try {
        	
			listNhanVien = em.createQuery(query, NhanVien.class).setParameter("id", parameters.get(0))
					.setParameter("hoTen", parameters.get(1)).setParameter("sdt", parameters.get(2))
					.setParameter("gioiTinh", parameters.get(3)).setParameter("chucVu", parameters.get(4))
					.getResultList();
			
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    @Override
    public List<NhanVien> getAllEmployees() {
    	try {
			return em.createQuery("FROM NhanVien", NhanVien.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public int totalNhanVien() {
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
    public boolean addNhanVien(NhanVien x) {
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
    public boolean editNhanVien(NhanVien x) {
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
    public boolean deleteNhanVien(NhanVien x) {
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
    public String getTenTuMa(String x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NhanVien getNhanVienByNhanVienID(String x) {
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
    public boolean isMaNhanVienExists(String x) {
		try {
			return em.find(NhanVien.class, x) != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
    }

    @Override
    public int phatSinhMaNhanVien() {
        try {
        	Long count = em.createQuery("SELECT COUNT(nv) FROM NhanVien nv", Long.class).getSingleResult();
        	return count.intValue() + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // Trả về 1 nếu có lỗi
        }

    }

    @Override
    public List<NhanVien> findEmployee(String x) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean chuyenChucVuNhanVienCu(String maNhanVien) {
    	try {
			return em.createQuery("UPDATE NhanVien SET chucVu = ? WHERE nhanVienID = ?")
					.setParameter(1, "NHAN_VIEN_CU")
					.setParameter(2, maNhanVien).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    
    }

    public NhanVien_DAO() {
    	em = ConnectDB.getEntityManager();
    }

    @Override
    public NhanVien dangNhapNhanVien(String user, String password) {

		try {
			return em.createQuery("FROM NhanVien WHERE userName = :user AND password = :password", NhanVien.class)
					.setParameter("user", user).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public String getNhanVienEmailViaUsername(String username) {
    	try {
			return em.createQuery("SELECT email FROM NhanVien WHERE userName = :username", String.class)
					.setParameter("username", username).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public boolean resetUserPassword(String username, String newPassword) {
    	try {
			return em.createQuery("UPDATE NhanVien SET password = :newPassword WHERE userName = :username")
					.setParameter("newPassword", newPassword).setParameter("username", username).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

}
