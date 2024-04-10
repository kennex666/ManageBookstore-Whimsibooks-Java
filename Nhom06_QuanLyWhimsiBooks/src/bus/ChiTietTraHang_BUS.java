package bus;

import java.util.List;

import dao.ChiTietHoaDon_DAO;
import dao.ChiTietTraHang_DAO;
import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;

public class ChiTietTraHang_BUS implements IChiTietTraHang {
	private ChiTietTraHang_DAO chiTietTraHang_DAO;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietTraHang x) {
		// TODO Auto-generated method stub
		return chiTietTraHang_DAO.addMotChiTietCuaHoaDon(x);
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietTraHang> x) {
		// TODO Auto-generated method stub
		return chiTietTraHang_DAO.addNhieuChiTietCuaMotHoaDon(x);
	}
	@Override
	public List<ChiTietTraHang> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		return chiTietTraHang_DAO.getAllChiTietCuaMotHoaDon(maHoaDon);
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietTraHang x) {
		// TODO Auto-generated method stub
		return chiTietTraHang_DAO.removeMotChiTietCuaHoaDon(x);
	}
	public ChiTietTraHang_BUS() {
		// TODO Auto-generated constructor stub
		chiTietTraHang_DAO = new ChiTietTraHang_DAO();
	}
}
