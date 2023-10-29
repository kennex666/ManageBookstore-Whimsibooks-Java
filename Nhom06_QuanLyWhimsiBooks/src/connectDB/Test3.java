package connectDB;

import java.sql.Connection;
import java.util.ArrayList;

import bus.NhanVien_BUS;
import entities.NhanVien;

public class Test3 {
	public static void main(String[] args) {
		ConnectDB.connect();
		NhanVien_BUS nhanVienBus = new NhanVien_BUS();
		int total = nhanVienBus.totalNhanVien();
		System.out.println("Số lượng nhân viên: "+total);
	}
}
