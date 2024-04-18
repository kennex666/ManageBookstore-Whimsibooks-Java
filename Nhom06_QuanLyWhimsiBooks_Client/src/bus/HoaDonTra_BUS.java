package bus;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;

import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.SanPham;
import interfaces.IChiTietHoaDon;
import interfaces.IHoaDon;
import interfaces.IHoaDonTra;
import ultilities.EnviromentConfigs;

public class HoaDonTra_BUS implements IHoaDonTra {
	private IHoaDonTra hoaDon_DAO;

	public HoaDonTra_BUS() {
		super();
		try {
			Context ctx  = new InitialContext();
			hoaDon_DAO = (IHoaDonTra) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/hoaDonTra");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean createHoaDon(HoaDonTra x) {
		// TODO Auto-generated method stub
		if (x.getHoaDonID() == null || x.getHoaDonID().isBlank()) {
			return false;
		}
		for (ChiTietTraHang y : x.getListChiTietHoaDon())
			y.setHoaDon(x);
		try {
			return hoaDon_DAO.createHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false; 
		}
	}

	@Override
	public boolean updateHoaDon(HoaDonTra x) {
		try {
			return hoaDon_DAO.updateHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public boolean cancelHoaDon(HoaDonTra x) {
		try {
			return hoaDon_DAO.cancelHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public List<HoaDonTra> getDanhSachHoaDon() {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getDanhSachHoaDon();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public List<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getDanhSachHoaDonTheoThoiGian(batDau, ketThuc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public List<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params) {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getDanhSachHoaDonNangCao(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public int getSoHoaDonTrongNgay() {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getSoHoaDonTrongNgay();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0; 
		}
	}

	@Override
	public HoaDonTra getHoaDonByID(HoaDonTra x) {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getHoaDonByID(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	public String generateHoaDonID() {
		Date now = new Date();
		return String.format("HD%02d%02d%02d%03d", now.getDate(), now.getMonth() + 1,
				((now.getYear() / 10) % 10) * 10 + now.getYear() % 10, getSoHoaDonTrongNgay() + 1);
	}

	@Override
	public HashMap<String, Object[]> getObjectThongKeXuHuong(Date start, Date end) {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getObjectThongKeXuHuong(start, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

}
