package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.KhachHang;
import entities.NhanVien;
import interfaces.IKhachHang;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import utilities.QueryBuilder;

public class KhachHang_DAO implements IKhachHang {
	private Connection conn ;

	public ArrayList<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) {
		  ArrayList<KhachHang> listKhachHang = new ArrayList<>();
		    String query = "SELECT * FROM KhachHang WHERE KhachHangID LIKE ? AND hoTen LIKE ? AND SoDienThoai LIKE ? AND GioiTinh = ? AND LoaiKhachHang = ?";
		    try {
		        PreparedStatement pstmt = conn.prepareStatement(query);
		        pstmt.setString(1, "%" + maKhachHang + "%");
		        pstmt.setString(2, "%" + tenKhachHang + "%");
		        pstmt.setString(3, "%" + soDienThoai + "%");
		        pstmt.setString(4, gioiTinh);
		        pstmt.setString(5, loaiKhachHang);

		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		            // Tạo đối tượng KhachHang từ kết quả tìm kiếm
		            KhachHang khachHang = new KhachHang(rs.getString("khachHangID"),
		                    rs.getString("hoTen"), rs.getString("soDienThoai"),
		                    rs.getDate("ngaySinh").toLocalDate(), rs.getString("gioiTinh"),
		                    rs.getString("email"), rs.getString("maSoThue"),
		                    rs.getString("diaChi"), rs.getString("loaiKhachHang"));

		            // Thêm đối tượng KhachHang vào danh sách
		            listKhachHang.add(khachHang);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return listKhachHang;
	}

	@Override
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> listKhachHang = new ArrayList<>();
		String query = "SELECT * FROM KhachHang";
		try  {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				KhachHang khachHang = new KhachHang();
				khachHang.setKhachHangID(rs.getString("khachHangID"));
				khachHang.setHoTen(rs.getString("hoTen"));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));

				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				if (ngaySinh != null) {
					khachHang.setNgaySinh(ngaySinh.toLocalDate());
				}
				khachHang.setGioiTinh(rs.getString("gioiTinh"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setMaSoThue(rs.getString("maSoThue"));
				;
				khachHang.setDiaChi(rs.getString("diaChi"));
				khachHang.setLoaiKhachHang(rs.getString("loaiKhachHang"));

				listKhachHang.add(khachHang);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listKhachHang;
	}

	@Override
	public int totalKhachHang() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addKhachHang(KhachHang kh) {

		boolean result = false;
		String query = "INSERT INTO KhachHang(KhachHangID,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,MaSoThue,DiaChi,LoaiKhachHang) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pretm = conn.prepareStatement(query);
			pretm.setString(1, kh.getKhachHangID());
			pretm.setString(2, kh.getHoTen());
			pretm.setString(3, kh.getSoDienThoai());
			pretm.setDate(4, Date.valueOf(kh.getNgaySinh()));
			pretm.setString(5, kh.getGioiTinh());
			pretm.setString(6, kh.getEmail());
			pretm.setString(7, kh.getMaSoThue());
			pretm.setString(8, kh.getDiaChi());
			pretm.setString(9, kh.getLoaiKhachHang());

			return (pretm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public KhachHang getKhachHangByKhachHangID(String ma) {
		KhachHang khachHang = null;
		String query = "SELECT *FRON KhachHang WHERE KhachHangID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				khachHang = new KhachHang(rs.getString("KhachHangID"), rs.getString("HoTen"), rs.getString("SoDienThoai"), rs.getDate("NgaySinh").toLocalDate(), rs.getString("GioiTinh"), rs.getString("Email"), rs.getString("MaSoThue"), rs.getString(" DiaChi"), rs.getString("LoaiKhachHang"));
			}
		} catch (Exception e) {
			System.out.println("không lấy đc nhân viên lớp getKhachHangByKhachHangID");
			e.printStackTrace();
		}
		return khachHang;
	}
	@Override
	public boolean editKhachHang(KhachHang kh) {
	    boolean result = false;

	    String query = "UPDATE KhachHang SET KhachHangID = ?, HoTen=?, SoDienThoai=?, NgaySinh=?, GioiTinh=?, Email=?, MaSoThue=?, DiaChi=?, LoaiKhachHang=? WHERE KhachHangID=?";
	    try {
	        PreparedStatement pretm = conn.prepareStatement(query);
	        pretm.setString(1, kh.getKhachHangID());
	        pretm.setString(2, kh.getHoTen());
	        pretm.setString(3, kh.getSoDienThoai());
	        pretm.setDate(4, Date.valueOf(kh.getNgaySinh()));
	        pretm.setString(5, kh.getGioiTinh());
	        pretm.setString(6, kh.getEmail());
	        pretm.setString(7, kh.getMaSoThue());
	        pretm.setString(8, kh.getDiaChi());
	        pretm.setString(9, kh.getLoaiKhachHang());
	        // Đặt giá trị cho tham số trong điều kiện WHERE (KhachHangID)
	        pretm.setString(10, kh.getKhachHangID());

	        return (pretm.executeUpdate() > 0) ? true : false;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("ketqua:"+result);
	    return result;
	}


	@Override
	public boolean deleteKhachHang(KhachHang kh) {
		 boolean result = false;

		    String query = "DELETE FROM KhachHang WHERE KhachHangID = ?";

		    try {
		        PreparedStatement pstmt = conn.prepareStatement(query);
		        pstmt.setString(1, kh.getKhachHangID());

		        return pstmt.executeUpdate() > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return result;
	}

	@Override
	public String getLayTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

        @Override
        public KhachHang getKhachHangTuMaVaSDT(String x) {
            KhachHang khachHang = null;
            try {
                String query = "SELECT * FROM KhachHang ?";
                QueryBuilder queryBuilder = new QueryBuilder(query);
                queryBuilder.addParameter(
                        QueryBuilder.Enum_DataType.STRING, 
                        "KhachHangID", 
                        "=", 
                        x);
                queryBuilder.addParameter(
                        QueryBuilder.Enum_DataType.STRING, 
                        "SoDienThoai", 
                        "=", 
                        x);
                ResultSet rs = queryBuilder.setParamsForPrepairedStament(connectDB.ConnectDB.getConnection(), "OR").executeQuery();
                if (rs.next()){
                    khachHang = new KhachHang();
                    String maKH = rs.getString("KhachHangID");
                    String hoTen = rs.getString("HoTen");
                    String soDienThoai = rs.getString("soDienThoai");
                    java.sql.Date ngaySinhTemp =  rs.getDate("NgaySinh");
                    LocalDate ngaySinh = null;
                    if (ngaySinhTemp != null)
                        ngaySinh = ngaySinhTemp.toLocalDate();
                    String gt = rs.getString("GioiTinh");
                    String email = rs.getString("Email");
                    String maSoThue = rs.getString("MaSoThue");
                    String diaChi = rs.getString("DiaChi");
                    String loaiKhachHang = rs.getString("LoaiKhachHang");
                    khachHang = new KhachHang(maKH, hoTen, soDienThoai, ngaySinh, gt, email, maSoThue, diaChi, loaiKhachHang);
                }
                return khachHang;
            } catch (Exception e) {
                return null;
            }
            
        }
        
	

	public ArrayList<NhanVien> findKhachHang(String x) {
		// TODO Auto-generated method stub
		return null;
	}
	public String phatSinhMaKhachHang() {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM KhachHang");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count =rs.getInt(1);
			return "KH"+String.format("%04d", count+1);
		} catch (Exception e) {
			System.out.println("Lỗi phát sinh mã bên DAO");
			return "KH"+"0001";
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
	
	
	public KhachHang_DAO() {
		this.conn=ConnectDB.getConnection();
	}
        
}
