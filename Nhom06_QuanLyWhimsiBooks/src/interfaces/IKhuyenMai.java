package interfaces;

import java.sql.Date;
import java.util.List;

import entities.ChiTietKhuyenMai;
import entities.HoaDon;
import entities.KhuyenMai;
import entities.SanPham;

public interface IKhuyenMai {
	public int layMaNCCCuoiCung();
	public List<KhuyenMai> getAllKhuyenMai();
	public List<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai);
	public boolean addKhuyenMai(KhuyenMai khuyenMai);
	public boolean editKhuyenMai(KhuyenMai khuyenMai);
	public List<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query);
	public List<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay);
    public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai);
    public KhuyenMai getKhuyenMaiViaSanPhamAutoApply(int maSanPham);
    public List<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM);
    public List<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params);
    public List<KhuyenMai> getKhuyenMaiByName(String name);
    public boolean deleteKhuyenMai(String codeKhuyenMai);
    public int getSoLuongChuaSD(Object[] params);
    public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham);
    public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM);
	public boolean xoaSanPhamKhuyenMai(String makhuyenMai);
	public List<KhuyenMai> getRecentKhuyenMai(int limit);
	public List<KhuyenMai> getKhuyenMaiTheoTen1(String tenSK);
	public List<KhuyenMai> getKhuyenMaiTheoTen(String tenSK);
	public List<SanPham> laySanPhamTheoMa(String txt);
	public List<SanPham> laySanPhamTheoTen(String txt);
	public List<KhuyenMai> TimKiemTheoDieuKien(String ma, String loai);
	public List<KhuyenMai> TimKiemTheoLoai(String hinhThuc);
}
	