package entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 *
 */

@Entity
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int danhMucID;
	private String tenDanhMuc;
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
