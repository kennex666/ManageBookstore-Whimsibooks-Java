package connectDB;

import java.time.LocalDate;

import bus.NhanVien_BUS;
import entities.NhanVien;

public class test4 {
	public static void main(String[] args) throws Exception {
		ConnectDB.connect();
		NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
//		tạo 1 đối tượng mới
		NhanVien newNhanVien = new NhanVien(
	            "NV126", "user123", "password123", LocalDate.now(), "Nguyen Van A",
	            "Nam", "0123456789", "Nhan vien", "user123@gmail.com", LocalDate.of(1990, 1, 1),"123 Street, City"
	            
	        );
		
		boolean success =nhanVien_BUS.addNhanVien(newNhanVien);
		if(success) {
			System.out.println("Thêm nhân viên thàn công");
		}else {
			System.out.println("Thêm thất bại");
		}
	}
}
