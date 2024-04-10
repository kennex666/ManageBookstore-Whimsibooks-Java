package interfaces;

import java.sql.Date;
import java.util.List;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;

public interface IChiTietKhuyenMai {
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai();
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM);
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham);
	public Date getNgayTao(String maKM);
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham);
}
