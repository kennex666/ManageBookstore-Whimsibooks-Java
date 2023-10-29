package entities;

public class NhaCungCap {
	private String nhaCungCapID;
	private String tenNhaCungCap;
	private String soDienThoai;
	private String diaChi;
	private String email;
	private HangNhap hangNhap;
	
	public NhaCungCap(String nhaCungCapID, String tenNhaCungCap, String soDienThoai, String diaChi, String email) {
		this.nhaCungCapID = nhaCungCapID;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
	}

	public NhaCungCap(String nhaCungCapID,HangNhap hangNhap, String tenNhaCungCap, String soDienThoai, String diaChi, String email) {
		super();
		this.nhaCungCapID = nhaCungCapID;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
		this.hangNhap = hangNhap;
	}

	public NhaCungCap(String nhaCungCapID) {
		this.nhaCungCapID = nhaCungCapID;
	}

	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	public String getNhaCungCapID() {
		return nhaCungCapID;
	}

	public void setNhaCungCapID(String nhaCungCapID) {
		this.nhaCungCapID = nhaCungCapID;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HangNhap getHangNhap() {
		return hangNhap;
	}

	public void setHangNhap(HangNhap hangNhap) {
		this.hangNhap = hangNhap;
	}
	
	
	
}
