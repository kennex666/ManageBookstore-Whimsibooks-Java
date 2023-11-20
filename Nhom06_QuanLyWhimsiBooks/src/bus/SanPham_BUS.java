package bus;

import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.SanPham;
import entities.ThuongHieu;
import interfaces.ISanPham;

public class SanPham_BUS implements ISanPham{

	private SanPham_DAO sanPham_DAO;
	
	@Override
	public ArrayList<SanPham> laySanPhamChoKM() {
		// TODO Auto-generated method stub
		return sanPham_DAO.laySanPhamChoKM();
	}
	public SanPham_BUS() {
		// TODO Auto-generated constructor stub
		sanPham_DAO = new SanPham_DAO();
	}
	@Override
	public ArrayList<SanPham> getDanhSachSanPham(String query) {
		// TODO Auto-generated method stub
		return sanPham_DAO.getDanhSachSanPham(query);
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
	
	@Override
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) {
		// TODO Auto-generated method stub
		return sanPham_DAO.getChiMotSanPhamTheoMaHoacBarcode(x);
	}

	@Override
	public ArrayList<SanPham> getDanhSachSanPham() {
		// TODO Auto-generated method stub
		return sanPham_DAO.getDanhSachSanPham();
	}
	@Override
	public ArrayList<SanPham> getSPTheoThuongHieu(String maThuongHieu) {
		// TODO Auto-generated method stub
		return sanPham_DAO.getSPTheoThuongHieu(maThuongHieu);
	}
	@Override
	public ArrayList<ThuongHieu> getThuongHieu() {
		// TODO Auto-generated method stub
		return sanPham_DAO.getThuongHieu();
	}

    @Override
    public int getIdTacGiaByName(String name) {
        return sanPham_DAO.getIdTacGiaByName(name);
    }

    @Override
    public int getIdTheloaiByName(String name) {
        return sanPham_DAO.getIdTheloaiByName(name);
    }

    @Override
    public int getIdNhaXuatBanByName(String name) {
        return sanPham_DAO.getIdNhaXuatBanByName(name);
    }

    @Override
    public String getIdNhaCungCapByName(String name) {
        return sanPham_DAO.getIdNhaCungCapByName(name);
    }

    @Override
    public int getIdThuongHieuByName(String name) {
        return sanPham_DAO.getIdThuongHieuByName(name);
    }

    @Override
    public int getIdDanhMucByName(String name) {
        return sanPham_DAO.getIdDanhMucByName(name);
    }

    @Override
    public String getNameTacGiaByID(int ID) {
        return sanPham_DAO.getNameTacGiaByID(ID);
    }

    @Override
    public String getNameNhaXuatBanByID(int ID) {
        return sanPham_DAO.getNameNhaXuatBanByID(ID);
    }

    @Override
    public String getNameDanhMucByID(int ID) {
        return sanPham_DAO.getNameDanhMucByID(ID);
    }

    @Override
    public String getNameTheLoaiByID(int ID) {
        return sanPham_DAO.getNameTheLoaiByID(ID);
    }

    @Override
    public String getNameThuongHieuByID(int ID) {
        return sanPham_DAO.getNameThuongHieuByID(ID);
    }

    @Override
    public String getNameNhaCungCapByID(String ID) {
        return sanPham_DAO.getNameNhaCungCapByID(ID);
    }

}
