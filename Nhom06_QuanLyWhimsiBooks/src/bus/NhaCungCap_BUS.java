package bus;

import java.util.ArrayList;

import dao.NhaCungCap_DAO;
import entities.NhaCungCap;
import interfaces.INhaCungCap;

public class NhaCungCap_BUS implements INhaCungCap{
	private NhaCungCap_DAO ncc_DAO;

	@Override
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		// TODO Auto-generated method stub
		return ncc_DAO.getAllNhaCungCap();
	}

	@Override
	public String getNameByID(String maNCC) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNameByID(maNCC);
	}

	@Override
	public String getNameByPhone(String sdt) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNameByPhone(sdt);
	}

	@Override
	public boolean addNhaCungCap(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return ncc_DAO.addNhaCungCap(ncc);
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return ncc_DAO.editNhaCungCap(ncc);
	}

}
