package interfaces;

import java.util.List;

import entities.NhanVien;

public interface INhanVien {
	List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh,
			String chucVu);

	public List<NhanVien> getAllEmployees();

	public int totalNhanVien();

	public boolean addNhanVien(NhanVien x);

	public boolean editNhanVien(NhanVien x);

	public boolean deleteNhanVien(NhanVien x);

	public NhanVien getNhanVienByNhanVienID(String x);

	public String getTenTuMa(String x);

	public boolean isMaNhanVienExists(String x);

	public int phatSinhMaNhanVien();

	public List<NhanVien> findEmployee(String x);

	public NhanVien dangNhapNhanVien(String user, String password);

	public String getNhanVienEmailViaUsername(String username);
	
	public boolean resetUserPassword(String username, String newPassword);

	public  boolean chuyenChucVuNhanVienCu(String maNhanVien);
}
