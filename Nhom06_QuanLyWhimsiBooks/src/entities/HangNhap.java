package entities;

import java.sql.Date;

import utilities.RegexPattern;

public class HangNhap {
	private String hangNhapID;
	private Date ngayNhap;
	private double giaTriDon;
	private String maDonDat;
	private String trangThaiNhap;
	private String trangThaiThanhToan;

	public HangNhap() {
	}

	public HangNhap(String hangNhapID) {
		super();
		this.hangNhapID = hangNhapID;
	}

	public HangNhap(String hangNhapID, Date ngayNhap, double giaTriDon, String maDonDat,
			String trangThaiNhap, String trangThaiThanhToan) {
		setHangNhapID(hangNhapID);
		setNgayNhap(ngayNhap);
		setGiaTriDon(giaTriDon);
		setMaDonDat(maDonDat);
		setTrangThaiNhap(trangThaiNhap);
		setTrangThaiThanhToan(trangThaiThanhToan);
	}

	public HangNhap(HangNhap other) {
		this(other.hangNhapID, other.ngayNhap, other.giaTriDon, other.maDonDat,
				other.trangThaiNhap, other.trangThaiThanhToan);
	}

	public String getHangNhapID() {
		return hangNhapID;
	}

	public void setHangNhapID(String hangNhapID) {
		// Kiểm tra chuỗi nhập có chứa ký tự không hợp lệ
		if (!hangNhapID.matches(RegexPattern.MAHANGNHAP)) {
			throw new IllegalArgumentException("Mã hàng nhập cần thoả mãn với yêu cầu trên");
		}
		this.hangNhapID = hangNhapID;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		if (ngayNhap == null) {
			throw new IllegalArgumentException("Chọn ngày nhập khác Rỗng");
		}
		this.ngayNhap = ngayNhap;
	}

	public double getGiaTriDon() {
		return giaTriDon;
	}

	public void setGiaTriDon(double giaTriDon) {
		if (giaTriDon < 0) {
			throw new IllegalArgumentException("Giá trị phải lớn hơn bằng 0");
		}
		this.giaTriDon = giaTriDon;
	}

	public String getMaDonDat() {
		return maDonDat;
	}

	public void setMaDonDat(String maDonDat) {
		this.maDonDat = maDonDat;
	}


	public String getTrangThaiNhap() {
		return trangThaiNhap;
	}

	public void setTrangThaiNhap(String trangThaiNhap) {
		if (trangThaiNhap == null || trangThaiNhap.isEmpty()) {
			throw new IllegalArgumentException("Trạng thái nhập không được rỗng");
		}
		this.trangThaiNhap = trangThaiNhap;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		if (trangThaiThanhToan == null || trangThaiThanhToan.isEmpty()) {
			throw new IllegalArgumentException("Trạng thanh toán không được rỗng");
		}
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	// Phương thức toString
	@Override
	public String toString() {
		return "Hàng nhập [ID: " + hangNhapID + ", Ngày nhập: " + ngayNhap
				+ ", Giá trị đơn: " + giaTriDon + ", Mã đơn đặt hàng: " + maDonDat + ", Trạng thái nhập: " + trangThaiNhap + ", Trạng thái thanh toán: " + trangThaiThanhToan + "]";
	}
}
