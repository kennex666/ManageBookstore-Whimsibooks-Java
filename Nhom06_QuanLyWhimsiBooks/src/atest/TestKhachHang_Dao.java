package atest;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;

public class TestKhachHang_Dao {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
		System.out.println(khachHang_DAO.getKhachHangTuMaVaSDT("KH0002"));
	}
}
