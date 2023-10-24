package entities;

import java.sql.Date;

import utilities.RegexPattern;

public class HangNhap {
	private String hangNhapID;
	private int soLuong;
	private Date ngayNhap;
	private double giaTriDon;
	private String maDonDat;
	private double thue;
	private String trangThaiNhap;
	private String trangThaiThanhToan;

	public HangNhap() {
	}

	public HangNhap(String hangNhapID, int soLuong, Date ngayNhap, double giaTriDon, String maDonDat, double thue,
			String trangThaiNhap, String trangThaiThanhToan) {
		setHangNhapID(hangNhapID);
		setSoLuong(soLuong);
		setNgayNhap(ngayNhap);
		setGiaTriDon(giaTriDon);
		setMaDonDat(maDonDat);
		setThue(thue);
		setTrangThaiNhap(trangThaiNhap);
		setTrangThaiThanhToan(trangThaiThanhToan);
	}

	public HangNhap(HangNhap other) {
		this(other.hangNhapID, other.soLuong, other.ngayNhap, other.giaTriDon, other.maDonDat, other.thue,
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong < 0) {
			throw new IllegalArgumentException("Số lượng phải lớn hơn bằng 0");
		}
		this.soLuong = soLuong;
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

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		if (thue < 0) {
			throw new IllegalArgumentException("Thuế phải lớn hơn bằng 0");
		}
		this.thue = thue;
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
		return "Hàng nhập [ID: " + hangNhapID + ", Số lượng: " + soLuong + ", Ngày nhập: " + ngayNhap
				+ ", Giá trị đơn: " + giaTriDon + ", Mã đơn đặt hàng: " + maDonDat + ", Thuế: " + thue
				+ ", Trạng thái nhập: " + trangThaiNhap + ", Trạng thái thanh toán: " + trangThaiThanhToan + "]";
	}
}
