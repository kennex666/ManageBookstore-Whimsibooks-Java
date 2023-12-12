package interfaces;

import java.sql.Date;
import java.util.ArrayList;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;

public interface IChiTietKhuyenMai {
	public ArrayList<ChiTietKhuyenMai> getAllChiTietKhuyenMai();
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, ArrayList<SanPham> danhSachSPKM);
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham);
	public Date getNgayTao(String maKM);
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham);
}
