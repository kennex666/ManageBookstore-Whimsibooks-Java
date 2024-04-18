package bus;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.ChiTietHoaDon;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;
import ultilities.EnviromentConfigs;

public class ChiTietHoaDon_BUS implements IChiTietHoaDon {
	private IChiTietHoaDon chiTietHoaDon_DAO;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		try {
			return chiTietHoaDon_DAO.addMotChiTietCuaHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietHoaDon> x) {
		// TODO Auto-generated method stub
		try {
			return chiTietHoaDon_DAO.addNhieuChiTietCuaMotHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		try {
			return chiTietHoaDon_DAO.getAllChiTietCuaMotHoaDon(maHoaDon);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		try {
			return chiTietHoaDon_DAO.removeMotChiTietCuaHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public ChiTietHoaDon_BUS() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx  = new InitialContext();
			chiTietHoaDon_DAO = (IChiTietHoaDon) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/chiTietHoaDon");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
