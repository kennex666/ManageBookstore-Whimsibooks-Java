package entities;

import java.util.Objects;

public class ChiTietTraHang {
	private int soLuong;
	private String liDoTraHang;
	private double donGia;
	private HoaDonTra hoaDon;
	private SanPham sanPham;

	public ChiTietTraHang() {
	}

	public ChiTietTraHang(int soLuong, String liDoTraHang, double donGia, HoaDonTra hoaDon, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.liDoTraHang = liDoTraHang;
		this.donGia = donGia;
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}

	public ChiTietTraHang(SanPham sanPham, int soLuong) {
		// TODO Auto-generated constructor stub
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public HoaDonTra getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDonTra hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong < 0) {
			throw new IllegalArgumentException("Số lượng phải lớn hơn hoặc bằng 0");
		}
		this.soLuong = soLuong;
	}

	public String getLiDoTraHang() {
		return liDoTraHang;
	}

	public void setLiDoTraHang(String liDoTraHang) {
		if (liDoTraHang == null || liDoTraHang.isEmpty()) {
			throw new IllegalArgumentException("Cần có lý do đổi trả hàng");
		}
		this.liDoTraHang = liDoTraHang;
	}

	public double tinhTongTien() {
		// Nếu là đơn giá từ database lưu trữ thì tính theo db, ngược lại là hoá đơn
		// đang lập. Giá bán đã kèm VAT
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
		ChiTietTraHang other = (ChiTietTraHang) obj;
		return Objects.equals(sanPham, other.sanPham);
	}

	// Phương thức toString
	@Override
	public String toString() {
		return liDoTraHang ;
	}
}
