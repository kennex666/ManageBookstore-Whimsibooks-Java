package bus;

import java.util.ArrayList;

import javax.swing.JTable;

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
	public ArrayList<NhaCungCap> getNCCByID(String maNCC) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNCCByID(maNCC);
	}

	@Override
	public ArrayList<NhaCungCap> getNCCByPhone(String sdt) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNCCByPhone(sdt);
	}
	
	@Override
	public ArrayList<NhaCungCap> getNCCByName(String name) {
		// TODO Auto-generated method stub
		return null;
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

	public int layMaNCCCuoiCung() {
		return	ncc_DAO.layMaNCCCuoiCung();
	}

	public NhaCungCap_BUS() {
		this.ncc_DAO = new NhaCungCap_DAO();
	}
	
	// kiểm tra tên viết hoa viêt thường
	public boolean containsIgnoreCase(String str, String subStr) {
	    return str.toLowerCase().contains(subStr.toLowerCase());
	}

	public ArrayList<NhaCungCap> getNhaCungCapTheoDieuKien(String ma, String sdt, String ten) {
		ArrayList<NhaCungCap> danhSachTimKiem = new ArrayList<NhaCungCap>();
		if(!ma.isEmpty()) {
			for(NhaCungCap ncc : getAllNhaCungCap()) {
				if(containsIgnoreCase(ncc.getNhaCungCapID(), ma))
					danhSachTimKiem.add(ncc);
			}
		}
		if(!sdt.isEmpty()) {
			for(NhaCungCap ncc : getAllNhaCungCap()) {
				if(containsIgnoreCase(ncc.getSoDienThoai(), sdt))
					danhSachTimKiem.add(ncc);
			}
			if(!ma.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getSoDienThoai(), sdt) && containsIgnoreCase(ncc.getNhaCungCapID(), ma) )
        				danhSachTimKiem.add(ncc);
        		}
			}
		}
		if(!ten.isEmpty()) {
			for(NhaCungCap ncc : getAllNhaCungCap()) {
				if(containsIgnoreCase(ncc.getTenNhaCungCap(), ten) )
					danhSachTimKiem.add(ncc);
			}
			if(!ma.isEmpty() && !sdt.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getSoDienThoai(), sdt) && containsIgnoreCase(ncc.getNhaCungCapID(), ma) && containsIgnoreCase(ncc.getTenNhaCungCap(), ten))
        				danhSachTimKiem.add(ncc);
        		}
			}
			else if(!ma.isEmpty() && sdt.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getNhaCungCapID(), ma) && containsIgnoreCase(ncc.getTenNhaCungCap(), ten))
        				danhSachTimKiem.add(ncc);
        		}
			}
			else if(ma.isEmpty() && !sdt.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getSoDienThoai(), sdt) && containsIgnoreCase(ncc.getTenNhaCungCap(), ten))
        				danhSachTimKiem.add(ncc);
        		}
			}
		}
		return danhSachTimKiem;
	}

}
