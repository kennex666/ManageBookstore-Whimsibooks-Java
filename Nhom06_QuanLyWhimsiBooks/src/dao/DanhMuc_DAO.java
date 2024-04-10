package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entities.DanhMuc;
import interfaces.IDanhMuc;

public class DanhMuc_DAO implements IDanhMuc{

	private Connection conn;
	
	@Override
	public boolean addDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO DanhMuc(tenDanhMuc) VALUES(?)";
			
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setString(1, x.getTenDanhMuc());
			
			int rs = pstm.executeUpdate();
			return (rs > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean editDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<DanhMuc> getAllDanhMuc() {
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		
		try {
			Statement stm = conn.createStatement();
			
			String query = "SELECT * FROM DanhMuc";
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				try {
					DanhMuc danhMuc = new DanhMuc(rs.getInt("danhmucid"), rs.getString("tendanhmuc"));
					list.add(danhMuc);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return list;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
	}
	@Override
	public List<DanhMuc> getDanhMucTheoID(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	public DanhMuc_DAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}
	
}
