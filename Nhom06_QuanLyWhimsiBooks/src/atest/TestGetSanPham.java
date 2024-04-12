package atest;

import java.time.LocalDate;
import java.util.Date;

import bus.ChiTietHoaDon_BUS;
import bus.ChiTietTraHang_BUS;
import bus.HoaDonTra_BUS;
import bus.HoaDon_BUS;
import bus.SanPham_BUS;
import connectDB.ConnectDB;
import dao.HoaDon_DAO;
import dao.SanPham_DAO;
import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.NhanVien;
import entities.SanPham;
import jakarta.persistence.EntityManager;

public class TestGetSanPham {
	public static void main(String[] args) {
		try {
			ConnectDB.connect();
//			SanPham_BUS spBUS = new SanPham_BUS();
			HoaDon_BUS hdBUS = new HoaDon_BUS();
//			ChiTietHoaDon_BUS cthdBUS = new ChiTietHoaDon_BUS();
			
//			HoaDon  hd =  hdBUS.getHoaDonByID(new HoaDon("HD110424004"));
//			SanPham sp = spBUS.getChiMotSanPhamTheoMaHoacBarcode("2");
//			SanPham sp2 = spBUS.getChiMotSanPhamTheoMaHoacBarcode("1");
//
//			ChiTietHoaDon cthd1 = new ChiTietHoaDon(sp, 1, hd);
//			ChiTietHoaDon cthd2 = new ChiTietHoaDon(sp2, 2, hd);
//			hd.addChiTietHoaDon(cthd1);
//			hd.addChiTietHoaDon(cthd2);
//			
//			
//			
//			System.out.println(hdBUS.cancelHoaDon(hd));
//			System.out.println(cthdBUS.addNhieuChiTietCuaMotHoaDon(hd.getListChiTietHoaDon()));
			
			// Sử dụng lớp LocalDate để tạo đối tượng Date cho tháng 2 năm 2024
			LocalDate startDate = LocalDate.of(2023, 12, 10);
			// Sử dụng LocalDate.now() để lấy ngày hiện tại
			LocalDate endDate = LocalDate.now();

			// Chuyển đổi LocalDate sang Date
			Date batDau = java.sql.Date.valueOf(startDate);
			Date ketThuc = java.sql.Date.valueOf(endDate);

			HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
//			// Gọi phương thức để lấy danh sách hóa đơn trong khoảng thời gian đã cho
//			hoaDon_DAO.getDanhSachHoaDonThongKeXuHuong(batDau, ketThuc).forEach(hd -> {
//			    // In ra chức vụ của nhân viên trong mỗi hóa đơn
//				// Object[10]
//			    System.out.println(hd[0] + " " + hd[1] + " " + hd[2] + " " + hd[3] + " " + hd[4] + " " + hd[5] + " " + hd[6] + " " + hd[7] + " " + hd[8] + " " + hd[9]);
//			});
			
			
			
		//	System.out.println(hoaDon_DAO.getDanhSachHoaDonNangCao()));

		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
