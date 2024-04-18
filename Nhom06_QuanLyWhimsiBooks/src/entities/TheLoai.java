package entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import ultilities.RegexPattern;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name ="TheLoai.findAll", query = "SELECT tl FROM TheLoai tl"),
	@NamedQuery(name = "TheLoai.findByName", query = "SELECT tl FROM TheLoai tl WHERE tl.tenTheLoai = :name"),
	@NamedQuery(name = "TheLoai.findByID", query = "SELECT tl FROM TheLoai tl WHERE tl.theLoaiID = :id"),
})
public class TheLoai {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private int theLoaiID;
	private String tenTheLoai;
	
	@OneToMany(mappedBy = "theLoai", fetch = jakarta.persistence.FetchType.LAZY)
	private List<SanPham> sanPhams;
	
	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public int getTheLoaiID() {
		return theLoaiID;
	}

	public void setTheLoaiID(int theLoaiID) {
		this.theLoaiID = theLoaiID;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) throws Exception{
		if (tenTheLoai.trim().isEmpty() || tenTheLoai.trim().isBlank())
			throw new Exception("Tên thể loại không được để trống!");
		this.tenTheLoai = tenTheLoai;
	}

	public TheLoai(int theLoaiID, String tenTheLoai) throws Exception {
		super();
		setTenTheLoai(tenTheLoai);
		setTheLoaiID(theLoaiID);
	}
        public TheLoai() {
		super();

	}

	public TheLoai(int theLoaiID) {
		super();
                setTheLoaiID(theLoaiID);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(theLoaiID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoai other = (TheLoai) obj;
		return theLoaiID == other.theLoaiID;
	}

	@Override
	public String toString() {
		return tenTheLoai;
	}
	

	
}
