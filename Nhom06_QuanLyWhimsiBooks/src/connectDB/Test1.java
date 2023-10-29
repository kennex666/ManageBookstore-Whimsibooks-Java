package connectDB;

import java.util.ArrayList;

import bus.NhanVien_BUS;
import entities.NhanVien;

public class Test1 {
    public static void main(String[] args) {
        ConnectDB.connect(); // Kết nối đến cơ sở dữ liệu

        NhanVien_BUS nhanVienBus = new NhanVien_BUS(); // Tạo đối tượng NhanVien_BUS
        ArrayList<NhanVien> list = nhanVienBus.getAllEmployees(); // Lấy danh sách nhân viên

        for (NhanVien employee : list) {
            System.out.print("Mã nhân viên: " + employee.getNhanVienID());
            System.out.print("Họ tên: " + employee.getHoTen());
            System.out.print("Chức vụ: " + employee.getChucVu());
            System.out.print("Chức vụ: " + employee.getSoDienThoai());
            System.out.print("Chức vụ: " + employee.getEmail());
            System.out.println();
        }

        ConnectDB.closeConnection(); // Đóng kết nối đến cơ sở dữ liệu
    }
}
