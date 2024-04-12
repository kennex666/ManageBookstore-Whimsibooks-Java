package entities;

import java.sql.Date;
import java.util.List;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "KhuyenMai.getALL", query = "SELECT km FROM KhuyenMai km"),
	@NamedQuery(name = "KhuyenMai.getRecentKhuyenMai", query = "SELECT KM FROM KhuyenMai KM ORDER BY ngayKhuyenMai DESC"),
	@NamedQuery(name = "KhuyenMai.xoaSanPhamKhuyenMai", query = "DELETE FROM ChiTietKhuyenMai ctkm WHERE ctkm.khuyenMai.codeKhuyenMai = :maKM"),
	@NamedQuery(name = "KhuyenMai.getChiTietKhuyenMaiTheoMa", query = "SELECT ctkm FROM ChiTietKhuyenMai ctkm WHERE ctkm.khuyenMai.codeKhuyenMai = :maKM")
})
public class KhuyenMai {
	@Id
	private String codeKhuyenMai;
	private String tenKhuyenMai;
	@Column(name = "LoaiGiamGia")
	private String loaiKhuyenMai; // PHAM_TRAM && GIA_TRI
	private double giaTri;
	private Date ngayKhuyenMai;
	private Date ngayHetHanKM;
	private double donHangTu;
	private int soLuongKhuyenMai, soLuotDaApDung;

	@OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY)
	private List<ChiTietKhuyenMai> listApDung;
	
	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	@OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY)
	private List<HoaDon> hoaDons;

	public KhuyenMai(String codeKhuyenMai, String tenKhuyenMai, String loaiKhuyenMai, double giaTri, Date ngayKhuyenMai,
			Date ngayHetHanKM, double donHangTu) {
		this.setCodeKhuyenMai(codeKhuyenMai);
		this.setTenKhuyenMai(tenKhuyenMai);
		this.setLoaiKhuyenMai(loaiKhuyenMai);
		this.setGiaTri(giaTri);
		this.setNgayKhuyenMai(ngayKhuyenMai);
		this.setNgayHetHanKM(ngayHetHanKM);
		this.setDonHangTu(donHangTu);
	}

	public KhuyenMai(String codeKhuyenMai, String tenKhuyenMai, String loaiKhuyenMai, double giaTri, Date ngayKhuyenMai,
			Date ngayHetHanKM, double donHangTu, int soLuongKhuyenMai, int soLuotDaApDung) {
		this.codeKhuyenMai = codeKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.loaiKhuyenMai = loaiKhuyenMai;
		this.giaTri = giaTri;
		this.ngayKhuyenMai = ngayKhuyenMai;
		this.ngayHetHanKM = ngayHetHanKM;
		this.donHangTu = donHangTu;
		this.soLuongKhuyenMai = soLuongKhuyenMai;
		this.soLuotDaApDung = soLuotDaApDung;
	}

	public List<ChiTietKhuyenMai> getListApDung() {
		return listApDung;
	}

	public void setListApDung(List<ChiTietKhuyenMai> listApDung) {
		this.listApDung = listApDung;
	}

	public List<ChiTietKhuyenMai> getChiTietKhuyenMai() {
		return listApDung;
	}

	public void setChiTietKhuyenMai(List<ChiTietKhuyenMai> listApDung) {
		this.listApDung = listApDung;
	}

	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhuyenMai(String codeKhuyenMai) {
		this.codeKhuyenMai = codeKhuyenMai;
	}

	public String getCodeKhuyenMai() {
		return codeKhuyenMai;
	}

	public void setCodeKhuyenMai(String codeKhuyenMai) {
		this.codeKhuyenMai = codeKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public String getLoaiKhuyenMai() {
		return loaiKhuyenMai;
	}

	public void setLoaiKhuyenMai(String loaiKhuyenMai) {
		this.loaiKhuyenMai = loaiKhuyenMai;
	}

	public double getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	}

	public Date getNgayKhuyenMai() {
		return ngayKhuyenMai;
	}

	public void setNgayKhuyenMai(Date ngayKhuyenMai) {
		this.ngayKhuyenMai = ngayKhuyenMai;
	}

	public Date getNgayHetHanKM() {
		return ngayHetHanKM;
	}

	public void setNgayHetHanKM(Date ngayHetHanKM) {
		this.ngayHetHanKM = ngayHetHanKM;
	}

	public double getDonHangTu() {
		return donHangTu;
	}

	public void setDonHangTu(double donHangTu) {
		this.donHangTu = donHangTu;
	}

	public int getSoLuongKhuyenMai() {
		return soLuongKhuyenMai;
	}

	public void setSoLuongKhuyenMai(int soLuongKhuyenMai) {
		this.soLuongKhuyenMai = soLuongKhuyenMai;
	}

	public int getSoLuotDaApDung() {
		return soLuotDaApDung;
	}

	public void setSoLuotDaApDung(int soLuotDaApDung) {
		this.soLuotDaApDung = soLuotDaApDung;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeKhuyenMai, donHangTu, giaTri, loaiKhuyenMai, ngayHetHanKM, ngayKhuyenMai,
				soLuongKhuyenMai, soLuotDaApDung, tenKhuyenMai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(codeKhuyenMai, other.codeKhuyenMai)
				&& Double.doubleToLongBits(donHangTu) == Double.doubleToLongBits(other.donHangTu)
				&& Double.doubleToLongBits(giaTri) == Double.doubleToLongBits(other.giaTri)
				&& Objects.equals(loaiKhuyenMai, other.loaiKhuyenMai)
				&& Objects.equals(ngayHetHanKM, other.ngayHetHanKM)
				&& Objects.equals(ngayKhuyenMai, other.ngayKhuyenMai) && soLuongKhuyenMai == other.soLuongKhuyenMai
				&& soLuotDaApDung == other.soLuotDaApDung && Objects.equals(tenKhuyenMai, other.tenKhuyenMai);
	}

	@Override
	public String toString() {
		return "KhuyenMai [codeKhuyenMai=" + codeKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", loaiKhuyenMai="
				+ loaiKhuyenMai + ", giaTri=" + giaTri + ", ngayKhuyenMai=" + ngayKhuyenMai + ", ngayHetHanKM="
				+ ngayHetHanKM + ", donHangTu=" + donHangTu + ", soLuongKhuyenMai=" + soLuongKhuyenMai
				+ ", soLuotDaApDung=" + soLuotDaApDung + "]";
	}

}
