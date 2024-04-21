package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "NhaCungCap.findByPhone", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.soDienThoai like :soDienThoai"),
	@NamedQuery(name = "NhaCungCap.getNCCCC", query = "SELECT COUNT(ncc) FROM NhaCungCap ncc", resultClass = Long.class),
	@NamedQuery(name = "NhaCungCap.findByEmail", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.email like :email"),
	@NamedQuery(name ="NhaCungCap.findAll", query = "SELECT ncc FROM NhaCungCap ncc"),
	@NamedQuery(name = "NhaCungCap.findByName", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.tenNhaCungCap = :name"),
	@NamedQuery(name = "NhaCungCap.findByID", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.nhaCungCapID = :id"),
})
public class NhaCungCap implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "NhaCungCap [nhaCungCapID=" + nhaCungCapID + ", tenNhaCungCap=" + tenNhaCungCap + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", email=" + email + ", sanPhams=" + sanPhams + "]";
	}

	@Id
	@Column(name = "nhaCungCapID", columnDefinition = "NVARCHAR(255)")
	private String nhaCungCapID;
	@Column(name = "tenNhaCungCap", columnDefinition = "NVARCHAR(255)")
	private String tenNhaCungCap;
	@Column(name = "soDienThoai", columnDefinition = "NVARCHAR(255)")
	private String soDienThoai;
	@Column(name = "diaChi", columnDefinition = "NVARCHAR(255)")
	private String diaChi;
	@Column(name = "email", columnDefinition = "NVARCHAR(255)")
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
