package bus;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.DanhMuc;
import interfaces.IChiTietHoaDon;
import interfaces.IDanhMuc;
import ultilities.EnviromentConfigs;

public class DanhMuc_BUS implements IDanhMuc{
	private IDanhMuc danhMuc_DAO;
	
	@Override
	public boolean addDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		try {
			return danhMuc_DAO.addDanhMuc(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
	@Override
	public boolean editDanhMuc(DanhMuc x) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		try {
			return danhMuc_DAO.getAllDanhMuc();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	@Override
	public List<DanhMuc> getDanhMucTheoID(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public DanhMuc_BUS() {
		super();
		try {
			Context ctx  = new InitialContext();
			danhMuc_DAO = (IDanhMuc) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/danhMuc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
