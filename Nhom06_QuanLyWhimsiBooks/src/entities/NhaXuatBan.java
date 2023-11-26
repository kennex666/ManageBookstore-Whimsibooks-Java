package entities;

import java.util.Date;
import java.util.Objects;

public class NhaXuatBan {
	private int nhaXuatBanID;
	private String tenNhaXuatBan, diaChi, soDienThoai, email, website;
	private int namThanhLap;
	private String linhVucXuatBan;
	private String quocGia;

	public NhaXuatBan(int nhaXuatBanID, String tenNhaXuatBan, String diaChi, String soDienThoai, String email,
			String website, int namThanhLap, String linhVucXuatBan, String quocGia) {
		this.setNhaXuatBanID(nhaXuatBanID);
		this.setTenNhaXuatBan(tenNhaXuatBan);
		this.setDiaChi(diaChi);
		this.setSoDienThoai(soDienThoai);
		this.setEmail(email);
		this.setWebsite(website);
		this.setNamThanhLap(namThanhLap);
		this.setLinhVucXuatBan(linhVucXuatBan);
		this.setQuocGia(quocGia);
	}
	public NhaXuatBan(int nhaXuatBanID) {
		super();
		this.setNhaXuatBanID(nhaXuatBanID);
	}
        public NhaXuatBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNhaXuatBanID() {
		return nhaXuatBanID;
	}
	public void setNhaXuatBanID(int nhaXuatBanID) {
	    // Kiểm tra nhaXuatBan không rỗng
//	    if (nhaXuatBanID.isEmpty()) {
//	        throw new IllegalArgumentException("nhaXuatBan không được rỗng");
//	    }
//
//	    // Kiểm tra định dạng
//	    if (!nhaXuatBanID.matches("^NXB\\d{6}$")) {
//	        throw new IllegalArgumentException("nhaXuatBan không hợp lệ");
//	    }

	    this.nhaXuatBanID = nhaXuatBanID;
	}
	
	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}
	public void setTenNhaXuatBan(String tenNhaXuatBan) {
	    // Kiểm tra tenNhaXuatBan không rỗng
	    if (tenNhaXuatBan.isEmpty()) {
	        throw new IllegalArgumentException("Tên nhà xuất bản không được rỗng");
	    }

	    this.tenNhaXuatBan = tenNhaXuatBan;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
//	    // Kiểm tra soDienThoai không rỗng
//	    if (soDienThoai.isEmpty()) {
//	        throw new IllegalArgumentException("Số điện thoại không được rỗng");
//	    }
//
//	    // Kiểm tra định dạng
//	    if (!soDienThoai.matches("^\\+?\\d{9,10}$") && !soDienThoai.matches("^0\\d{9,10}$")) {
//	        throw new IllegalArgumentException("Số điện thoại không hợp lệ");
//	    }

	    this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	    // Kiểm tra email không rỗng
	    if (email.isEmpty()) {
	        throw new IllegalArgumentException("Email không được rỗng");
	    }

	    // Kiểm tra định dạng
	    if (!email.matches("^(([A-Za-z0-9]+)(([\\.]?)([A-Za-z0-9]+))+)(@)(([A-Za-z0-9]+\\.)([A-Za-z0-9]+))+$")) {
	        throw new IllegalArgumentException("Email không hợp lệ");
	    }

	    this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getNamThanhLap() {
		return namThanhLap;
	}
	public void setNamThanhLap(int namThanhLap) {
	    // Kiểm tra năm thành lập
//	    if (namThanhLap.getTime() <= 0) {
//	        throw new IllegalArgumentException("Năm thành lập không hợp lệ");
//	    }

	    this.namThanhLap = namThanhLap;
	}
	public String getLinhVucXuatBan() {
		return linhVucXuatBan;
	}
	
	public void setLinhVucXuatBan(String linhVucXuatBan) {
	    // Kiểm tra linhVucXuatBan không rỗng
	    if (linhVucXuatBan.isEmpty()) {
	        throw new IllegalArgumentException("Lĩnh vực xuất bản không được rỗng");
	    }

	    this.linhVucXuatBan = linhVucXuatBan;
	}
	
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, linhVucXuatBan, namThanhLap, nhaXuatBanID, quocGia, soDienThoai, tenNhaXuatBan,
				website);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaXuatBan other = (NhaXuatBan) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(linhVucXuatBan, other.linhVucXuatBan)
				&& Objects.equals(namThanhLap, other.namThanhLap) && Objects.equals(nhaXuatBanID, other.nhaXuatBanID)
				&& Objects.equals(quocGia, other.quocGia) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenNhaXuatBan, other.tenNhaXuatBan) && Objects.equals(website, other.website);
	}
	@Override
	public String toString() {
		return "NhaXuatBan [nhaXuatBan=" + nhaXuatBanID + ", tenNhaXuatBan=" + tenNhaXuatBan + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", website=" + website + ", namThanhLap="
				+ namThanhLap + ", linhVucXuatBan=" + linhVucXuatBan + ", quocGia=" + quocGia + "]";
	}
	
}