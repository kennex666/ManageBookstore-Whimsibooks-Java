package bus;

import java.util.ArrayList;
import java.util.Date;

import dao.HoaDonTra_DAO;
import dao.HoaDon_DAO;
import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.SanPham;
import interfaces.IHoaDon;
import interfaces.IHoaDonTra;

public class HoaDonTra_BUS implements IHoaDonTra {
	private HoaDonTra_DAO hoaDon_DAO;

	public HoaDonTra_BUS() {
		super();
		hoaDon_DAO = new HoaDonTra_DAO();
	}

	@Override
	public boolean createHoaDon(HoaDonTra x) {
		// TODO Auto-generated method stub
		if (x.getHoaDonID() == null || x.getHoaDonID().isBlank()) {
			return false;
		}
		for (ChiTietTraHang y : x.getListChiTietHoaDon())
			y.setHoaDon(x);
		return hoaDon_DAO.createHoaDon(x);
	}

	@Override
	public boolean updateHoaDon(HoaDonTra x) {
		return hoaDon_DAO.updateHoaDon(x);
	}

	@Override
	public boolean cancelHoaDon(HoaDonTra x) {
		return hoaDon_DAO.cancelHoaDon(x);
	}

	@Override
	public ArrayList<HoaDonTra> getDanhSachHoaDon() {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDon();
	}

	@Override
	public ArrayList<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDonTheoThoiGian(batDau, ketThuc);
	}

	@Override
	public ArrayList<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDonNangCao(params);
	}

	@Override
	public int getSoHoaDonTrongNgay() {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getSoHoaDonTrongNgay();
	}

	@Override
	public HoaDonTra getHoaDonByID(HoaDonTra x) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getHoaDonByID(x);
	}

	public String generateHoaDonID() {
		Date now = new Date();
		return String.format("HD%02d%02d%02d%03d", now.getDate(), now.getMonth() + 1,
				((now.getYear() / 10) % 10) * 10 + now.getYear() % 10, getSoHoaDonTrongNgay() + 1);
	}

}
