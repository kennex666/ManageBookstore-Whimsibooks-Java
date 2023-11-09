package gui;

import bus.NhaCungCap_BUS;
import connectDB.ConnectDB;
import dao.DanhMuc_DAO;
import entities.DanhMuc;

public class MainTest {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		
		NhaCungCap_BUS nhaCungCap_BUS = new NhaCungCap_BUS();
		try {
			String maNhaCungCap = "NCC" + String.format("%05d", nhaCungCap_BUS.layMaNCCCuoiCung() + 1);
			System.out.println(maNhaCungCap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
