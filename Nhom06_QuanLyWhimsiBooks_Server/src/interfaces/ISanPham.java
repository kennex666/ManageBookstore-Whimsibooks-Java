package interfaces;

import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Date;

import entities.HoaDon;
import entities.SanPham;
import entities.ThuongHieu;

public interface ISanPham extends Remote {
	public List<SanPham> laySanPhamChoKM() throws RemoteException;

	public List<SanPham> getDanhSachSanPham(String query) throws RemoteException;

	public List<SanPham> getDanhSachSanPham() throws RemoteException;

	public List<SanPham> searchSanPham(String id) throws RemoteException;

	public boolean addSanPham(SanPham sp) throws RemoteException;

	public boolean editTrangThaiSanPham(SanPham sp) throws RemoteException;

	public boolean editSanPham(SanPham sp) throws RemoteException;

	public List<SanPham> getDanhSachSanPhamSapHet() throws RemoteException;

	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) throws RemoteException;

	public List<SanPham> getSPTheoThuongHieu(String maThuongHieu) throws RemoteException;

	public List<ThuongHieu> getThuongHieu() throws RemoteException;

	public int getIdTacGiaByName(String name) throws RemoteException;

	public int getIdTheloaiByName(String name) throws RemoteException;

	public int getIdNhaXuatBanByName(String name) throws RemoteException;

	public String getIdNhaCungCapByName(String name) throws RemoteException;

	public int getIdThuongHieuByName(String name) throws RemoteException;

	public int getIdDanhMucByName(String name) throws RemoteException;

	public String getNameTacGiaByID(int ID) throws RemoteException;

	public String getNameNhaXuatBanByID(int ID) throws RemoteException;

	public String getNameDanhMucByID(int ID) throws RemoteException;

	public String getNameTheLoaiByID(int ID) throws RemoteException;

	public String getNameThuongHieuByID(int ID) throws RemoteException;

	public String getNameNhaCungCapByID(String ID) throws RemoteException;

	public void SapXepTangTheoGia(List<SanPham> list) throws RemoteException;

	public void SapXepGiamTheoGia(List<SanPham> list) throws RemoteException;

	public void SapXepTangTheoSoLuong(List<SanPham> list) throws RemoteException;

}
