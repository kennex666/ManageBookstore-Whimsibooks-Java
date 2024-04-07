package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChiTietKhuyenMai {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khuyenMaiId")
	private KhuyenMai khuyenMai;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sanPhamId")
	private SanPham sanPham;
	private Date ngayTao;

	public ChiTietKhuyenMai(Date ngayTao) {
		super();
		this.ngayTao = ngayTao;
	}

	public ChiTietKhuyenMai(SanPham sanPham) {
		super();
		this.sanPham = sanPham;
	}
	
	public ChiTietKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham, Date ngayTao) {
		super();
		this.khuyenMai = khuyenMai;
		this.sanPham = sanPham;
		this.ngayTao = ngayTao;
	}

	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	
	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
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
		ChiTietKhuyenMai other = (ChiTietKhuyenMai) obj;
		return Objects.equals(sanPham, other.sanPham);
	}



	@Override
	public String toString() {
		return "ChiTietKhuyenMai [ngayTao=" + ngayTao + "]";
	}
	
	
}
