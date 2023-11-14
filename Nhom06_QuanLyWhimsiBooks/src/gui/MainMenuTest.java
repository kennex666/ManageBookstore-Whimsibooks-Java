package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.DanhMuc_BUS;
import bus.SanPham_BUS;
import connectDB.ConnectDB;
import dao.SanPham_DAO;
import entities.DanhMuc;
import entities.SanPham;

public class MainMenuTest {
	public static void main(String[] args) throws Exception {
		ConnectDB.getInstance().connect();
		
		SanPham_BUS sp_bus = new SanPham_BUS();
//		SanPham sanPham = new SanPham();
//		sanPham.setTenSanPham("abc");
		System.out.println(sp_bus.getDanhSachSanPham());
		
		
	}
}