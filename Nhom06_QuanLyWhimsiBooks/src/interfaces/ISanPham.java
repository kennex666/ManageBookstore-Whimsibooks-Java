package interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import entities.HoaDon;
import entities.SanPham;

public interface ISanPham {
	public  ArrayList<SanPham> laySanPhamChoKM();
	public ArrayList<SanPham> getDanhSachSanPham(String query);
	public ArrayList<SanPham> getDanhSachSanPham();
	public ArrayList<SanPham> searchSanPham(String id);
	public boolean addSanPham(SanPham sp);
	public boolean editSanPham(SanPham sp);
	public ArrayList<SanPham> getDanhSachSanPhamSapHet();
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x);
	
}
