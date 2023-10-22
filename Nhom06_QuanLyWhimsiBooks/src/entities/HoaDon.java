package entities;

import java.util.Date;

public class HoaDon {
	private String hoaDonID;
	private Date ngayLapHoaDon;
	private String trangThai;
	
	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai) {
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
	}

	public HoaDon() {
	
	}

	public String getHoaDonID() {
		return hoaDonID;
	}

	public void setHoaDonID(String hoaDonID) {
		this.hoaDonID = hoaDonID;
	}

	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
}
