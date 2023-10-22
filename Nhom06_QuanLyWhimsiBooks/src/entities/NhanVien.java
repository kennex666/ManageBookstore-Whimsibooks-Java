package entities;

import java.time.LocalDate;
import java.util.Date;

public class NhanVien {
	private String nhanVienID;
	private String userName;
	private String password;
	private LocalDate ngayTaoTK;
	private String hoTen;
	private String gioiTinh;
	private String soDienThoai;
	private String chucVu;
	private String email;
	private LocalDate ngaySinh;
	private String diaChi;
	private String quyenTruyCap;
	
	public NhanVien(String nhanVienID, String userName, String password, LocalDate ngayTaoTK, String hoTen, String gioiTinh,
			String soDienThoai, String chucVu, String email, LocalDate ngaySinh, String diaChi, String quyenTruyCap) {
		this.nhanVienID = nhanVienID;
		this.userName = userName;
		this.password = password;
		this.ngayTaoTK = ngayTaoTK;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.chucVu = chucVu;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.quyenTruyCap = quyenTruyCap;
	}

	public NhanVien() {
		
	}

	public String getNhanVienID() {
		return nhanVienID;
	}

	public void setNhanVienID(String nhanVienID) {
		this.nhanVienID = nhanVienID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getNgayTaoTK() {
		return ngayTaoTK;
	}

	public void setNgayTaoTK(LocalDate ngayTaoTK) {
		this.ngayTaoTK = ngayTaoTK;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getQuyenTruyCap() {
		return quyenTruyCap;
	}

	public void setQuyenTruyCap(String quyenTruyCap) {
		this.quyenTruyCap = quyenTruyCap;
	}
	
	
	
	
}

