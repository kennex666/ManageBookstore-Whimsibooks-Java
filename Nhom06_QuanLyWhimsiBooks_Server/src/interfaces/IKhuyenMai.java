package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import entities.ChiTietKhuyenMai;
import entities.HoaDon;
import entities.KhuyenMai;
import entities.SanPham;

public interface IKhuyenMai extends Remote {
	public long layMaNCCCuoiCung() throws RemoteException;

	public List<KhuyenMai> getAllKhuyenMai() throws RemoteException;

	public List<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) throws RemoteException;

	public boolean addKhuyenMai(KhuyenMai khuyenMai) throws RemoteException;

	public boolean editKhuyenMai(KhuyenMai khuyenMai) throws RemoteException;

	public List<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query) throws RemoteException;

	public List<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) throws RemoteException;

	public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai) throws RemoteException;

	public KhuyenMai getKhuyenMaiViaSanPhamAutoApply(int maSanPham) throws RemoteException;

	public List<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM) throws RemoteException;

	public List<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params) throws ParseException, RemoteException;

	public List<KhuyenMai> getKhuyenMaiByName(String name) throws RemoteException;

	public boolean deleteKhuyenMai(String codeKhuyenMai) throws RemoteException;

	public int getSoLuongChuaSD(Object[] params) throws RemoteException;

	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai, int masanPham) throws RemoteException;

	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM) throws RemoteException;

	public boolean xoaSanPhamKhuyenMai(String makhuyenMai) throws RemoteException;

	public List<KhuyenMai> getRecentKhuyenMai(int limit) throws RemoteException;

	public List<KhuyenMai> getKhuyenMaiTheoTen1(String tenSK) throws RemoteException;

	public List<KhuyenMai> getKhuyenMaiTheoTen(String tenSK) throws RemoteException;

	public List<SanPham> laySanPhamTheoMa(String txt) throws RemoteException;

	public List<SanPham> laySanPhamTheoTen(String txt) throws RemoteException;

	public List<KhuyenMai> TimKiemTheoDieuKien(String ma, String loai) throws RemoteException;

	public List<KhuyenMai> TimKiemTheoLoai(String hinhThuc) throws RemoteException;
}
