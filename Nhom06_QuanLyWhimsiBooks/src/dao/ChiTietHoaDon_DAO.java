package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import interfaces.IChiTietHoaDon;

public class ChiTietHoaDon_DAO implements IChiTietHoaDon {
	private Connection conn;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO ChiTietHoaDon(hoaDonID,sanPhamID,soLuong,donGia)VALUES(?,?,?,?)"
			);

			pstm.setString(1, x.getHoaDon().getHoaDonID());
			pstm.setInt(2, x.getSanPham().getSanPhamID());
			pstm.setInt(3, x.getSoLuong());
			pstm.setDouble(4, x.getSanPham().getGiaBan());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(ArrayList<ChiTietHoaDon> x) {
		// TODO Auto-generated method stub
		for (ChiTietHoaDon y : x) {
			if (!addMotChiTietCuaHoaDon(y))
				return false;
		}
		return true;
	}
	@Override
	public ArrayList<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ChiTietHoaDon_DAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}

}
