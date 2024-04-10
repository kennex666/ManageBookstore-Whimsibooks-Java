package interfaces;

import java.util.List;
import java.util.Date;

import entities.HoaDon;
import entities.HoaDonTra;

public interface IHoaDonTra {
	public List<HoaDonTra> getDanhSachHoaDon();
	public boolean createHoaDon(HoaDonTra x);
	public List<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc);
	public List<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params);	
	public HoaDonTra getHoaDonByID(HoaDonTra x);
	public int getSoHoaDonTrongNgay();
        public boolean updateHoaDon(HoaDonTra x);
        public boolean cancelHoaDon(HoaDonTra x);
}
