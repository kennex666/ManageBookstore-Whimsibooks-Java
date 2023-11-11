package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class ChiTietKhuyenMai {
	private KhuyenMai khuyenMai;
	private ArrayList<SanPham> danhSachSP;
	private Date ngayTao;

	public ChiTietKhuyenMai(Date ngayTao) {
		super();
		this.ngayTao = ngayTao;
	}

	public ChiTietKhuyenMai(KhuyenMai khuyenMai, ArrayList<SanPham> danhSachSP, Date ngayTao) {
		super();
		this.khuyenMai = khuyenMai;
		this.danhSachSP = danhSachSP;
		this.ngayTao = ngayTao;
	}
	
	
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public ArrayList<SanPham> getDanhSachSP() {
		return danhSachSP;
	}

	public void setDanhSachSP(ArrayList<SanPham> danhSachSP) {
		this.danhSachSP = danhSachSP;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ngayTao);
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
		return Objects.equals(ngayTao, other.ngayTao);
	}

	@Override
	public String toString() {
		return "ChiTietKhuyenMai [ngayTao=" + ngayTao + "]";
	}
	
	
}
