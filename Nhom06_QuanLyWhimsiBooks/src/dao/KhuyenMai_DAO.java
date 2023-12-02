package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import connectDB.ConnectDB;
import entities.ChiTietKhuyenMai;
import entities.HoaDon;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import entities.SanPham;
import interfaces.IKhuyenMai;
import utilities.QueryBuilder;

public class KhuyenMai_DAO implements IKhuyenMai {
	private Connection conn;

	@Override
	public ArrayList<KhuyenMai> getAllKhuyenMai() {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM KhuyenMai";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"),
							rs.getInt("SoLuotDaApDung"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm = conn.createStatement();
			String query = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%" + maKhuyenMai + "%'";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"),
							rs.getInt("SoLuotDaApDung"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm = conn.createStatement();
			String query = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%" + maKhuyenMai
					+ "%' or TenKhuyenMai like '%" + tenKM + "%'";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"),
							rs.getInt("SoLuotDaApDung"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"),
							rs.getInt("SoLuotDaApDung"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<KhuyenMai> SapXepKhuyenMaiTheoGiaTri(String maKhuyenMai) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm = conn.createStatement();
			String query = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%" + maKhuyenMai + "%'";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addKhuyenMai(KhuyenMai khuyenMai) {
		String codeKhuyenMai = khuyenMai.getCodeKhuyenMai();
		String tenKhuyenMai = khuyenMai.getTenKhuyenMai();
		String loaiKhuyenMai = khuyenMai.getLoaiKhuyenMai();
		double giaTri = khuyenMai.getGiaTri();
		Date ngayKhuyenMai = khuyenMai.getNgayKhuyenMai();
		Date ngayHetHanKM = khuyenMai.getNgayHetHanKM();
		double donHangTu = khuyenMai.getDonHangTu();
		int soLuongKhuyenMai = khuyenMai.getSoLuongKhuyenMai();
		int soLuotDaApDung = khuyenMai.getSoLuotDaApDung();

		String insertKM = "INSERT INTO KhuyenMai (CodeKhuyenMai, TenKhuyenMai, LoaiGiamGia, GiaTri,NgayKhuyenMai, NgayHetHanKM, DonHangTu, SoLuongKhuyenMai,SoLuotDaApDung) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertKM);
			preparedStatement.setString(1, codeKhuyenMai);
			preparedStatement.setString(2, tenKhuyenMai);
			preparedStatement.setString(3, loaiKhuyenMai);
			preparedStatement.setDouble(4, giaTri);
			preparedStatement.setDate(5, ngayKhuyenMai);
			preparedStatement.setDate(6, ngayHetHanKM);
			preparedStatement.setDouble(7, donHangTu);
			preparedStatement.setInt(8, soLuongKhuyenMai);
			preparedStatement.setInt(9, soLuotDaApDung);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) {
		String update = "UPDATE KhuyenMai SET TenKhuyenMai = ?, LoaiGiamGia = ?, GiaTri = ?, NgayKhuyenMai = ?, NgayHetHanKM = ?, DonHangTu = ? Where CodeKhuyenMai =  ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, khuyenMai.getTenKhuyenMai());
			preparedStatement.setString(2, khuyenMai.getLoaiKhuyenMai());
			preparedStatement.setDouble(3, khuyenMai.getGiaTri());
			preparedStatement.setDate(4, khuyenMai.getNgayKhuyenMai());
			preparedStatement.setDate(5, khuyenMai.getNgayHetHanKM());
			preparedStatement.setDouble(6, khuyenMai.getDonHangTu());
			preparedStatement.setString(7, khuyenMai.getCodeKhuyenMai());
			return (preparedStatement.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteKhuyenMai(String codeKhuyenMai) {
	    String delete = "DELETE FROM KhuyenMai WHERE CodeKhuyenMai = ?";
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(delete);
	        preparedStatement.setString(1, codeKhuyenMai);
	        return (preparedStatement.executeUpdate() > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			String query = "	String query = \"SELECT * FROM KhuyenMai WHERE NgayKhuyenMai BETWEEN '?' AND '?'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setDate(1, startDay);
			preparedStatement.setDate(2, expriedDay);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int layMaNCCCuoiCung() {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM KhuyenMai");
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai) {
		KhuyenMai km = null;
		ArrayList<ChiTietKhuyenMai> listCT = new ArrayList<ChiTietKhuyenMai>();
		try {
			String query = "Select * from KhuyenMai WHERE CodeKhuyenMai = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, maKhuyenMai);
			ResultSet rs = pstm.executeQuery();
			if (!rs.next()) {
				return null;
			}
			km = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"), rs.getString("LoaiGiamGia"),
					rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"), rs.getDate("NgayHetHanKM"),
					rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"), rs.getInt("SoLuotDaApDung"));

			query = "Select * from ChiTietKhuyenMai WHERE CodeKhuyenMai = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, maKhuyenMai);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ChiTietKhuyenMai ctkm = new ChiTietKhuyenMai(new SanPham(rs.getInt("SanPhamID")));
				listCT.add(ctkm);
			}
			km.setChiTietKhuyenMai(listCT);

			return km;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return km;
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByName(String name) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement stm = conn.createStatement();
			String query = "Select * from KhuyenMai WHERE TenKhuyenMai = '" + name + "'";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params) {
		ArrayList<KhuyenMai> list = new ArrayList<>();

		String where = "WHERE ";

		if (params[0] != null) {
			where = where.concat("NgayKhuyenMai >= ?");
		}
		if (params[1] != null) {
		    if (!where.equals("WHERE ")) {
		        where = where.concat(" AND ");
		    }
		    where = where.concat("NgayKhuyenMai <= ?");
		}
		if (params[2] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("GiaTri >= ?");
		}
		if (params[3] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("GiaTri <= ?");
		}
		if (params[4] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("CodeKhuyenMai LIKE ?");
		}
		if (params[5] != null) {
			if (!where.equals("WHERE ")) {
				where = where.concat(" AND ");
			}
			where = where.concat("TenKhuyenMai LIKE ?");
		}

		try {
			String query = null;
			if (!where.equals("WHERE "))
				query = "SELECT * FROM KhuyenMai " + where;
			else
				query = "SELECT * FROM KhuyenMai";
			PreparedStatement stm = conn.prepareStatement(query);

			int paramIndex = 1;

			if (params[0] != null) {
				stm.setDate(paramIndex++, (java.sql.Date) params[0]);
			}
			if (params[1] != null) {
				stm.setDate(paramIndex++, (java.sql.Date) params[1]);
			}
			if (params[2] != null) {
				stm.setDouble(paramIndex++, (Double) params[2]);
			}
			if (params[3] != null) {
				stm.setDouble(paramIndex++, (Double) params[3]);
			}
			if (params[4] != null) {
				stm.setString(paramIndex++, "%" + params[4] + "%");
			}
			if (params[5] != null) {
				stm.setString(paramIndex, "%" + params[5] + "%");
			}

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				try {
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("CodeKhuyenMai"), rs.getString("TenKhuyenMai"),
							rs.getString("LoaiGiamGia"), rs.getDouble("GiaTri"), rs.getDate("NgayKhuyenMai"),
							rs.getDate("NgayHetHanKM"), rs.getDouble("DonHangTu"), rs.getInt("SoLuongKhuyenMai"),
							rs.getInt("SoLuotDaApDung"));
					list.add(khuyenMai);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getSoLuongChuaSD(Object[] params) {
	    String addWhere = "";

	    if (params[0] != null) {
	        addWhere = addWhere.concat(" and TenKhuyenMai = ?");
	    }
	    if (params[1] != null) {
	        addWhere = addWhere.concat(" and CodeKhuyenMai = ?");
	    }

	    String query = "SELECT COUNT(*) FROM KhuyenMai WHERE SoLuotDaApDung = 0 " + addWhere;

	    try {
	        PreparedStatement ps = conn.prepareStatement(query);

	        if (params[0] != null) {
	            ps.setString(1, params[0].toString());
	        }

	        if (params[1] != null) {
	            ps.setString(2, params[1].toString());
	        }

	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        return rs.getInt(1);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

	public KhuyenMai_DAO() {
		this.conn = ConnectDB.getConnection();
	}

}
