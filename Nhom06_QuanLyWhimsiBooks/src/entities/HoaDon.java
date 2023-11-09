package entities;

import java.util.ArrayList;
import java.util.Date;

public class HoaDon {
	private String hoaDonID;
	private Date ngayLapHoaDon;
	private String trangThai;
	private ArrayList<ChiTietHoaDon> listChiTietHoaDon;
	
	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, ArrayList<ChiTietHoaDon> list) {
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
		this.listChiTietHoaDon = list;
	}
	
	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai) {
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
	}

	public HoaDon() {
		super();
	}
	
	public void addChiTietHoaDon(ChiTietHoaDon x) {
		listChiTietHoaDon.add(x);
	}
        
    public void editSoLuong(ChiTietHoaDon x){
    	if (listChiTietHoaDon.contains(x)){
        	 listChiTietHoaDon.get(listChiTietHoaDon.indexOf(x)).setSoLuong(x.getSoLuong());;
    	}else {
    		addChiTietHoaDon(x);
    	}
    }
	
	public void removeChiTietHoaDon(ChiTietHoaDon x) {
		listChiTietHoaDon.remove(x);
	}

	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public ArrayList<Object> tableChiTietHoaDon() {
		ArrayList<Object> lines = new ArrayList<Object>();
		
		for (int i = 0 ; i < listChiTietHoaDon.size(); i++) {
			Object[] tempObj = new Object[10];
			ChiTietHoaDon tempCTHD = listChiTietHoaDon.get(i);
			tempObj[0] = i+1;
			tempObj[1] = tempCTHD.getSanPham().getSanPhamID();
			tempObj[2] = tempCTHD.getSanPham().getTenSanPham();
			tempObj[3] = tempCTHD.getSanPham().getGiaBan();
			tempObj[4] = "-";
			tempObj[5] = tempCTHD.getSoLuong();
			tempObj[6] = "+";
			tempObj[7] = tempCTHD.getSanPham().getThue();
			tempObj[8] = tempCTHD.tinhTongTien();
			tempObj[9] = "Delete";
			lines.add(tempCTHD);
			
		}
		return lines;
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
