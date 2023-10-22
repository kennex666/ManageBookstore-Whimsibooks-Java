package entities;

import java.util.Objects;

public class ChiTietHoaDon {
	private int soLuong;

	public ChiTietHoaDon(int soLuong) {
		super();
		this.soLuong = soLuong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
	    // Kiểm tra soLuong > 0
	    if (soLuong <= 0) {
	        throw new IllegalArgumentException("Số lượng phải là số nguyên dương");
	    }

	    this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return soLuong == other.soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + "]";
	}
	
}
