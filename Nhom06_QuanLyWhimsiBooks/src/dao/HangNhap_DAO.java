package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.HangNhap;
import interfaces.IHangNhap;

public class HangNhap_DAO implements IHangNhap{
	private Connection conn;
	
	@Override
	public HangNhap findHangNhap(String hangNhapID) {
		try {
			Statement stm =  conn.createStatement();
			String query = "Select * from HangNhap WHERE HangNhapID = '"+ hangNhapID+"'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					HangNhap hangNhap = new HangNhap(rs.getString("HangNhapID"), rs.getDate("NgayNhap"), rs.getDouble("GiaTriDon"), rs.getString("MaDonDat"), rs.getString("TrangThaiNhap"), rs.getString("TrangThaiThanhToan"));
					System.out.println(hangNhap);
					return hangNhap;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public HangNhap_DAO() {
		this.conn = ConnectDB.getConnection();
	}
	
}
