package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name ="NhaXuatBan.findAll", query = "SELECT nxb FROM NhaXuatBan nxb"),
	@NamedQuery(name = "NhaXuatBan.findByName", query = "SELECT nxb FROM NhaXuatBan nxb WHERE nxb.tenNhaXuatBan = :name"),
	@NamedQuery(name = "NhaXuatBan.findByID", query = "SELECT nxb FROM NhaXuatBan nxb WHERE nxb.nhaXuatBanID = :id"),
})
public class NhaXuatBan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nhaXuatBanID;
	@Column(name = "tenNhaXuatBan", columnDefinition = "NVARCHAR(255)")
	private String tenNhaXuatBan;
	@Column(name = "diaChi", columnDefinition = "NVARCHAR(255)")
	private String diaChi;
	@Column(name = "soDienThoai", columnDefinition = "NVARCHAR(255)")
	private String soDienThoai;
	@Column(name = "email", columnDefinition = "NVARCHAR(255)")
	private String email;
	@Column(name = "website", columnDefinition = "NVARCHAR(255)")
	private String website;
	private int namThanhLap;
	@Column(name = "linhVucXuatBan", columnDefinition = "NVARCHAR(255)")
	private String linhVucXuatBan;
	@Column(name = "quocGia", columnDefinition = "NVARCHAR(255)")
	private String quocGia;
	
	@OneToMany(mappedBy = "nhaXuatBan")
	private List<SanPham> sanPhams;

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
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
	    // Kiểm tra soDienThoai không rỗng
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
//	    if (email.isEmpty()) {
//	        throw new IllegalArgumentException("Email không được rỗng");
//	    }
//
//	    // Kiểm tra định dạng
//	    if (!email.matches("^(([A-Za-z0-9]+)(([\\.]?)([A-Za-z0-9]+))+)(@)(([A-Za-z0-9]+\\.)([A-Za-z0-9]+))+$")) {
//	        throw new IllegalArgumentException("Email không hợp lệ");
//	    }

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

	    this.namThanhLap = namThanhLap;
	}
	public String getLinhVucXuatBan() {
		return linhVucXuatBan;
	}
	
	public void setLinhVucXuatBan(String linhVucXuatBan) {
	    // Kiểm tra linhVucXuatBan không rỗng
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