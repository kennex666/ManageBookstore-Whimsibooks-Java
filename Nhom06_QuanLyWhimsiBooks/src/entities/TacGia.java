package entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ultilities.RegexPattern;

@Entity
public class TacGia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tacGiaID;
	private String tenTacGia, quocTich;
	public int getTacGiaID() {
		return tacGiaID;
	}
	public void setTacGiaID(int tacGiaID) {
		this.tacGiaID = tacGiaID;
	}
	public String getTenTacGia() {
		return tenTacGia;
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
