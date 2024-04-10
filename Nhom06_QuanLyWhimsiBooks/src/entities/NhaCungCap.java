package entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class NhaCungCap {
	@Id
	private String nhaCungCapID;
	private String tenNhaCungCap;
	private String soDienThoai;
	private String diaChi;
	private String email;
	
	@OneToMany(mappedBy = "nhaCungCap")
	private List<SanPham> sanPhams;
	
	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public NhaCungCap(String nhaCungCapID, String tenNhaCungCap, String soDienThoai, String email, String diaChi) {
		this.nhaCungCapID = nhaCungCapID;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
	}

	public NhaCungCap(String nhaCungCapID) {
		this.nhaCungCapID = nhaCungCapID;
	}
	
	public NhaCungCap(String soDienThoai, String email) {
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	public String getNhaCungCapID() {
		return nhaCungCapID;
	}

	public void setNhaCungCapID(String nhaCungCapID) {
		this.nhaCungCapID = nhaCungCapID;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, nhaCungCapID, soDienThoai, tenNhaCungCap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(nhaCungCapID, other.nhaCungCapID) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenNhaCungCap, other.tenNhaCungCap);
	}
	
}
