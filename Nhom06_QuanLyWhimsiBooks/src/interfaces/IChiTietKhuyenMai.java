package interfaces;

import java.util.ArrayList;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;

public interface IChiTietKhuyenMai {
	public ArrayList<ChiTietKhuyenMai> getAllChiTietKhuyenMai();
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham);
}
