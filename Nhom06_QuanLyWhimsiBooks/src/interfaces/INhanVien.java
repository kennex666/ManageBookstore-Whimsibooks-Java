package interfaces;

import java.util.ArrayList;

import entities.NhanVien;

public interface INhanVien  {
	public ArrayList<NhanVien> getAllEmployees();
	public ArrayList<NhanVien> findEmployee(String x);
	public boolean addNhanVien(String x);
	public boolean editNhanVien(String x);
	public boolean deleteNhanVien(String x);
}
