package bus;

import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.SanPham;
import interfaces.ISanPham;

public class SanPham_BUS implements ISanPham{

	SanPham_DAO sanPham_DAO = new SanPham_DAO();
	@Override
	public ArrayList<SanPham> getDanhSachSanPham(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SanPham> searchSanPham(String s) {
		// TODO Auto-generated method stub
		return sanPham_DAO.searchSanPham(s);
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

}
