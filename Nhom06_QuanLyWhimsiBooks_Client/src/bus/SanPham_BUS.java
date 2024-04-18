package bus;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.SanPham;
import entities.ThuongHieu;
import interfaces.IChiTietHoaDon;
import interfaces.ISanPham;
import ultilities.EnviromentConfigs;

public class SanPham_BUS implements ISanPham {

	private ISanPham sanPham_DAO;

	@Override
	public List<SanPham> laySanPhamChoKM() {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.laySanPhamChoKM();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public SanPham_BUS() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx  = new InitialContext();
			sanPham_DAO = (ISanPham) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/sanPham");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SanPham> getDanhSachSanPham(String query) {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.getDanhSachSanPham(query);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SanPham> searchSanPham(String s) {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.searchSanPham(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addSanPham(SanPham sp) {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.addSanPham(sp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editSanPham(SanPham sp) {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.editSanPham(sp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<SanPham> getDanhSachSanPhamSapHet() {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.getDanhSachSanPhamSapHet();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.getChiMotSanPhamTheoMaHoacBarcode(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SanPham> getDanhSachSanPham() {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.getDanhSachSanPham();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SanPham> getSPTheoThuongHieu(String maThuongHieu) {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.getSPTheoThuongHieu(maThuongHieu);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ThuongHieu> getThuongHieu() {
		// TODO Auto-generated method stub
		try {
			return sanPham_DAO.getThuongHieu();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getIdTacGiaByName(String name) {
		try {
			return sanPham_DAO.getIdTacGiaByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int getIdTheloaiByName(String name) {
		try {
			return sanPham_DAO.getIdTheloaiByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int getIdNhaXuatBanByName(String name) {
		try {
			return sanPham_DAO.getIdNhaXuatBanByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public String getIdNhaCungCapByName(String name) {
		try {
			return sanPham_DAO.getIdNhaCungCapByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public int getIdThuongHieuByName(String name) {
		try {
			return sanPham_DAO.getIdThuongHieuByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int getIdDanhMucByName(String name) {
		try {
			return sanPham_DAO.getIdDanhMucByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public String getNameTacGiaByID(int ID) {
		try {
			return sanPham_DAO.getNameTacGiaByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getNameNhaXuatBanByID(int ID) {
		try {
			return sanPham_DAO.getNameNhaXuatBanByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getNameDanhMucByID(int ID) {
		try {
			return sanPham_DAO.getNameDanhMucByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getNameTheLoaiByID(int ID) {
		try {
			return sanPham_DAO.getNameTheLoaiByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getNameThuongHieuByID(int ID) {
		try {
			return sanPham_DAO.getNameThuongHieuByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getNameNhaCungCapByID(String ID) {
		try {
			return sanPham_DAO.getNameNhaCungCapByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public boolean editTrangThaiSanPham(SanPham sp) {
		try {
			return sanPham_DAO.editTrangThaiSanPham(sp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void SapXepTangTheoGia(List<SanPham> list) {
		try {
			sanPham_DAO.SapXepTangTheoGia(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void SapXepGiamTheoGia(List<SanPham> list) {
		try {
			sanPham_DAO.SapXepGiamTheoGia(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void SapXepTangTheoSoLuong(List<SanPham> list) {
		try {
			sanPham_DAO.SapXepTangTheoSoLuong(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
