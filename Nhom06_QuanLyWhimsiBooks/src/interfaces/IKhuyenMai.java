package interfaces;

import java.sql.Date;
import java.util.ArrayList;

import entities.ChiTietKhuyenMai;
import entities.HoaDon;
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
    public ArrayList<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM);
    public ArrayList<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params);
    public ArrayList<KhuyenMai> getKhuyenMaiByName(String name);
    public boolean deleteKhuyenMai(String codeKhuyenMai);
    public int getSoLuongChuaSD(Object[] params);
    public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham);
    public ArrayList<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM);
	public boolean xoaSanPhamKhuyenMai(String makhuyenMai);
	public ArrayList<KhuyenMai> getRecentKhuyenMai(int limit);
}
	