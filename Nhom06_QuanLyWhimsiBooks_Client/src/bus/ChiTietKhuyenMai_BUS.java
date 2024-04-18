package bus;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietKhuyenMai;
import interfaces.IKhuyenMai;
import interfaces.ISanPham;
import ultilities.EnviromentConfigs;

public class ChiTietKhuyenMai_BUS implements IChiTietKhuyenMai{
	private IChiTietKhuyenMai chiTietKhuyenMai_DAO;
	
	private IKhuyenMai khuyenMai_DAO;
	private ISanPham sanPham_DAO;
	
	public ChiTietKhuyenMai_BUS() {
	
		try {
			Context ctx  = new InitialContext();
			chiTietKhuyenMai_DAO = (IChiTietKhuyenMai) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/chiTietKhuyenMai");
			khuyenMai_DAO = (IKhuyenMai) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/khuyenMai");
			sanPham_DAO = (ISanPham) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/sanPham");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai() {
		// TODO Auto-generated method stub
		try {
			return chiTietKhuyenMai_DAO.getAllChiTietKhuyenMai();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) {
		// TODO Auto-generated method stub
		try {
			return chiTietKhuyenMai_DAO.addSanPhamKhuyenMai(khuyenMai, sanPham);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM) {
		// TODO Auto-generated method stub
		try {
			return chiTietKhuyenMai_DAO.addSDanhSachSPKM(khuyenMai, danhSachSPKM);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
	
	public List<SanPham> laySanPhamKMTheoMa(String txt) {
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			list = sanPham_DAO.getDanhSachSanPham("Select * from ChiTietKhuyenMai cttkm join SanPham sp on sp.SanPhamID = cttkm.SanPhamID where cttkm.CodeKhuyenMai = '"+txt+"'");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
		return list;
	}
	
	public List<KhuyenMai> layKhuyenMaiTheoMa(String txt) {
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			list = khuyenMai_DAO.getKhuyenMaiByID(txt);
			return list;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	
	public List<ChiTietKhuyenMai> layCTTKMTheoMa(String txt) {
		List<ChiTietKhuyenMai> list = new ArrayList<ChiTietKhuyenMai>();
		try {
			list = chiTietKhuyenMai_DAO.getChiTietKhuyenMaiTheoMa(txt);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	@Override
	public Date getNgayTao(String maKM) {
		// TODO Auto-generated method stub
		try {
			return chiTietKhuyenMai_DAO.getNgayTao(maKM);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	@Override
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai, int masanPham) {
		// TODO Auto-generated method stub
		try {
			return chiTietKhuyenMai_DAO.addSanPhamKhuyenMaiKhiUpdate(makhuyenMai, masanPham);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
	@Override
	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String txt) {
		// TODO Auto-generated method stub
		return null;
	}
}
