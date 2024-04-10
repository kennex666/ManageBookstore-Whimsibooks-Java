package bus;

import java.util.List;

import dao.ChiTietHoaDon_DAO;
import entities.ChiTietHoaDon;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;

public class ChiTietHoaDon_BUS implements IChiTietHoaDon {
	private ChiTietHoaDon_DAO chiTietHoaDon_DAO;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.addMotChiTietCuaHoaDon(x);
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietHoaDon> x) {
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.addNhieuChiTietCuaMotHoaDon(x);
	}
	@Override
	public List<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.getAllChiTietCuaMotHoaDon(maHoaDon);
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.removeMotChiTietCuaHoaDon(x);
	}
	public ChiTietHoaDon_BUS() {
		// TODO Auto-generated constructor stub
		chiTietHoaDon_DAO = new ChiTietHoaDon_DAO();
	}
}
