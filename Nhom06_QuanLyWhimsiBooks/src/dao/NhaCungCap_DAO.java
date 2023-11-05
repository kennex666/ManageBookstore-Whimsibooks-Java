package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.HangNhap;
import entities.KhuyenMai;
import entities.NhaCungCap;
import interfaces.INhaCungCap;

public class NhaCungCap_DAO implements INhaCungCap{
	private Connection conn;
	private HangNhap_DAO hangNhap_DAO;
	
	@Override
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			Statement stm =  conn.createStatement();
			String query = "SELECT * FROM NhaCungCap";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("NhaCungCapID"), hangNhap_DAO.findHangNhap(rs.getString("HangNhapID")) , rs.getString("TenNhaCungCap"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("DiaChi"));
					list.add(nhaCungCap);
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
	public String getNameByID(String maNCC) {
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM NhaCungCap '"+maNCC+"'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				return rs.getString("TenNhaCungCap");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getNameByPhone(String sdt) {
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM NhaCungCap '"+sdt+"'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				return rs.getString("TenNhaCungCap");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNhaCungCap(NhaCungCap ncc) {
		String maNCC = ncc.getTenNhaCungCap();
		HangNhap maHN = ncc.getHangNhap();
		String tenNCC = ncc.getNhaCungCapID();
		String SDT = ncc.getSoDienThoai();
		String email = ncc.getEmail();
		String diaChi = ncc.getDiaChi();
		
		String insert = "INSERT INTO NhaCungCap (maNCC, maHN,tenNCC, SDT, email, diaChi) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, maNCC);
			preparedStatement.setString(2, maHN.getHangNhapID());
			preparedStatement.setString(3, tenNCC);
			preparedStatement.setString(4, SDT);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, diaChi);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap ncc) {
		String maNCC = ncc.getTenNhaCungCap();
		HangNhap maHN = ncc.getHangNhap();
		String tenNCC = ncc.getNhaCungCapID();
		String SDT = ncc.getSoDienThoai();
		String email = ncc.getEmail();
		String diaChi = ncc.getDiaChi();
		
		String update = "UPDATE NhaCungCap SET HangNhapID = ?, TenNhaCungCap = ?, SoDIenThoai = ?, Email = ?, DiaChi = ? Where NhaCungCapID =  ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, maNCC);
			preparedStatement.setString(2, maHN.getHangNhapID());
			preparedStatement.setString(3, tenNCC);
			preparedStatement.setString(4, SDT);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, diaChi);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public NhaCungCap_DAO() {
		this.conn = ConnectDB.getConnection();
		this.hangNhap_DAO = new HangNhap_DAO();
	}
	
	public String layMaNCCCuoiCung() {
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("SELECT TOP 1 MaNCC FROM NhaCungCap ORDER BY MaNCC DESC");
			ResultSet rs = ps.executeQuery();
			String s = null;
			while (rs.next()) {
				s = rs.getString(1);
			}
			return s;
		} catch (Exception e) {
			return null;
		}
	}
	
}
