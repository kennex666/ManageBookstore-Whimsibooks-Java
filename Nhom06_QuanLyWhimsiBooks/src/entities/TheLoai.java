package entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import utilities.RegexPattern;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 *
 */

@Entity
public class TheLoai {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private int theLoaiID;
	private String tenTheLoai;
	
	
	
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
