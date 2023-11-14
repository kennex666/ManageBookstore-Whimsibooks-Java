package entities;

import java.util.Objects;

public class ThuongHieu {
	private int thuongHieuID;
	private String tenThuongHieu;
	
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
	
	public ThuongHieu(int thuongHieuID, String tenThuongHieu) throws Exception {
		super();
		setTenThuongHieu(tenThuongHieu);
		setThuongHieuID(thuongHieuID);
	}
	public ThuongHieu() {
		super();
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
