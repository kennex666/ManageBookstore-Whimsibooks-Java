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
import java.time.LocalDate;
import java.util.List;
import utilities.QueryBuilder;
import utilities.QueryBuilder.Enum_DataType;

public class NhanVien_DAO implements INhanVien {
	private Connection conn;

	public ArrayList<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai,
			String gioiTinh, String chucVu) {
		ArrayList<NhanVien> listNhanVien = new ArrayList<>();
		String query = "SELECT * FROM NhanVien WHERE NhanVienID LIKE ? AND hoTen LIKE ? AND SoDienThoai LIKE ? ";
		try {
			QueryBuilder qb = new QueryBuilder("SELECT * FROM NhanVien ?");
			qb.addParameter(Enum_DataType.STRING, "NhanVienID", "%?%", maNhanVien.isBlank() ? null : maNhanVien);
			qb.addParameter(Enum_DataType.STRING, "HoTen", "%?%", tenNhanVien.isBlank() ? null : tenNhanVien);
			qb.addParameter(Enum_DataType.STRING, "SoDienThoai", "%?%", soDienThoai.isBlank() ? null : soDienThoai);

			PreparedStatement pstmt = qb.setParamsForPrepairedStament(conn, "AND");
//	    	PreparedStatement pstmt = conn.prepareStatement(query);
//	        pstmt.setString(1, "%" + maNhanVien + "%");
//	        pstmt.setString(2, "%" + tenNhanVien + "%");
//	        pstmt.setString(3, "%" + soDienThoai + "%");
//	        pstmt.setString(4, gioiTinh);
//	        pstmt.setString(5, chucVu);

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
	public ArrayList<NhanVien> getAllEmployees() {
		ArrayList<NhanVien> listNhanVien = new ArrayList<>();
		try {
			String query = "SELECT * FROM NhanVien";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
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
			// Đặt giá trị cho tham số trong điều kiện WHERE (nhanVienID)
			pretm.setString(12, x.getNhanVienID());
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

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
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
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NhanVien");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public ArrayList<NhanVien> findEmployee(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	public NhanVien_DAO() {
		this.conn = ConnectDB.getConnection();
	}

	@Override
	public NhanVien dangNhapNhanVien(String user, String password) {

		NhanVien nhanVien = null;
		try {
			PreparedStatement pstm = conn
					.prepareStatement("SELECT * FROM NhanVien WHERE UserName = ? AND Password = ?");
			pstm.setString(1, user);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				nhanVien = new NhanVien(rs.getString("nhanVienID"), rs.getString("userName"), rs.getString("password"),
						rs.getDate("ngayTaoTK").toLocalDate(), rs.getString("hoTen"), rs.getString("gioiTinh"),
						rs.getString("soDienThoai"), rs.getString("chucVu"), rs.getString("email"),
						rs.getDate("ngaySinh").toLocalDate(), rs.getString("diaChi"));
			}
			return nhanVien;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String getNhanVienEmailViaUsername(String username) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstm = conn.prepareStatement("SELECT email FROM NhanVien WHERE UserName = ?");
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getString("email");
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean resetUserPassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstm = conn.prepareStatement("UPDATE NhanVien SET password = ? WHERE UserName = ?");
			pstm.setString(1, newPassword);
			pstm.setString(2, username);
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

}
