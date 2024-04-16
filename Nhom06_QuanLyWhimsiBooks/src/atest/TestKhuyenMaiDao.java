package atest;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;

import connectDB.ConnectDB;
import dao.KhuyenMai_DAO;

public class TestKhuyenMaiDao {
	public static void main(String[] args) throws ParseException {
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
//		System.out.println(khuyenMai_DAO.SapXepKhuyenMaiTheoGiaTri("A"));
//		System.out.println(khuyenMai_DAO.getKhuyenMaiFollowDay(Date.valueOf(LocalDate.of(2021, 5, 1)), Date.valueOf(LocalDate.of(2025, 5, 3))));
//		System.out.println(khuyenMai_DAO.getKhuyenMaiViaSanPhamAutoApply(1));
//		System.out.println(khuyenMai_DAO.getKhuyenMaiByName("Spring Sale"));
//		Object[] params = new Object[] {"2024-03-01", "2025-05-03", null, null, null, null};
//		System.out.println(khuyenMai_DAO.getDanhSachKhuyenMaiNangCao(params));
		Object[] params = new Object[] {null,"ABC123"};
		System.out.println(khuyenMai_DAO.getSoLuongChuaSD(params));
	}
}
