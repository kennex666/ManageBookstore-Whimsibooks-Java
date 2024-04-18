package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.KhachHang;
import entities.NhanVien;

public interface IKhachHang extends Remote {
	public List<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) throws RemoteException;

	public List<KhachHang> getAllKhachHang() throws RemoteException;

	public long totalKhachHang() throws RemoteException;

	public boolean addKhachHang(KhachHang kh) throws RemoteException;

	public KhachHang getKhachHangByKhachHangID(String ma) throws RemoteException;

	public boolean editKhachHang(KhachHang kh) throws RemoteException;

	public boolean deleteKhachHang(KhachHang kh) throws RemoteException;

	public String getLayTenTuMa(String x) throws RemoteException;

	public List<NhanVien> findKhachHang(String x) throws RemoteException;

	public long phatSinhMaKhachHang() throws RemoteException;

	String phatSinhMaSoThue(String loaiKhachHang) throws RemoteException;

	public KhachHang getKhachHangTuMaVaSDT(String x) throws RemoteException;

	public boolean checkIfKhachHangExists(String maKH) throws RemoteException;

	public boolean chuyenLoaiKhachHang(String maKhachHang, String loaiKhachHangMoi) throws RemoteException;
}
