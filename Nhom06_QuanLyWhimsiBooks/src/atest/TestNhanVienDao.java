package atest;

import java.time.LocalDate;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entities.NhanVien;

public class TestNhanVienDao {
	public static void main(String[] args) throws Exception {
		ConnectDB.connect();
		NhanVien_DAO nvDAO = new NhanVien_DAO();
//		System.out.println(nvDAO.getAllEmployees());
//		System.out.println(nvDAO.totalNhanVien());
		//editNhanVien
//		 NhanVien nv = new NhanVien("1", "admin", "password", LocalDate.now(), "John Doe", "Male", "123456789", "Manager", "admin@example.com", LocalDate.of(1990, 1, 1), "123 Street, City");
//		 nvDAO.editNhanVien(nv);
//		System.out.println(nvDAO.getNhanVienByNhanVienID("1"));
//		System.out.println(nvDAO.dangNhapNhanVien("admin", "password"));
//		System.out.println(nvDAO.findEmployeeAdvanced("", "J", "", "", ""));
	}
}
