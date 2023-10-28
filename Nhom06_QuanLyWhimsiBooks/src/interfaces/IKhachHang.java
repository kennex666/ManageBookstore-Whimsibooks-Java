package interfaces;

import java.util.ArrayList;

import entities.KhachHang;
import entities.NhanVien;

public interface IKhachHang {
	public ArrayList<KhachHang> getAllKhachHang();
	public ArrayList<NhanVien> findKhachHang(String x);
	public boolean addKhachHang(String x);
	public boolean editKhachHang(String x);
	public boolean deleteKhachHang(String x);
	
}
