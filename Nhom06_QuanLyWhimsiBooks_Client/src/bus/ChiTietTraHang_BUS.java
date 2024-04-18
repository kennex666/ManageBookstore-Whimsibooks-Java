package bus;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;
import ultilities.EnviromentConfigs;

public class ChiTietTraHang_BUS implements IChiTietTraHang {
	private IChiTietTraHang chiTietTraHang_DAO;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietTraHang x) {
		// TODO Auto-generated method stub
		try {
			return chiTietTraHang_DAO.addMotChiTietCuaHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietTraHang> x) {
		// TODO Auto-generated method stub
		try {
			return chiTietTraHang_DAO.addNhieuChiTietCuaMotHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
	@Override
	public List<ChiTietTraHang> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		try {
			return chiTietTraHang_DAO.getAllChiTietCuaMotHoaDon(maHoaDon);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietTraHang x) {
		// TODO Auto-generated method stub
		try {
			return chiTietTraHang_DAO.removeMotChiTietCuaHoaDon(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
	public ChiTietTraHang_BUS() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx  = new InitialContext();
			chiTietTraHang_DAO = (IChiTietTraHang) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/chiTietTraHang");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
