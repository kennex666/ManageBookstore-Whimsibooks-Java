package bus;

import java.util.ArrayList;
import java.util.Date;

import dao.HoaDon_DAO;
import entities.HoaDon;
import interfaces.IHoaDon;

public class HoaDon_BUS implements IHoaDon{
	private HoaDon_DAO hoaDon_DAO;
	
	
	public HoaDon_BUS() {
		super();
		hoaDon_DAO = new HoaDon_DAO();
	}

	@Override
	public boolean createHoaDon(HoaDon x) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.createHoaDon(x);
	}
	
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDon() {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDon();
	}
	
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
		// TODO Auto-generated method stub
		return getDanhSachHoaDonTheoThoiGian(batDau, ketThuc);
	}
	
	
}
