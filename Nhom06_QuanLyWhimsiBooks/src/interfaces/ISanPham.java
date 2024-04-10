package interfaces;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Date;

import entities.HoaDon;
import entities.SanPham;
import entities.ThuongHieu;

public interface ISanPham {
	public List<SanPham> laySanPhamChoKM();
	public List<SanPham> getDanhSachSanPham(String query);
	public List<SanPham> getDanhSachSanPham();
	public List<SanPham> searchSanPham(String id);
	public boolean addSanPham(SanPham sp);
        public boolean editTrangThaiSanPham(SanPham sp);
	public boolean editSanPham(SanPham sp);
	public List<SanPham> getDanhSachSanPhamSapHet();
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x);

	public List<SanPham> getSPTheoThuongHieu(String maThuongHieu);
	public List<ThuongHieu> getThuongHieu();

        public int getIdTacGiaByName(String name);
        public int getIdTheloaiByName(String name);
        public int getIdNhaXuatBanByName(String name);
        public String getIdNhaCungCapByName(String name);
        public int getIdThuongHieuByName(String name);
        public int getIdDanhMucByName(String name);
        
        public String getNameTacGiaByID(int ID);
        public String getNameNhaXuatBanByID(int ID);
        public String getNameDanhMucByID(int ID);
        public String getNameTheLoaiByID(int ID);
        public String getNameThuongHieuByID(int ID);
        public String getNameNhaCungCapByID(String ID);
        public void SapXepTangTheoGia(List<SanPham> list);
        public void SapXepGiamTheoGia(List<SanPham> list);
        public void SapXepTangTheoSoLuong(List<SanPham> list);
	
}
