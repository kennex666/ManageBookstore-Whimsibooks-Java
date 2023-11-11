package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.NhanVien;
import interfaces.INhanVien;

public class NhanVien_DAO implements INhanVien {
	Connection conn;
	@Override
	public ArrayList<NhanVien> findEmployee(String x) {

		ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		String query = "SELECT *From NhanVien where hoTen like ? OR NhanVienID =? OR SoDienThoai like ?";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, "%" + x + "%"); // Tìm theo tên
			pstmt.setString(2, x); // tìm theo mã
			pstmt.setString(3, "%" + x + "%"); // tìm theo Số điện thoại bọc đầu cuối.

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("nhanVienID"), rs.getString("userName"),
						rs.getString("password"), rs.getDate("ngayTaoTK").toLocalDate(), rs.getString("hoTen"),
						rs.getString("gioiTinh"), rs.getString("soDienThoai"), rs.getString("chucVu"),
						rs.getString("email"), rs.getDate("ngaySinh").toLocalDate(), rs.getString("diaChi")

				);
				listNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
                    return listNhanVien;
		}
		return listNhanVien;
	}

	@Override
	public ArrayList<NhanVien> getAllEmployees() {
		ArrayList<NhanVien> listNhanVien = new ArrayList<>();
		String query = "SELECT * FROM NhanVien";
		try (PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setNhanVienID(rs.getString("nhanVienID"));
				nhanVien.setUserName(rs.getString("userName"));
				nhanVien.setPassword(rs.getString("password"));

				java.sql.Date ngayTaoTKSQL = rs.getDate("ngayTaoTK");
				if (ngayTaoTKSQL != null) {
					nhanVien.setNgayTaoTK(ngayTaoTKSQL.toLocalDate());
				}

				nhanVien.setHoTen(rs.getString("hoTen"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
				nhanVien.setChucVu(rs.getString("chucVu"));
				nhanVien.setEmail(rs.getString("email"));

				java.sql.Date ngaySinhSQL = rs.getDate("ngaySinh");
				if (ngaySinhSQL != null) {
					nhanVien.setNgaySinh(ngaySinhSQL.toLocalDate());
				}

				nhanVien.setDiaChi(rs.getString("diaChi"));
				listNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
                    return listNhanVien;
		}

		return listNhanVien;
	}

	@Override
	public int totalNhanVien() {
		// TODO Auto-generated method stub
		int soLuong = 0;
		try {
			Connection conn = ConnectDB.getConnection();
			String query = "SELECT Count(*) AS soLuong FROM NhanVien ";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return rs.getInt("soLuong");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return soLuong;
	}

	@Override
	public boolean addNhanVien(NhanVien x) {
		boolean result = false;
		String query = "INSERT INTO NhanVien(NhanVienID,UserName,Password,NgayTaoTK,HoTen,GioiTinh,SoDienThoai,ChucVu,Email,NgaySinh,DiaChi) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pretm = conn.prepareStatement(query);
			pretm.setString(1, x.getNhanVienID());
			pretm.setString(2, x.getUserName());
			pretm.setString(3, x.getPassword());
			pretm.setDate(4, Date.valueOf(x.getNgayTaoTK()));
			pretm.setString(5, x.getHoTen());
			pretm.setString(6, x.getGioiTinh());
			pretm.setString(7, x.getSoDienThoai());
			pretm.setString(8, x.getChucVu());
			pretm.setString(9, x.getEmail());
			pretm.setDate(10, Date.valueOf(x.getNgaySinh()));
			pretm.setString(11, x.getDiaChi());

			return (pretm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
//				return false;
		}
		return result;
	}

	@Override
	public boolean editNhanVien(NhanVien x) {
		boolean result = false;
		String query = "UPDATE NhanVien SET NhanVienID =?,UserName=?,Password=?,NgayTaoTK =?,HoTen = ?,GioiTinh = ?,SoDienThoai = ?,ChucVu = ?,Email= ?,NgaySinh =?,DiaChi=? where nhanVienID =?";
		try {
			PreparedStatement pretm = conn.prepareStatement(query);
			pretm.setString(1, x.getNhanVienID());
			pretm.setString(2, x.getUserName());
			pretm.setString(3, x.getPassword());
			pretm.setDate(4, Date.valueOf(x.getNgayTaoTK()));
			pretm.setString(5, x.getHoTen());
			pretm.setString(6, x.getGioiTinh());
			pretm.setString(7, x.getSoDienThoai());
			pretm.setString(8, x.getChucVu());
			pretm.setString(9, x.getEmail());
			pretm.setDate(10, Date.valueOf(x.getNgaySinh()));
			pretm.setString(11, x.getDiaChi());
			return (pretm.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
//				return false;
		}
		return result;
	}

	@Override
	public boolean deleteNhanVien(NhanVien x) {
		boolean result = false;
		String query = "DELETE FROM NhanVien WHERE NhanVienID = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, x.getNhanVienID());

			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien getNhanVienByNhanVienID(String x) {
		NhanVien nhanVien = null;
		String query = "SELECT * FROM NhanVien WHERE nhanVienID = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, x);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				nhanVien = new NhanVien(rs.getString("nhanVienID"), rs.getString("userName"), rs.getString("password"),
						rs.getDate("ngayTaoTK").toLocalDate(), rs.getString("hoTen"), rs.getString("gioiTinh"),
						rs.getString("soDienThoai"), rs.getString("chucVu"), rs.getString("email"),
						rs.getDate("ngaySinh").toLocalDate(), rs.getString("diaChi")

				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nhanVien;
	}

	@Override
	public boolean isMaNhanVienExists(String x) {
		String query = "SELECT COUNT(*) FROM NhanVien WHERE nhanVienID = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, x);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // Trả về true nếu mã nhân viên đã tồn tại
			}
		} catch (Exception e) {
			System.out.println("lỗi mã đã có rồi nha");
		}

		return false; // Trả về false nếu có lỗi hoặc mã nhân viên không tồn tại
	}

	
	
	@Override
	public int phatSinhMaNhanVien() {
		try {
			PreparedStatement ps =conn.prepareStatement("SELECT COUNT(*) FROM NhanVien");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count= rs.getInt(1);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	public NhanVien_DAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}
	
}
