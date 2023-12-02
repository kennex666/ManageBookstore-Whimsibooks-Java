package interfaces;

import java.sql.Date;
import java.util.ArrayList;

import entities.KhuyenMai;
import entities.SanPham;

public interface IKhuyenMai {
	public int layMaNCCCuoiCung();
	public ArrayList<KhuyenMai> getAllKhuyenMai();
	public ArrayList<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai);
	public boolean addKhuyenMai(KhuyenMai khuyenMai);
	public boolean editKhuyenMai(KhuyenMai khuyenMai);
	public ArrayList<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query);
	public ArrayList<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay);
    public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai);
    public KhuyenMai getKhuyenMaiViaSanPhamAutoApply(int maSanPham);
}
	