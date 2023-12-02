package bus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.KhuyenMai_DAO;
import entities.KhuyenMai;
import entities.SanPham;
import interfaces.IKhuyenMai;

public class KhuyenMai_BUS implements IKhuyenMai{
	private KhuyenMai_DAO khuyenMai_DAO;
	private SanPham_BUS sanPham_BUS;
	
	public KhuyenMai_BUS() {
		this.khuyenMai_DAO = new KhuyenMai_DAO();
		this.sanPham_BUS = new SanPham_BUS();
	}
	
	public ArrayList<SanPham> laySanPhamTheoMa(String txt) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_BUS.getDanhSachSanPham("SELECT * FROM SanPham WHERE SanPhamID LIKE '%"+txt+"%'");
		return list;
	}
	
	public ArrayList<SanPham> laySanPhamTheoTen(String txt) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_BUS.getDanhSachSanPham("SELECT * FROM SanPham WHERE SanPhamID LIKE '%"+txt+"%'");
		return list;
	}
	
    public ArrayList<SanPham> laySanPhamDuocChon(JTable table) {
    	ArrayList<SanPham> dsSanPhamDuocChon = new ArrayList<SanPham>();
    	int rowCount = table.getRowCount();
    	if(rowCount != 0) {
    		for(int i = 0; i < rowCount; i++) {
    			boolean isSelected = (boolean) table.getModel().getValueAt(i, 0);
    			String maSanPham = table.getModel().getValueAt(i, 1).toString();
    			String tenSanPham = table.getModel().getValueAt(i, 2).toString();
    			if (isSelected) {
    			    SanPham sanPham = new SanPham(Integer.valueOf(maSanPham), tenSanPham);
    			    dsSanPhamDuocChon.add(sanPham);
    			}
    		}
    		return dsSanPhamDuocChon;
    	}
    	return null;
    }

	@Override
	public ArrayList<KhuyenMai> getAllKhuyenMai() {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getAllKhuyenMai();
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getKhuyenMaiByID(maKhuyenMai);
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getKhuyenMaiFollowDay(startDay, expriedDay);
	}

	@Override
	public boolean addKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.addKhuyenMai(khuyenMai);
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.editKhuyenMai(khuyenMai);
	}

	@Override
	public int layMaNCCCuoiCung() {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.layMaNCCCuoiCung();
	}

	
	public ArrayList<KhuyenMai> TimKiemTheoLoai(String hinhThuc) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		String queryTong = "SELECT * FROM KhuyenMai";
		String queryPhanTram = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Percentage'";
		String queryGiaTri = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Fixed'";
		if(hinhThuc.equals("ALL")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryTong);
		}
		if(hinhThuc.equals("Percentage")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		}
		if(hinhThuc.equals("Fixed")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		}
		return list = null;
	}
	
	public ArrayList<KhuyenMai> TimKiemTheoDieuKien(String ma,String loai) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		String queryTong = "SELECT * FROM KhuyenMai";
		String queryma = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+ma+"%'";
		String querymagt = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+ma+"%' and LoaiGiamGia = 'Fixed'";
		String querymapt = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+ma+"%' and LoaiGiamGia = 'Percentage'";
		String queryPhanTram = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Percentage'";
		String queryGiaTri = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Fixed'";
		if(ma.length() > 0) {
			switch (loai) {
		    case "Tất cả":
		        list = TimKiemKhuyenMaiTheoDieuKien(queryma);
		        break;
		    case "Giá trị":
		        list = TimKiemKhuyenMaiTheoDieuKien(querymagt);
		        break;
		    case "Phần trăm":
		        list = TimKiemKhuyenMaiTheoDieuKien(querymapt);
		        break;
			}
		}
		else if(ma.length() <= 0) {
			switch (loai) {
		    case "Tất cả":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryTong);
		        break;
		    case "Giá trị":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		        break;
		    case "Phần trăm":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryGiaTri);
		        break;
			}
		}
		return list;
	}
        
        @Override
        public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai){
            return khuyenMai_DAO.getKhuyenMaiByCodeKMForSeller(maKhuyenMai);
        }
    
    @Override
    public KhuyenMai getKhuyenMaiViaSanPhamAutoApply(int maSanPham) {
    	// TODO Auto-generated method stub
    	return khuyenMai_DAO.getKhuyenMaiViaSanPhamAutoApply(maSanPham);
    }
	
	@Override
	public ArrayList<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query) {
		return khuyenMai_DAO.TimKiemKhuyenMaiTheoDieuKien(query);
	}

}
