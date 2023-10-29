package connectDB;

import java.time.LocalDate;

import bus.NhanVien_BUS;
import entities.NhanVien;

public class test5 {
	public static void main(String[] args) throws Exception {
		 ConnectDB.connect();
	        NhanVien_BUS nhanVienBus = new NhanVien_BUS();

	        // Lấy một nhân viên từ cơ sở dữ liệu bằng cách sử dụng mã nhân viên (nhanVienID)
	        NhanVien existingNhanVien = nhanVienBus.getNhanVienByNhanVienID("NV123");

	        if (existingNhanVien != null) {
	            // Thay đổi thông tin của nhân viên
	            existingNhanVien.setHoTen("Nguyen ");
	            existingNhanVien.setChucVu("Quan ly");

	            // Thử cập nhật thông tin của nhân viên trong cơ sở dữ liệu
	            boolean success = nhanVienBus.editNhanVien(existingNhanVien);

	            if (success) {
	                System.out.println("Cập nhật thông tin nhân viên thành công");
	            } else {
	                System.out.println("Cập nhật thông tin nhân viên không thành công");
	            }
	        } else {
	            System.out.println("Không tìm thấy nhân viên");
	        }
	}
}
