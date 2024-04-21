package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "HoaDon.findAll", query = "SELECT hd FROM HoaDon hd"
			+ " WHERE YEAR(hd.ngayLapHoaDon) = YEAR(CURRENT_DATE()) AND "
			+ "MONTH(hd.ngayLapHoaDon) = MONTH(CURRENT_DATE()) AND "
			+ "DAY(hd.ngayLapHoaDon) = DAY(CURRENT_DATE()) ORDER BY hd.ngayLapHoaDon DESC"),
	
	@NamedQuery(name = "HoaDon.findAllByDate", query = "SELECT hd FROM HoaDon hd WHERE hd.ngayLapHoaDon BETWEEN :batDau AND :ketThuc ORDER BY hd.ngayLapHoaDon DESC"),
	
	@NamedQuery(name = "HoaDon.findAllByDateAndIsProccess", query = "SELECT hd FROM HoaDon hd WHERE hd.ngayLapHoaDon BETWEEN :batDau AND :ketThuc AND hd.trangThai = 'DA_XU_LY' ORDER BY hd.ngayLapHoaDon DESC"),
	
	@NamedQuery(name = "HoaDon.findById", query = "SELECT hd FROM HoaDon hd WHERE hd.hoaDonID = :hoaDonID"),
	@NamedQuery(name = "HoaDon.ThongKeDoanhThu", query =  "SELECT sp.id, sp.barcode, sp.tenSanPham, sp.soLuongTon, SUM(cthd.soLuong) AS daBan, "
	                + "SUM(cthd.soLuong * cthd.donGia) AS tongDoanhThu, "
	                + "SUM(cthd.soLuong * sp.giaNhap) AS tongVon "
	                + "FROM SanPham sp "
	                + "JOIN sp.chiTietHoaDons cthd "
	                + "JOIN cthd.hoaDon hd "
	                + "WHERE hd.ngayLapHoaDon BETWEEN :batDau AND :ketThuc AND hd.trangThai = :trangThai "
	                + "GROUP BY sp.id, sp.barcode, sp.tenSanPham, sp.soLuongTon, sp.giaNhap "
	                + "ORDER BY daBan DESC", resultClass = Object[].class),
	@NamedQuery(name = "HoaDon.countToday", query = "SELECT COUNT(hd) FROM HoaDon hd WHERE YEAR(hd.ngayLapHoaDon) = YEAR(CURRENT_DATE) AND "
	            + "MONTH(hd.ngayLapHoaDon) = MONTH(CURRENT_DATE) AND DAY(hd.ngayLapHoaDon) = DAY(CURRENT_DATE)", resultClass = Long.class),
	
	@NamedQuery(name = "HoaDon.traHoaDon", query = "UPDATE HoaDon hd SET hd.trangThai = 'TRA_HANG' WHERE hd.hoaDonID = :hoaDonID"),
})
public class HoaDon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "NVARCHAR(255)")
	private String hoaDonID;
	private Date ngayLapHoaDon;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String trangThai; // 3 state: CHO_XU_LY, DA_XU_LY, HUY_BO

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hoaDon")
	private List<ChiTietHoaDon> listChiTietHoaDon;
	
	private double tongTien, thue, giaKhuyenMai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nhanVienId")
	private NhanVien nhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codeKhuyenMai")
	private KhuyenMai khuyenMai;

	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, List<ChiTietHoaDon> listChiTietHoaDon,
			double tongTien, double thue, double giaKhuyenMai) {
		super();
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
		this.listChiTietHoaDon = listChiTietHoaDon;
		this.tongTien = tongTien;
		this.thue = thue;
		this.giaKhuyenMai = giaKhuyenMai;
	}

	public HoaDon(String hoaDonID) {
		super();
		this.hoaDonID = hoaDonID;
		listChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
	}

	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, List<ChiTietHoaDon> listChiTietHoaDon,
			double tongTien, double thue, double giaKhuyenMai, NhanVien nhanVien, KhachHang khachHang,
			KhuyenMai khuyenMai) {
		super();
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
		this.listChiTietHoaDon = listChiTietHoaDon;
		this.tongTien = tongTien;
		this.thue = thue;
		this.giaKhuyenMai = giaKhuyenMai;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
	}

	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, List<ChiTietHoaDon> listChiTietHoaDon,
			double thue, double giaKhuyenMai) {
		super();
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
		this.listChiTietHoaDon = listChiTietHoaDon;
		this.thue = thue;
		this.giaKhuyenMai = giaKhuyenMai;
	}

	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai) {
		this.hoaDonID = hoaDonID;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
	}

	public HoaDon() {
		super();
		listChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
	}

	public void setListChiTietHoaDon(List<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public double getGiaKhuyenMai() {
		return giaKhuyenMai;
	}

	public void setGiaKhuyenMai(double giaKhuyenMai) {
		this.giaKhuyenMai = giaKhuyenMai;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getHoaDonID() {
		return hoaDonID;
	}

	public void setHoaDonID(String hoaDonID) {
		this.hoaDonID = hoaDonID;
	}

	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public double getTongTien() {
		return tongTien > 0 ? tongTien : tinhThanhTien();
	}

	public double tinhTongTien() {
		tongTien = 0;
		for (ChiTietHoaDon x : listChiTietHoaDon)
			tongTien += x.tinhTongTien();
		return tongTien;
	}

	public double tinhTongThue() {
		thue = 0;
		for (ChiTietHoaDon x : listChiTietHoaDon)
			thue += (x.getSanPham().getGiaBan() * x.getSoLuong()) * x.getSanPham().getThue();
		return thue;
	}

	public double tinhThanhTien() {
		return tinhTongTien() - getGiaKhuyenMai();
	}

	public int addChiTietHoaDon(ChiTietHoaDon x) {
		if (listChiTietHoaDon.contains(x)) {
			int temp = listChiTietHoaDon.indexOf(x);
			listChiTietHoaDon.get(temp).setSoLuong(listChiTietHoaDon.get(temp).getSoLuong() + 1);
			return temp;
		}

		listChiTietHoaDon.add(x);
		return -1;

	}

	public void editSoLuong(ChiTietHoaDon x) {
		if (listChiTietHoaDon.contains(x)) {
			listChiTietHoaDon.get(listChiTietHoaDon.indexOf(x)).setSoLuong(x.getSoLuong() + 1);
		} else {
			addChiTietHoaDon(x);
		}
	}

	public void removeChiTietHoaDon(ChiTietHoaDon x) {
		listChiTietHoaDon.remove(x);
	}

	public void removeAllChiTietHoaDon() {
		while (listChiTietHoaDon.size() > 0) {
			listChiTietHoaDon.remove(0);
		}
	}
	
	public List<Object[]> tableChiTietHoaDon() {
		List<Object[]> lines = new ArrayList<Object[]>();

		for (int i = 0; i < listChiTietHoaDon.size(); i++) {
			ChiTietHoaDon tempCTHD = ((ArrayList<ChiTietHoaDon>) listChiTietHoaDon).get(i);
			lines.add(tableRowChiTietHoaDon(tempCTHD));

		}
		return lines;
	}
	

	public List<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}
	

	public Object[] tableRowChiTietHoaDon(ChiTietHoaDon x) {
		Object[] tempObj = new Object[10];
		ChiTietHoaDon tempCTHD = listChiTietHoaDon.get(listChiTietHoaDon.indexOf(x));
		tempObj[0] = listChiTietHoaDon.indexOf(x) + 1;
		tempObj[1] = tempCTHD.getSanPham().getSanPhamID();
		tempObj[2] = tempCTHD.getSanPham().getTenSanPham();
		tempObj[3] = tempCTHD.getSanPham().getGiaBan();
		tempObj[4] = "";
		tempObj[5] = tempCTHD.getSoLuong();
		tempObj[6] = "";
		tempObj[7] = tempCTHD.getSanPham().getThue();
		tempObj[8] = tempCTHD.tinhTongTien();
		tempObj[9] = "";
		return tempObj;
	}

	public String getTrangThaiHoaDonString() {
		return getTrangThaiHoaDonString(trangThai);
	}

	public String parseTrangThaiHoaDon() {
		return parseTrangThaiHoaDon(trangThai);
	}

	public static String getTrangThaiHoaDonString(String x) {
		if (x.equalsIgnoreCase("DA_XU_LY"))
			return "Đã xử lý";
		if (x.equalsIgnoreCase("CHO_XU_LY"))
			return "Chờ xử lý";
		if (x.equalsIgnoreCase("HUY_BO"))
			return "Huỷ bỏ";
		if (x.equalsIgnoreCase("TRA_HANG"))
			return "Đã trả hàng";
		return "Tất cả";
	}

	public static String parseTrangThaiHoaDon(String x) {
		if (x.equalsIgnoreCase("Đã xử lý"))
			return "DA_XU_LY";
		if (x.equalsIgnoreCase("Chờ xử lý"))
			return "CHO_XU_LY";
		if (x.equalsIgnoreCase("Huỷ Bỏ"))
			return "HUY_BO";
		if (x.equalsIgnoreCase("Đã trả hàng"))
			return "TRA_HANG";
		return "ALL";
	}

	public Object[] getRowTableHoaDon() {
		SimpleDateFormat dtf = new SimpleDateFormat("hh:mm:ss dd/MM/YYYY");

		Object[] obj = { 0, getHoaDonID(), khachHang.getHoTen(), nhanVien.getHoTen(), dtf.format(ngayLapHoaDon),
				getTrangThaiHoaDonString(), getTongTien() };
		return obj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoaDonID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(hoaDonID, other.hoaDonID);
	}

	@Override
	public String toString() {
		return hoaDonID; // Generated from
							// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
	}

}
