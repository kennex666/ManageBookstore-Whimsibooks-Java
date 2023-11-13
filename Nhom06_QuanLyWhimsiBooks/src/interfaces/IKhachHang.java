package interfaces;

import java.util.ArrayList;

import entities.KhachHang;
import entities.NhanVien;

public interface IKhachHang {
	public ArrayList<NhanVien> findKhachHang(String x);
	public ArrayList<KhachHang> getAllKhachHang();
	public int totalKhachHang();
	public boolean addKhachHang(KhachHang kh);
	public boolean editKhachHang(KhachHang kh);
	public boolean deleteKhachHang(KhachHang kh);
	public String getLayTenTuMa(String x);
        public KhachHang getKhachHangTuMaVaSDT(String x);
}
