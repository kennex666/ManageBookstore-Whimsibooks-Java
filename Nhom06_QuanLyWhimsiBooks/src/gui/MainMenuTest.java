package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.ChiTietKhuyenMai_BUS;
import bus.DanhMuc_BUS;
import bus.KhuyenMai_BUS;
import bus.SanPham_BUS;
import connectDB.ConnectDB;
import dao.KhuyenMai_DAO;
import dao.SanPham_DAO;
import entities.DanhMuc;
import entities.SanPham;

public class MainMenuTest {
	public static void main(String[] args) throws Exception {
		ConnectDB.getInstance().connect();
		
//		SanPham_BUS sp_bus = new SanPham_BUS();
//		SanPham sanPham = new SanPham();
//		sanPham.setTenSanPham("abc");
//		System.out.println(sp_bus.getDanhSachSanPham());
//		KhuyenMai_DAO a = new KhuyenMai_DAO();
//		System.out.println(a.TimKiemKhuyenMaiTheoDieuKien("Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+0+"%' and LoaiGiamGia = 'Percentage'"));
		
//		KhuyenMai_BUS bus = new KhuyenMai_BUS();
//		System.out.println(bus.TimKiemTheoDieuKien("", "Giá trị"));
		ChiTietKhuyenMai_BUS bus = new ChiTietKhuyenMai_BUS();
		System.out.println(bus.laySanPhamKMTheoMa("AAA"));
	}
}