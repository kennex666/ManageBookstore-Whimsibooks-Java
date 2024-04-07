package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class HoaDon {
	@Id
	private String hoaDonID;
	private Date ngayLapHoaDon;
	private String trangThai; // 3 state: CHO_XU_LY, DA_XU_LY, HUY_BO
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "hoaDon")
	private ArrayList<ChiTietHoaDon> listChiTietHoaDon;
	private double tongTien, thue, giaKhuyenMai;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "nhanVienId")
	private NhanVien nhanVien;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "codeKhuyenMai")
	private KhuyenMai khuyenMai;
	
	
	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, ArrayList<ChiTietHoaDon> listChiTietHoaDon,
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
	}
	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, ArrayList<ChiTietHoaDon> listChiTietHoaDon,
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
	
	public HoaDon(String hoaDonID, Date ngayLapHoaDon, String trangThai, ArrayList<ChiTietHoaDon> listChiTietHoaDon,
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
	
	public double tinhTongThue () {
		thue = 0;
		for (ChiTietHoaDon x : listChiTietHoaDon)
			thue += (x.getSanPham().getGiaBan() * x.getSoLuong()) * x.getSanPham().getThue();
		return thue;
	}
	
	public double tinhThanhTien() {
		return tinhTongTien() - getGiaKhuyenMai();
	}
        
	public int addChiTietHoaDon(ChiTietHoaDon x) {
		if (listChiTietHoaDon.contains(x)){
			int temp = listChiTietHoaDon.indexOf(x);
       	 	listChiTietHoaDon.get(temp)
       	 	.setSoLuong(
       	 		listChiTietHoaDon.get(temp).getSoLuong() + 1
       	 	);
       	 	return temp;
	   	}
		
		listChiTietHoaDon.add(x);
		return -1;
	   	
	}
        
    public void editSoLuong(ChiTietHoaDon x){
    	if (listChiTietHoaDon.contains(x)){
        	 listChiTietHoaDon.get(listChiTietHoaDon.indexOf(x)).setSoLuong(x.getSoLuong() + 1);
    	}else {
    		addChiTietHoaDon(x);
    	}
    }
	
	public void removeChiTietHoaDon(ChiTietHoaDon x) {
		listChiTietHoaDon.remove(x);
	}
        
        public void removeAllChiTietHoaDon() {
            while (listChiTietHoaDon.size() > 0){
                listChiTietHoaDon.remove(0);
            }
	}

	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public ArrayList<Object[]> tableChiTietHoaDon() {
		ArrayList<Object[]> lines = new ArrayList<Object[]>();
		
		for (int i = 0 ; i < listChiTietHoaDon.size(); i++) {
			ChiTietHoaDon tempCTHD = listChiTietHoaDon.get(i);
			lines.add(tableRowChiTietHoaDon(tempCTHD));
			
		}
		return lines;
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
		
		Object[] obj = {0, getHoaDonID(), 
				khachHang.getHoTen(), nhanVien.getHoTen(), 
				dtf.format(ngayLapHoaDon),
				getTrangThaiHoaDonString(),
				getTongTien()
		};
		return obj;
	}
	
    @Override
    public String toString() {
        return hoaDonID; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
	
	
	
}
