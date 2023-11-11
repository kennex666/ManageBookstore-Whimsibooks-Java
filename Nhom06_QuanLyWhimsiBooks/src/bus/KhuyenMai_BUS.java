package bus;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JTable;

import dao.KhuyenMai_DAO;
import entities.KhuyenMai;
import entities.SanPham;
import interfaces.IKhuyenMai;

public class KhuyenMai_BUS implements IKhuyenMai{
	private KhuyenMai_DAO khuyenMai_DAO;

	
	public KhuyenMai_BUS() {
		this.khuyenMai_DAO = new KhuyenMai_DAO();
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

}
