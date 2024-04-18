package bus;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.KhachHang;
import entities.NhanVien;
import interfaces.IChiTietHoaDon;
import interfaces.IKhachHang;
import ultilities.EnviromentConfigs;

public class KhachHang_BUS implements IKhachHang {
	private IKhachHang kh_dao;
	@Override
	public List<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) {
		// TODO Auto-generated method stub
		try {
			return  kh_dao.findKhachHangAdvanced(maKhachHang, tenKhachHang, soDienThoai, gioiTinh, loaiKhachHang);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	
	
	public KhachHang_BUS() {
		super();
		try {
			Context ctx  = new InitialContext();
			kh_dao = (IKhachHang) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/khachHang");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public List<KhachHang> getAllKhachHang() {
		
		try {
			return kh_dao.getAllKhachHang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public long totalKhachHang() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		try {
			return kh_dao.addKhachHang(kh);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
@Override
	public KhachHang getKhachHangByKhachHangID(String ma) {
		// TODO Auto-generated method stub
		try {
			return kh_dao.getKhachHangByKhachHangID(ma);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	@Override
	public boolean editKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		try {
			return kh_dao.editKhachHang(kh);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public boolean deleteKhachHang(KhachHang kh) {
		try {
			return kh_dao.deleteKhachHang(kh);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		
	}

	@Override
	public String getLayTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public KhachHang getKhachHangTuMaVaSDT(String x) {
		try {
			return kh_dao.getKhachHangTuMaVaSDT(x);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	@Override
	public List<NhanVien> findKhachHang(String x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long phatSinhMaKhachHang() {
		// TODO Auto-generated method stub
		try {
			return kh_dao.phatSinhMaKhachHang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public String phatSinhMaSoThue(String loaiKhachHang) {
		// TODO Auto-generated method stub
		try {
			return kh_dao.phatSinhMaSoThue(loaiKhachHang);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	public boolean checkIfKhachHangExists(String maKH) {
		try {
			return kh_dao.checkIfKhachHangExists(maKH);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean chuyenLoaiKhachHang(String maKhachHang, String loaiKhachHangMoi) {
		// TODO Auto-generated method stub
		try {
			return kh_dao.chuyenLoaiKhachHang(maKhachHang, loaiKhachHangMoi);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
