package bus;

import java.util.ArrayList;

import dao.ChiTietKhuyenMai_DAO;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;
import interfaces.IChiTietKhuyenMai;

public class ChiTietKhuyenMai_BUS implements IChiTietKhuyenMai{
	private ChiTietKhuyenMai_DAO chiTietKhuyenMai_DAO;
	
	public ChiTietKhuyenMai_BUS() {
		this.chiTietKhuyenMai_DAO = new ChiTietKhuyenMai_DAO();
	}
	@Override
	public ArrayList<ChiTietKhuyenMai> getAllChiTietKhuyenMai() {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.getAllChiTietKhuyenMai();
	}
	@Override
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.addSanPhamKhuyenMai(khuyenMai, sanPham);
	}
	@Override
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, ArrayList<SanPham> danhSachSPKM) {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.addSDanhSachSPKM(khuyenMai, danhSachSPKM);
	}

}
