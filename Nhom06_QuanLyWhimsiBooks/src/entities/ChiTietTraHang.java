package entities;

public class ChiTietTraHang {
	private int soLuong;
	private String liDoTraHang;
	private String hoaDonTraID;

	public ChiTietTraHang() {
	}

	public ChiTietTraHang(int soLuong, String liDoTraHang, String hoaDonTraID) {
		setSoLuong(soLuong);
		setLiDoTraHang(liDoTraHang);
		this.hoaDonTraID = hoaDonTraID;
	}

	public ChiTietTraHang(ChiTietTraHang khac) {
		this(khac.soLuong, khac.liDoTraHang, khac.hoaDonTraID);
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

	public String getHoaDonTraID() {
		return hoaDonTraID;
	}

	// Phương thức toString
	@Override
	public String toString() {
		return "Chi tiết trả hàng [Số lượng: " + soLuong + ", Lý do trả hàng: " + liDoTraHang + ", ID hóa đơn trả: "
				+ hoaDonTraID + "]";
	}
}
