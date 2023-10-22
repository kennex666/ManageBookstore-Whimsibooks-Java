package entities;

import java.time.LocalDate;
import java.util.Date;

public class KhachHang {
	private String khachHangID;
	private String hoTen;
	private String soDienThoai;
	private LocalDate ngaySinh;
	private String gioiTinh;
	private String email;
	private String maSoThue;
	private String diaChi;
	private String loaiKhachHang;
	
	public KhachHang(String khachHangID, String hoTen, String soDienThoai, LocalDate ngaySinh, String gioiTinh, String email,
			String maSoThue, String diaChi, String loaiKhachHang) {
		this.khachHangID = khachHangID;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.maSoThue = maSoThue;
		this.diaChi = diaChi;
		this.loaiKhachHang = loaiKhachHang;
	}

	public KhachHang() {

	}

	public String getKhachHangID() {
		return khachHangID;
	}

	public void setKhachHangID(String khachHangID) {
		this.khachHangID = khachHangID;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLoaiKhachHang() {
		return loaiKhachHang;
	}

	public void setLoaiKhachHang(String loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}
	
	
	
	
}
