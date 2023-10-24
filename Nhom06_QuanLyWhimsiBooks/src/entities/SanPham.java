package entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class SanPham {
	private int sanPhamID, soLuongTon, namSanXuat, daBan, soTrang;
	private Date ngayNhap;
	private double donGia, thue;
	private String tenSanPham, barcode, imgPath, 
					tinhTrang, loaiSanPham, donViDoLuong, 
					kichThuoc, xuatXu, ngonNgu, loaiBia;
	
	// Thuộc tính mới trong csdl dưới dạng ID ==>>> Đổi về đối tượng, nhớ kiểm tra xem có tồn tại hay không?
	private TacGia tacGia;
	private TheLoai theLoai;
	
	public int getSanPhamID() {
		return sanPhamID;
	}
	public void setSanPhamID(int sanPhamID) {
		this.sanPhamID = sanPhamID;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) throws Exception{
		if (soLuongTon < 0)
			throw new Exception("Số lượng không được âm");
		this.soLuongTon = soLuongTon;
	}
	public int getNamSanXuat() {
		return namSanXuat;
	}
	public void setNamSanXuat(int namSanXuat) throws Exception{
		if (namSanXuat > LocalDate.now().getYear())
			throw new Exception("Năm không được lớn hơn hiện tại");
		this.namSanXuat = namSanXuat;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) throws Exception{
		if (soTrang < 1) 
			throw new Exception("Số trang tối thiểu là 1");
		this.soTrang = soTrang;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) throws Exception{
		if (donGia < 0)
			throw new Exception("Đơn giá không được âm");
		this.donGia = donGia;
	}
	public double getThue() {
		return thue;
	}
	public void setThue(double thue) throws Exception{
		if (thue < 0)
			throw new Exception("Thuế không được âm");
		this.thue = thue;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) throws Exception{
		if (tenSanPham.trim().isEmpty() || tenSanPham.trim().isBlank()) {
			throw new Exception("Tên sản phẩm không được để trống");
		}
		this.tenSanPham = tenSanPham;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) throws Exception{
		if (barcode.trim().isEmpty() || barcode.trim().isBlank()) {
			throw new Exception("Barcode không được để trống!");
		}
		this.barcode = barcode;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public String getDonViDoLuong() {
		return donViDoLuong;
	}
	public void setDonViDoLuong(String donViDoLuong) {
		this.donViDoLuong = donViDoLuong;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getLoaiBia() {
		return loaiBia;
	}
	public void setLoaiBia(String loaiBia) {
		this.loaiBia = loaiBia;
	}
	
	public int getDaBan() {
		return daBan;
	}
	public void setDaBan(int daBan) {
		this.daBan = daBan;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	
	public SanPham(int sanPhamID, int soLuongTon, int namSanXuat, int soTrang, Date ngayNhap, double donGia,
			double thue, String tenSanPham, String barcode, String imgPath, String tinhTrang, String loaiSanPham,
			String donViDoLuong, String kichThuoc, String xuatXu, String ngonNgu, String loaiBia) throws Exception{
		super();
		setSanPhamID(sanPhamID);
		setSoLuongTon(soLuongTon);
		setNamSanXuat(namSanXuat);
		setSoTrang(soTrang);
		setNgayNhap(ngayNhap);
		setDonGia(donGia);
		setThue(thue);
		setTenSanPham(tenSanPham);
		setBarcode(barcode);
		setImgPath(imgPath);
		setTinhTrang(tinhTrang);
		setLoaiSanPham(loaiSanPham);
		setDonViDoLuong(donViDoLuong);
		setKichThuoc(kichThuoc);
		setXuatXu(xuatXu);
		setNgonNgu(ngonNgu);
		setLoaiBia(loaiBia);
	}
	
	
	public SanPham() {
		super();
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(sanPhamID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return sanPhamID == other.sanPhamID;
	}
	@Override
	public String toString() {
		return tenSanPham;
	}
	
}
