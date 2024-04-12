package entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "ChiTietTraHang.deleteAllByHoaDonID", 
            query = "DELETE FROM ChiTietTraHang cthd WHERE cthd.hoaDon.hoaDonID = :hoaDonID"),
    @NamedQuery(name = "ChiTietTraHang.findAllByHoaDonID",
            query = "SELECT cthd FROM ChiTietTraHang cthd WHERE cthd.hoaDon.hoaDonID = :hoaDonID")
})
public class ChiTietTraHang {
	private int soLuong;
	private String liDoTraHang;
	private double donGia;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hoaDonId")
	private HoaDonTra hoaDon;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sanPhamId")
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
