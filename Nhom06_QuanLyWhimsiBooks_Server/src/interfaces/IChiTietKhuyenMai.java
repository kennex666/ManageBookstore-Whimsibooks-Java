package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;

public interface IChiTietKhuyenMai extends Remote{
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai() throws RemoteException;
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM) throws RemoteException;
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) throws RemoteException;
	public Date getNgayTao(String maKM) throws RemoteException;
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham) throws RemoteException;
	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String txt) throws RemoteException;
}
