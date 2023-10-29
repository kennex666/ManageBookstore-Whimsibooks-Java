package gui;

import connectDB.ConnectDB;
import dao.DanhMuc_DAO;
import entities.DanhMuc;

public class MainTest {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		
		DanhMuc_DAO danhMuc_DAO = new DanhMuc_DAO();
		
		DanhMuc danhMuc = new DanhMuc();
		try {
			danhMuc.setTenDanhMuc("test");
			System.out.println(danhMuc_DAO.addDanhMuc(danhMuc));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
