package bus;

import java.util.ArrayList;

import dao.DanhMuc_DAO;
import entities.DanhMuc;
import interfaces.IDanhMuc;

public class DanhMuc_BUS implements IDanhMuc{
	private DanhMuc_DAO danhMuc_DAO;
	
	@Override
	public boolean addDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		return danhMuc_DAO.addDanhMuc(x);
	}
	@Override
	public boolean editDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ArrayList<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		return danhMuc_DAO.getAllDanhMuc();
	}
	@Override
	public ArrayList<DanhMuc> getDanhMucTheoID(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public DanhMuc_BUS() {
		super();
		danhMuc_DAO = new DanhMuc_DAO();
	}

	
	
}
