package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class HoaDonTra {
	@Id
    private String hoaDonID;
    private Date ngayTraHoaDon;
    private String trangThai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khachHangId")
    private KhachHang khachHang;
    private double tongHoan;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhanVienId")
	private NhanVien nhanVien;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hoaDon")
    private ArrayList<ChiTietTraHang> listChiTietHoaDon;

    public HoaDonTra(String hoaDonID, Date ngayTraHoaDon, String trangThai, KhachHang khachHang, double tongHoan,
			NhanVien nhanVien, ArrayList<ChiTietTraHang> listChiTietHoaDon) {
		super();
		this.hoaDonID = hoaDonID;
		this.ngayTraHoaDon = ngayTraHoaDon;
		this.trangThai = trangThai;
		this.khachHang = khachHang;
		this.tongHoan = tongHoan;
		this.nhanVien = nhanVien;
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public HoaDonTra() {
    	listChiTietHoaDon = new ArrayList<ChiTietTraHang>();
    }

    public HoaDonTra(String hoaDonID, Date ngayTraHoaDon, String trangThai) {
        setHoaDonID(hoaDonID);
        setNgayTraHoaDon(ngayTraHoaDon);
        setTrangThai(trangThai);
    	listChiTietHoaDon = new ArrayList<ChiTietTraHang>();
    }

    public HoaDonTra(String hoaDonID) {
       this.hoaDonID = hoaDonID;
        listChiTietHoaDon = new ArrayList<ChiTietTraHang>();
    }

    

    public String getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(String hoaDonID) {
        // Phát sinh tự động theo quy tắc
        if (hoaDonID == null || !hoaDonID.matches("HD\\d+")) {
            throw new IllegalArgumentException("Hóa đơn ID không hợp lệ");
        }
        this.hoaDonID = hoaDonID;
    }

    
    public HoaDonTra(String hoaDonID, Date ngayTraHoaDon, String trangThai, KhachHang khachHang, double tongHoan) {
		super();
		this.hoaDonID = hoaDonID;
		this.ngayTraHoaDon = ngayTraHoaDon;
		this.trangThai = trangThai;
		this.khachHang = khachHang;
		this.tongHoan = tongHoan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public void setTongHoan(double tongHoan) {
		this.tongHoan = tongHoan;
	}

	public Date getNgayTraHoaDon() {
        return ngayTraHoaDon;
    }

    public void setNgayTraHoaDon(Date ngayTraHoaDon) {
        this.ngayTraHoaDon = ngayTraHoaDon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public int addChiTietHoaDon(ChiTietTraHang x) {
		if (listChiTietHoaDon.contains(x)){
			int temp = listChiTietHoaDon.indexOf(x);
                    listChiTietHoaDon.get(temp)
                    .setSoLuong(
                            listChiTietHoaDon.get(temp).getSoLuong() + x.getSoLuong()
                    );
                    return temp;
	   	}
		
		listChiTietHoaDon.add(x);
		return -1;
	   	
	}
        
    public void editSoLuong(ChiTietTraHang x){
    	if (listChiTietHoaDon.contains(x)){
        	 listChiTietHoaDon.get(listChiTietHoaDon.indexOf(x)).setSoLuong(x.getSoLuong() + 1);
    	}else {
    		addChiTietHoaDon(x);
    	}
    }
	
	public void removeChiTietHoaDon(ChiTietTraHang x) {
		listChiTietHoaDon.remove(x);
	}
        
        public void removeAllChiTietHoaDon() {
            while (listChiTietHoaDon.size() > 0){
                listChiTietHoaDon.remove(0);
            }
	}

	public ArrayList<ChiTietTraHang> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(ArrayList<ChiTietTraHang> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public ArrayList<Object[]> tableChiTietHoaDon() {
		ArrayList<Object[]> lines = new ArrayList<Object[]>();
		
		for (int i = 0 ; i < listChiTietHoaDon.size(); i++) {
			ChiTietTraHang tempCTHD = listChiTietHoaDon.get(i);
			lines.add(tableRowChiTietHoaDon(tempCTHD));
			
		}
		return lines;
	}
	
	public Object[] tableRowChiTietHoaDon(ChiTietTraHang x) {
			Object[] tempObj = new Object[10];
			ChiTietTraHang tempCTHD = listChiTietHoaDon.get(listChiTietHoaDon.indexOf(x));
			tempObj[0] = listChiTietHoaDon.indexOf(x) + 1; 
			tempObj[1] = tempCTHD.getSanPham().getTenSanPham();
			tempObj[2] = tempCTHD.getSoLuong();
			tempObj[3] = "Không có lý do";
		return tempObj;
	}
	
	public String getTrangThaiHoaDonString() {
		if (trangThai.equalsIgnoreCase("DA_XU_LY"))
			return "Đã xử lý";
		if (trangThai.equalsIgnoreCase("CHO_XU_LY"))
			return "Chờ xử lý";
		if (trangThai.equalsIgnoreCase("HUY_BO"))
			return "Huỷ bỏ";
		return "Tất cả";
	}
	
	public String parseTrangThaiHoaDon() {
		if (trangThai.equalsIgnoreCase("Đã xử lý"))
			return "DA_XU_LY";
		if (trangThai.equalsIgnoreCase("Chờ xử lý"))
			return "CHO_XU_LY";
		if (trangThai.equalsIgnoreCase("Huỷ Bỏ"))
                        return "HUY_BO";
                return "ALL";
	}
        
        public static String getTrangThaiHoaDonString(String x) {
		if (x.equalsIgnoreCase("DA_XU_LY"))
			return "Đã xử lý";
		if (x.equalsIgnoreCase("CHO_XU_LY"))
			return "Chờ xử lý";
		if (x.equalsIgnoreCase("HUY_BO"))
			return "Huỷ bỏ";
		return "Tất cả";
	}
	
	public static String parseTrangThaiHoaDon(String x) {
		if (x.equalsIgnoreCase("Đã xử lý"))
			return "DA_XU_LY";
		if (x.equalsIgnoreCase("Chờ xử lý"))
			return "CHO_XU_LY";
		if (x.equalsIgnoreCase("Huỷ Bỏ"))
                        return "HUY_BO";
                return "ALL";
	}
	
	public Object[] getRowTableHoaDon() {
		SimpleDateFormat dtf = new SimpleDateFormat("hh:mm:ss dd/MM/YYYY");
		
		Object[] obj = {0, getHoaDonID(), 
				khachHang.getHoTen(), nhanVien.getHoTen(), 
				dtf.format(ngayTraHoaDon),
				getTrangThaiHoaDonString(),
				getTongHoan()
		};
		return obj;
	}
    
	public double getTongHoan() {
		return tongHoan > 0 ? tongHoan : tinhTongHoan();
	}
	
	public double tinhTongHoan() {
		tongHoan = 0;
		for (ChiTietTraHang x : listChiTietHoaDon)
			tongHoan += x.tinhTongTien();
		return tongHoan;
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
		HoaDonTra other = (HoaDonTra) obj;
		return Objects.equals(hoaDonID, other.hoaDonID);
	}

	// Phương thức toString
    @Override
    public String toString() {
        return hoaDonID;
    }
}

