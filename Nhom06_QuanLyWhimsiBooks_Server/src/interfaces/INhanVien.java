package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.NhanVien;

public interface INhanVien extends Remote{
	List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh,
			String chucVu) throws RemoteException;

	public List<NhanVien> getAllEmployees() throws RemoteException;

	public int totalNhanVien() throws RemoteException;

	public boolean addNhanVien(NhanVien x) throws RemoteException;

	public boolean editNhanVien(NhanVien x) throws RemoteException;

	public boolean deleteNhanVien(NhanVien x) throws RemoteException;

	public NhanVien getNhanVienByNhanVienID(String x) throws RemoteException;

	public String getTenTuMa(String x) throws RemoteException;

	public boolean isMaNhanVienExists(String x) throws RemoteException;

	public int phatSinhMaNhanVien() throws RemoteException;

	public List<NhanVien> findEmployee(String x) throws RemoteException;

	public NhanVien dangNhapNhanVien(String user, String password) throws RemoteException;

	public String getNhanVienEmailViaUsername(String username) throws RemoteException;
	
	public boolean resetUserPassword(String username, String newPassword) throws RemoteException;

	public  boolean chuyenChucVuNhanVienCu(String maNhanVien) throws RemoteException;
}
