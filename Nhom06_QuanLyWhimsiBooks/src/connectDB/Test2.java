package connectDB;

import java.util.ArrayList;

import bus.NhanVien_BUS;
import entities.NhanVien;

public class Test2 {
    public static void main(String[] args) {
        ConnectDB.connect(); // Kết nối đến cơ sở dữ liệu
        try {
        	NhanVien_BUS nhanVienBus = new NhanVien_BUS(); // Tạo đối tượng NhanVien_BUS
            ArrayList<NhanVien> list = nhanVienBus.findEmployee("084");

            for (NhanVien employee : list) {
                System.out.println("Mã nhân viên: " + employee.getNhanVienID());
                System.out.println("Họ tên: " + employee.getHoTen());
                System.out.println("Chức vụ: " + employee.getChucVu());
       
                System.out.println();
            }

            ConnectDB.closeConnection(); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
    }
}
