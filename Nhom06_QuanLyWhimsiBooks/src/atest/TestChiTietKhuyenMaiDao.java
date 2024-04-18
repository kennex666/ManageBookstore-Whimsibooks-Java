package atest;

import connectDB.ConnectDB;
import dao.ChiTietKhuyenMai_DAO;

public class TestChiTietKhuyenMaiDao {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		
//		EntityManager em = ConnectDB.getEntityManager();

		ChiTietKhuyenMai_DAO chiTietKhuyenMai_DAO = new ChiTietKhuyenMai_DAO();
		System.out.println(chiTietKhuyenMai_DAO.getAllChiTietKhuyenMai());
//		System.out.println(chiTietKhuyenMai_DAO.getChiTietKhuyenMaiTheoMa("APPLY_PRODUCT_3"));
//		System.out.println(chiTietKhuyenMai_DAO.getNgayTao("a"));
//		System.out.println(chiTietKhuyenMai_DAO.addSanPhamKhuyenMai(new KhuyenMai("a"), new SanPham(2)));
		
		//addSanPhamKhuyenMaiKhiUpdate("a", 2);
//		System.out.println(chiTietKhuyenMai_DAO.addSanPhamKhuyenMaiKhiUpdate("APPLY_PRODUCT_3", 7));
//		System.out.println(chiTietKhuyenMai_DAO.addSanPhamKhuyenMaiKhiUpdate("APPLY_PRODUCT_3", 8));
	}
}
