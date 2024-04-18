package atest;

import bus.NhaCungCap_BUS;
import connectDB.ConnectDB;
import entities.NhaCungCap;

public class TestNhaCungCapDAO {
	public static void main(String[] args) {
		try {
			ConnectDB.connect();
			NhaCungCap_BUS ncc_BUS = new NhaCungCap_BUS();
//			ncc_BUS.getNCCByID("NCC00001").forEach(System.out::println);
			
//			ncc_BUS.getNCCByPhone("0246").forEach(System.out::println);
		
//			ncc_BUS.getNCCByEmail("gmail").forEach(System.out::println);
	
//			ncc_BUS.getNCCByName("Nhà sách Bích Quân").forEach(System.out::println);

			NhaCungCap ncc = new NhaCungCap("NCC10000", "1", "1", "1", "1");
			System.out.println(ncc_BUS.addNhaCungCap(ncc));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
