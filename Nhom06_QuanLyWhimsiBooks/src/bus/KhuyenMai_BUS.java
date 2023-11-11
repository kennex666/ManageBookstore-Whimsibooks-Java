package bus;

import java.sql.Date;
import java.util.ArrayList;

import dao.KhuyenMai_DAO;
import entities.KhuyenMai;
import interfaces.IKhuyenMai;

public class KhuyenMai_BUS implements IKhuyenMai{
	private KhuyenMai_DAO khuyenMai_DAO;

	
	public KhuyenMai_BUS() {
		this.khuyenMai_DAO = new KhuyenMai_DAO();
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
		return false;
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		return false;
	}

}
