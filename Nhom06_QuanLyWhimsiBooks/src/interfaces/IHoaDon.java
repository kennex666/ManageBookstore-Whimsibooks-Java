package interfaces;

import java.util.List;
import java.util.Date;

import entities.HoaDon;

public interface IHoaDon {
	public List<HoaDon> getDanhSachHoaDon();
	public boolean createHoaDon(HoaDon x);
	public List<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc);
	public List<HoaDon> getDanhSachHoaDonNangCao(Object[] params);	
	public HoaDon getHoaDonByID(HoaDon x);
	public int getSoHoaDonTrongNgay();
        public boolean updateHoaDon(HoaDon x);
        public boolean cancelHoaDon(HoaDon x);
}
