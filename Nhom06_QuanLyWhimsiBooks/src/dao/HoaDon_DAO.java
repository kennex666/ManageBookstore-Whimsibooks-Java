package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entities.HoaDon;
import interfaces.IHoaDon;

public class HoaDon_DAO implements IHoaDon{
	private Connection conn;
	
	public HoaDon_DAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}
	
	@Override
	public boolean createHoaDon(HoaDon x) {
		// TODO Auto-generated method stub
		
		return false;
	}
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDon() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
