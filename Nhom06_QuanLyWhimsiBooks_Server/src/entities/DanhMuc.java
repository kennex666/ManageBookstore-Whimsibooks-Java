package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 *
 */

@NamedQueries({ 
	@NamedQuery(name ="DanhMuc.findAll", query = "SELECT dm FROM DanhMuc dm"),
	@NamedQuery(name = "DanhMuc.findByName", query = "SELECT dm FROM DanhMuc dm WHERE dm.tenDanhMuc = :name"),
	@NamedQuery(name = "DanhMuc.findByID", query = "SELECT dm FROM DanhMuc dm WHERE dm.danhMucID = :id"),
})
@Entity
public class DanhMuc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int danhMucID;
	private String tenDanhMuc;
	
	@OneToMany(mappedBy = "danhMuc")
	private List<SanPham> sanPhams;
	
	public List<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	public int getDanhMucID() {
		return danhMucID;
	}
	public void setDanhMucID(int danhMucID) {
		this.danhMucID = danhMucID;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) throws Exception{
		if (tenDanhMuc.trim().isBlank() || tenDanhMuc.trim().isEmpty())
			throw new Exception("Tên danh mục không được để trống!");
		this.tenDanhMuc = tenDanhMuc;
	}
	public DanhMuc(int danhMucID, String tenDanhMuc) throws Exception{
		super();
		setDanhMucID(danhMucID);
		setTenDanhMuc(tenDanhMuc);
	}
	public DanhMuc() {
		super();
	}
        public DanhMuc(int danhMucID) {
		super();
                setDanhMucID(danhMucID);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(danhMucID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanhMuc other = (DanhMuc) obj;
		return danhMucID == other.danhMucID;
	}
	@Override
	public String toString() {
		return tenDanhMuc;
	}
	
}
