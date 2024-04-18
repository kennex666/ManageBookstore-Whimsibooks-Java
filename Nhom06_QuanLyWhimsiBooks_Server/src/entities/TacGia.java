package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import ultilities.RegexPattern;

@Entity
@NamedQueries({ 
	@NamedQuery(name ="TacGia.findAll", query = "SELECT tg FROM TacGia tg"),
	@NamedQuery(name = "TacGia.findByName", query = "SELECT tg FROM TacGia tg WHERE tg.tenTacGia = :name"),
	@NamedQuery(name = "TacGia.findByID", query = "SELECT tg FROM TacGia tg WHERE tg.tacGiaID = :id"),
})
public class TacGia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tacGiaID;
	private String tenTacGia, quocTich;
	
	@OneToMany(mappedBy = "tacGia", fetch = FetchType.LAZY)
	private List<SanPham> sanPhams;
	
	public int getTacGiaID() {
		return tacGiaID;
	}
	public void setTacGiaID(int tacGiaID) {
		this.tacGiaID = tacGiaID;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public List<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	public void setTenTacGia(String tenTacGia) throws Exception{
		if (tenTacGia.trim().isBlank() || tenTacGia.isEmpty())
			throw new Exception("Tên tác giả không được để trống");
		this.tenTacGia = tenTacGia;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) throws Exception{
		this.quocTich = quocTich;
	}
	
	public TacGia(int tacGiaID, String tenTacGia, String quocTich) throws Exception{
		super();
		setQuocTich(quocTich);
		setTacGiaID(tacGiaID);
		setTenTacGia(tenTacGia);
	}
	
        public TacGia(int tacGiaID) {
            setTacGiaID(tacGiaID);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(tacGiaID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGia other = (TacGia) obj;
	
                return tacGiaID == other.tacGiaID;
	}

	public TacGia() {
		super();
	}
	
}
