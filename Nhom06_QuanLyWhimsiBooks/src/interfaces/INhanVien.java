package interfaces;

import java.util.ArrayList;

import entities.NhanVien;

public interface INhanVien  {
	public ArrayList<NhanVien> findEmployee(String x);
	public ArrayList<NhanVien> getAllEmployees();
	public int totalNhanVien ();
	public boolean addNhanVien(NhanVien x);
	public boolean editNhanVien(NhanVien x);
	public boolean deleteNhanVien(NhanVien x);
	public NhanVien getNhanVienByNhanVienID(String x);
	public String getTenTuMa(String x);
	public boolean isMaNhanVienExists(String x);
}
