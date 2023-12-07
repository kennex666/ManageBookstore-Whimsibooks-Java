package interfaces;

import java.util.ArrayList;

import entities.NhanVien;

public interface INhanVien {
	ArrayList<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh,
			String chucVu);

	public ArrayList<NhanVien> getAllEmployees();

	public int totalNhanVien();

	public boolean addNhanVien(NhanVien x);

	public boolean editNhanVien(NhanVien x);

	public boolean deleteNhanVien(NhanVien x);

	public NhanVien getNhanVienByNhanVienID(String x);

	public String getTenTuMa(String x);

	public boolean isMaNhanVienExists(String x);

	public int phatSinhMaNhanVien();

	public ArrayList<NhanVien> findEmployee(String x);

	public NhanVien dangNhapNhanVien(String user, String password);

	public  boolean chuyenChucVuNhanVienCu(String maNhanVien);
}
