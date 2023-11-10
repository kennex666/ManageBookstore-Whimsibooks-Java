package entities;


import java.sql.Date;
import java.util.Objects;

public class KhuyenMai {
	private String codeKhuyenMai;
	private String tenKhuyenMai;
	private String loaiKhuyenMai;
	private double giaTri;
	private Date ngayKhuyenMai;
	private Date ngayHetHanKM;
	private double donHangTu;
	private int soLuongKhuyenMai, soLuotDaApDung;

	/**
	 * @param codeKhuyenMai
	 * @param tenKhuyenMai
	 * @param loaiKhuyenMai
	 * @param giaTri
	 * @param ngayKhuyenMai
	 * @param ngayHetHanKM
	 * @param donHangTu
	 */
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
		super();
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



	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
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



	public String getCodeKhuyenMai() {
		return codeKhuyenMai;
	}
	
	public void setCodeKhuyenMai(String codeKhuyenMai) throws IllegalArgumentException {
	    // Kiểm tra xem codeKhuyenMai chỉ chứa ký tự hợp lệ và có ít nhất 6 ký tự
	    if (codeKhuyenMai.matches("^[A-Za-z0-9_]+$") && codeKhuyenMai.length() >= 6) {
	        this.codeKhuyenMai = codeKhuyenMai;
	    } else {
	        throw new IllegalArgumentException("Mã khuyến mãi cần ít nhất 6 ký tự");
	    }
	}
	
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	
	public void setTenKhuyenMai(String tenKhuyenMai) throws IllegalArgumentException {
	    if (!tenKhuyenMai.isEmpty() && tenKhuyenMai.length() > 0) {
	        this.tenKhuyenMai = tenKhuyenMai;
	    } else {
	        throw new IllegalArgumentException("Tên khuyến mãi không thể rỗng");
	    }
	}
	
	public String getLoaiKhuyenMai() {
		return loaiKhuyenMai;
	}
	
	public void setLoaiKhuyenMai(String loaiKhuyenMai) throws IllegalArgumentException {
	    if (loaiKhuyenMai != null && !loaiKhuyenMai.isEmpty() && (loaiKhuyenMai.equals("GIA_TRI") || loaiKhuyenMai.equals("PHAN_TRAM"))) {
	        this.loaiKhuyenMai = loaiKhuyenMai;
	    } else {
	        throw new IllegalArgumentException("Loại khuyến mãi không hợp lệ");
	    }
	}
	
	public double getGiaTri() {
		return giaTri;
	}
	
	public void setGiaTri(double giaTri) throws IllegalArgumentException {
	    if (giaTri > 0) {
	        this.giaTri = giaTri;
	    } else {
	        throw new IllegalArgumentException("Giá trị giảm giá không thể là một số âm hoặc bằng 0.");
	    }
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

	public void setNgayHetHanKM(Date ngayHetHanKM) throws IllegalArgumentException {
	    if (ngayKhuyenMai != null && ngayHetHanKM != null && ngayHetHanKM.before(ngayKhuyenMai)) {
	        throw new IllegalArgumentException("Ngày hết hạn không thể trước ngày khuyến mãi");
	    }
	    this.ngayHetHanKM = ngayHetHanKM;
	}

	public double getDonHangTu() {
		return donHangTu;
	}

	public void setDonHangTu(double donHangTu) throws IllegalArgumentException {
	    if (donHangTu >= 0) {
	        this.donHangTu = donHangTu;
	    } else {
	        throw new IllegalArgumentException("Giá trị đơn hàng phải từ 0 trở lên");
	    }
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(codeKhuyenMai, donHangTu, giaTri, loaiKhuyenMai, ngayHetHanKM, ngayKhuyenMai, tenKhuyenMai);
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
				&& Objects.equals(ngayKhuyenMai, other.ngayKhuyenMai)
				&& Objects.equals(tenKhuyenMai, other.tenKhuyenMai);
	}

	@Override
	public String toString() {
		return "KhaiMai [codeKhuyenMai=" + codeKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", loaiKhuyenMai="
				+ loaiKhuyenMai + ", giaTri=" + giaTri + ", ngayKhuyenMai=" + ngayKhuyenMai + ", ngayHetHanKM="
				+ ngayHetHanKM + ", donHangTu=" + donHangTu + "]";
	}
}
