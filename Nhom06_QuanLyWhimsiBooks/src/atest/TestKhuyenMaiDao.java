package atest;

import connectDB.ConnectDB;
import dao.KhuyenMai_DAO;

public class TestKhuyenMaiDao {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		KhuyenMai_DAO khuyenMai_DAO = new KhuyenMai_DAO();
//		System.out.println(khuyenMai_DAO.getAllKhuyenMai());
//		System.out.println(khuyenMai_DAO.getRecentKhuyenMai(2));
//		khuyenMai_DAO.xoaSanPhamKhuyenMai("KM0001");
//		System.out.println(khuyenMai_DAO.getChiTietKhuyenMaiTheoMa("APPLY_PRODUCT_ONE"));
//		System.out.println(khuyenMai_DAO.getKhuyenMaiByID("Voucher"));
//		System.out.println(khuyenMai_DAO.getKhuyenMaiByIDAndName("A", "S"));
//		System.out.println(khuyenMai_DAO.TimKiemKhuyenMaiTheoDieuKien("SELECT km FROM KhuyenMai km WHERE km.loaiGiamGia = 'Percentage'"));
//		System.out.println(khuyenMai_DAO.TimKiemTheoLoai("Percentage"));
//		System.out.println(khuyenMai_DAO.getKhuyenMaiTheoTen1("Spring Sale"));
		System.out.println(khuyenMai_DAO.SapXepKhuyenMaiTheoGiaTri("A"));
	}
}
