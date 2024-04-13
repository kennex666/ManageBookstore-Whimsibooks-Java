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

    private Connection conn;
    private EntityManager em;

    public List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai,
            String gioiTinh, String chucVu) {
    	
    	gioiTinh = ProcessingEnumDBForQuy.gioiTinhToEnum(gioiTinh);

    	chucVu = ProcessingEnumDBForQuy.convertNhanVienRolesToEnum(chucVu);
        List<NhanVien> listNhanVien = new ArrayList<>();

        String query = "SELECT * FROM NhanVien WHERE NhanVienID LIKE ? AND hoTen LIKE ? AND SoDienThoai LIKE ?";

        // Tạo một danh sách tham số để lưu giữ các tham số có thể trống
        List<String> parameters = new ArrayList<>();

        // Thêm các giá trị vào danh sách tham số
        parameters.add(maNhanVien.isBlank() ? "%" : "%" + maNhanVien + "%");
        parameters.add(tenNhanVien.isBlank() ? "%" : "%" + tenNhanVien + "%");
        parameters.add(soDienThoai.isBlank() ? "%" : "%" + soDienThoai + "%");

        // Xây dựng phần câu truy vấn dựa trên giới tính và chức vụ
        if (!gioiTinh.isBlank()) {
            query += " AND GioiTinh = ?";
            parameters.add(gioiTinh);
        }

        if (!chucVu.isBlank()) {
            query += " AND ChucVu = ?";
            parameters.add(chucVu);
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Thiết lập các giá trị tham số
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setString(i + 1, parameters.get(i));
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Tạo đối tượng NhanVien từ kết quả tìm kiếm
                NhanVien nhanVien = new NhanVien(rs.getString("nhanVienID"), rs.getString("userName"),
                        rs.getString("password"), rs.getDate("ngayTaoTK").toLocalDate(), rs.getString("hoTen"),
                        rs.getString("gioiTinh"), rs.getString("soDienThoai"), rs.getString("chucVu"),
                        rs.getString("email"), rs.getDate("ngaySinh").toLocalDate(), rs.getString("diaChi"));

                // Thêm đối tượng NhanVien vào danh sách
                listNhanVien.add(nhanVien);
            }
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
//        int soLuong = 0;
//        try {
//            String query = "SELECT Count(*) AS soLuong FROM NhanVien";
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            if (rs.next()) {
//                return rs.getInt("soLuong");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // TODO: handle exception
//        }
//        return soLuong;
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
//        boolean result = false;
//        TAB_NhanVien maNVTD = new TAB_NhanVien();
//        String maNV = maNVTD.phatSinhMaNhanVien();
//
//        String query = "INSERT INTO NhanVien(NhanVienID,UserName,Password,NgayTaoTK,HoTen,GioiTinh,SoDienThoai,ChucVu,Email,NgaySinh,DiaChi) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement pretm = conn.prepareStatement(query);
//            pretm.setString(1, maNV);
//            pretm.setString(2, x.getUserName());
//            pretm.setString(3, x.getPassword());
//            pretm.setDate(4, Date.valueOf(x.getNgayTaoTK()));
//            pretm.setString(5, x.getHoTen());
//            pretm.setString(6, x.getGioiTinh());
//            pretm.setString(7, x.getSoDienThoai());
//            pretm.setString(8, x.getChucVu());
//            pretm.setString(9, x.getEmail());
//            pretm.setDate(10, Date.valueOf(x.getNgaySinh()));
//            pretm.setString(11, x.getDiaChi());
//
//            return (pretm.executeUpdate() > 0) ? true : false;
//        } catch (Exception e) {
//            e.printStackTrace();
////				return false;
//        }
//        return result;
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
//        boolean result = false;
//        String query = "UPDATE NhanVien SET NhanVienID =?,UserName=?,Password=?,NgayTaoTK =?,HoTen = ?,GioiTinh = ?,SoDienThoai = ?,ChucVu = ?,Email= ?,NgaySinh =?,DiaChi=? where nhanVienID =?";
//        try {
//            PreparedStatement pretm = conn.prepareStatement(query);
//            pretm.setString(1, x.getNhanVienID());
//            pretm.setString(2, x.getUserName());
//            pretm.setString(3, x.getPassword());
//            pretm.setDate(4, Date.valueOf(x.getNgayTaoTK()));
//            pretm.setString(5, x.getHoTen());
//            pretm.setString(6, x.getGioiTinh());
//            pretm.setString(7, x.getSoDienThoai());
//            pretm.setString(8, x.getChucVu());
//            pretm.setString(9, x.getEmail());
//            pretm.setDate(10, Date.valueOf(x.getNgaySinh()));
//            pretm.setString(11, x.getDiaChi());
//            // Đặt giá trị cho tham số trong điều kiện WHERE (nhanVienID)
//            pretm.setString(12, x.getNhanVienID());
//            return (pretm.executeUpdate() > 0) ? true : false;
//        } catch (Exception e) {
//            e.printStackTrace();
////				return false;
//        }
//        return result;
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
//        boolean result = false;
//        String query = "DELETE FROM NhanVien WHERE NhanVienID = ?";
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, x.getNhanVienID());
//
//            return pstmt.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
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
//        NhanVien nhanVien = null;
//        String query = "SELECT * FROM NhanVien WHERE nhanVienID = ?";
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, x);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//
//                nhanVien = new NhanVien(
//                        rs.getString("nhanVienID"),
//                        rs.getString("userName"),
//                        rs.getString("password"),
//                        rs.getDate("ngayTaoTK").toLocalDate(),
//                        rs.getString("hoTen"),
//                        rs.getString("gioiTinh"), // Giữ nguyên giá trị giới tính đã được chuyển đổi
//                        rs.getString("soDienThoai"),
//                        rs.getString("chucVu"),
//                        rs.getString("email"),
//                        rs.getDate("ngaySinh").toLocalDate(),
//                        rs.getString("diaChi")
//                );
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return nhanVien;
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
//        String query = "SELECT COUNT(*) FROM NhanVien WHERE nhanVienID = ?";
//
//        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
//            pstmt.setString(1, x);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                int count = rs.getInt(1);
//                return count > 0; // Trả về true nếu mã nhân viên đã tồn tại
//            }
//        } catch (Exception e) {
//            System.out.println("lỗi mã đã có rồi nha");
//        }
//
//        return false; // Trả về false nếu có lỗi hoặc mã nhân viên không tồn tại
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
//            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NhanVien");
//            ResultSet rs = ps.executeQuery();
//            rs.next();
//            int count = rs.getInt(1);
//            return count + 1;
            //public int phatSinhMaNhanVien() {
            //try {
            // Tìm mã nhân viên cuối cùng trong cơ sở dữ liệu
            //String query = "SELECT MAX(CAST(SUBSTRING(NhanVienID, 3, LEN(NhanVienID)) AS INT)) FROM NhanVien";
            //PreparedStatement ps = conn.prepareStatement(query);
            //ResultSet rs = ps.executeQuery();
            //rs.next();
            //int lastId = rs.getInt(1);

            // Phát sinh mã nhân viên mới
            //return lastId + 1;
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
//        String query = "UPDATE NhanVien SET ChucVu = ? WHERE NhanVienID = ?";
//        try {
//
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, "NHAN_VIEN_CU");
//            pstmt.setString(2, maNhanVien);
//
//            int rowsAffected = pstmt.executeUpdate();
//            return rowsAffected > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
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
        this.conn = ConnectDB.getConnection();
    }

    @Override
    public NhanVien dangNhapNhanVien(String user, String password) {
//
//        NhanVien nhanVien = null;
//        try {
//            PreparedStatement pstm = conn
//                    .prepareStatement("SELECT * FROM NhanVien WHERE UserName = ? AND Password = ?");
//            pstm.setString(1, user);
//            pstm.setString(2, password);
//            ResultSet rs = pstm.executeQuery();
//            if (rs.next()) {
//                nhanVien = new NhanVien(rs.getString("nhanVienID"), rs.getString("userName"), rs.getString("password"),
//                        rs.getDate("ngayTaoTK").toLocalDate(), rs.getString("hoTen"), rs.getString("gioiTinh"),
//                        rs.getString("soDienThoai"), rs.getString("chucVu"), rs.getString("email"),
//                        rs.getDate("ngaySinh").toLocalDate(), rs.getString("diaChi"));
//            }
//            return nhanVien;
//        } catch (Exception e) {
//            return null;
//        }
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
//        // TODO Auto-generated method stub
//        try {
//            PreparedStatement pstm = conn.prepareStatement("SELECT email FROM NhanVien WHERE UserName = ?");
//            pstm.setString(1, username);
//            ResultSet rs = pstm.executeQuery();
//            if (rs.next()) {
//                return rs.getString("email");
//            }
//            return null;
//        } catch (Exception e) {
//            return null;
//        }
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
        // TODO Auto-generated method stub
//        try {
//            PreparedStatement pstm = conn.prepareStatement("UPDATE NhanVien SET password = ? WHERE UserName = ?");
//            pstm.setString(1, newPassword);
//            pstm.setString(2, username);
//            return pstm.executeUpdate() > 0;
//        } catch (Exception e) {
//            return false;
//        }
    	try {
			return em.createQuery("UPDATE NhanVien SET password = :newPassword WHERE userName = :username")
					.setParameter("newPassword", newPassword).setParameter("username", username).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

}
