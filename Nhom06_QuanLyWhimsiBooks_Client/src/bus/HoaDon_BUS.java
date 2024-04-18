package bus;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.rmi.RemoteException;
import java.util.Date;

import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.SanPham;
import interfaces.IChiTietHoaDon;
import interfaces.IHoaDon;
import ultilities.EnviromentConfigs;

public class HoaDon_BUS implements IHoaDon {
	private IHoaDon hoaDon_DAO;

	public HoaDon_BUS() {
		super();
		try {
			Context ctx  = new InitialContext();
			hoaDon_DAO = (IHoaDon) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/hoaDon");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean createHoaDon(HoaDon x) {
		// TODO Auto-generated method stub
		try {
			if (x.getHoaDonID() != null) {
				if (!x.getHoaDonID().isBlank()) {
					for (ChiTietHoaDon y : x.getListChiTietHoaDon())
						y.setHoaDon(x);
					return hoaDon_DAO.updateHoaDon(x);
				}
			}

			String hdID = generateHoaDonID();
			x.setHoaDonID(hdID);
			for (ChiTietHoaDon y : x.getListChiTietHoaDon())
				y.setHoaDon(x);
			return hoaDon_DAO.createHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateHoaDon(HoaDon x) {
		try {
			return hoaDon_DAO.updateHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public boolean cancelHoaDon(HoaDon x) {
		try {
			return hoaDon_DAO.cancelHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public List<HoaDon> getDanhSachHoaDon() {
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
	public List<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
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
	public List<HoaDon> getDanhSachHoaDonNangCao(Object[] params) {
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
	public HoaDon getHoaDonByID(HoaDon x) {
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
	public List<Object[]> getDanhSachHoaDonThongKeXuHuong(Date timeStart, Date timeEnd) {
		// TODO Auto-generated method stub
		try {
			return hoaDon_DAO.getDanhSachHoaDonThongKeXuHuong(timeStart, timeEnd);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

}
