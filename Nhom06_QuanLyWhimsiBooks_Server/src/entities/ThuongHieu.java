package entities;

import java.io.Serializable;
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
	@NamedQuery(name = "ThuongHieu.listThuongHieu", query = "SELECT th FROM ThuongHieu th"),
	@NamedQuery(name = "ThuongHieu.findByName", query = "SELECT th FROM ThuongHieu th WHERE th.tenThuongHieu = :name"),
	@NamedQuery(name = "ThuongHieu.findByID", query = "SELECT th FROM ThuongHieu th WHERE th.thuongHieuID = :id"),
})
public class ThuongHieu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int thuongHieuID;
	@Column(name = "tenThuongHieu", columnDefinition = "NVARCHAR(255)")
	private String tenThuongHieu;
	
	@OneToMany(mappedBy = "thuongHieu", fetch = jakarta.persistence.FetchType.LAZY)
	private List<SanPham> sanPhams;
	
	public int getThuongHieuID() {
		return thuongHieuID;
	}
	public void setThuongHieuID(int thuongHieuID) {
		this.thuongHieuID = thuongHieuID;
	}
	public String getTenThuongHieu() {
		return tenThuongHieu;
	}
	public void setTenThuongHieu(String tenThuongHieu) throws Exception {
		this.tenThuongHieu = tenThuongHieu;
	}
	
	public List<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	public ThuongHieu(int thuongHieuID, String tenThuongHieu) throws Exception {
		super();
		setTenThuongHieu(tenThuongHieu);
		setThuongHieuID(thuongHieuID);
	}
	public ThuongHieu() {
		super();
	}
        
        public ThuongHieu(int thuongHieuID) {
		super();
                setThuongHieuID(thuongHieuID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(thuongHieuID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThuongHieu other = (ThuongHieu) obj;
		return thuongHieuID == other.thuongHieuID;
	}
	@Override
    public String toString() {
        return thuongHieuID + ": " + tenThuongHieu;
    }
}
