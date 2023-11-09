package bus;

import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.SanPham;
import interfaces.ISanPham;

public class SanPham_BUS implements ISanPham{

	private SanPham_DAO sanPham_DAO;
	
	public SanPham_BUS() {
		// TODO Auto-generated constructor stub
		sanPham_DAO = new SanPham_DAO();
	}
	@Override
	public ArrayList<SanPham> getDanhSachSanPham(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchSanPham(String s, ArrayList<SanPham> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addSanPham(SanPham sp) {
		// TODO Auto-generated method stub
		return sanPham_DAO.addSanPham(sp);
	}

	@Override
	public boolean editSanPham(SanPham sp) {
		// TODO Auto-generated method stub
		return sanPham_DAO.editSanPham(sp);
	}

	@Override
	public ArrayList<SanPham> getDanhSachSanPhamSapHet() {
		// TODO Auto-generated method stub
		return sanPham_DAO.getDanhSachSanPhamSapHet();
	}
	
	@Override
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) {
		// TODO Auto-generated method stub
		return sanPham_DAO.getChiMotSanPhamTheoMaHoacBarcode(x);
	}

}
