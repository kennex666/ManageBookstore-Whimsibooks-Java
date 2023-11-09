package entities;

import java.util.Objects;

public class ChiTietHoaDon {
	private int soLuong;
    private double donGia; // Dẫn xuất
    private SanPham sanPham;

	public ChiTietHoaDon(SanPham sanPham, int soLuong) {
		super();
		this.soLuong = soLuong;
		this.sanPham = sanPham;
	}

	public ChiTietHoaDon() {
		super();
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
	

	public double getDonGia() {
		return donGia;
	}


	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	public double tinhTongTien() {
		// Nếu là đơn giá từ database lưu trữ thì tính theo db, ngược lại là hoá đơn
		// đang lập
		return donGia > 0 ? donGia * soLuong : (soLuong * sanPham.getGiaBan());
	}


	@Override
	public int hashCode() {
		return Objects.hash(sanPham);
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
		return Objects.equals(sanPham, other.sanPham);
	}

	@Override
	public String toString() {
		return sanPham.getTenSanPham();
	}
	
}
