package interfaces;

import java.util.ArrayList;
import java.util.Date;

import entities.HoaDon;
import entities.HoaDonTra;

public interface IHoaDonTra {
	public ArrayList<HoaDonTra> getDanhSachHoaDon();
	public boolean createHoaDon(HoaDonTra x);
	public ArrayList<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc);
	public ArrayList<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params);	
	public HoaDonTra getHoaDonByID(HoaDonTra x);
	public int getSoHoaDonTrongNgay();
        public boolean updateHoaDon(HoaDonTra x);
        public boolean cancelHoaDon(HoaDonTra x);
}
