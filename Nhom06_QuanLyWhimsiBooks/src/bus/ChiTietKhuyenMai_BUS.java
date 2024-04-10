package bus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietKhuyenMai_DAO;
import dao.KhuyenMai_DAO;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;
import interfaces.IChiTietKhuyenMai;

public class ChiTietKhuyenMai_BUS implements IChiTietKhuyenMai{
	private ChiTietKhuyenMai_DAO chiTietKhuyenMai_DAO;
	
	private KhuyenMai_BUS khuyenMai_BUS;
	private SanPham_BUS sanPham_BUS;
	
	public ChiTietKhuyenMai_BUS() {
		this.chiTietKhuyenMai_DAO = new ChiTietKhuyenMai_DAO();
		khuyenMai_BUS = new KhuyenMai_BUS();
		sanPham_BUS = new SanPham_BUS();
	}
	@Override
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai() {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.getAllChiTietKhuyenMai();
	}
	@Override
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.addSanPhamKhuyenMai(khuyenMai, sanPham);
	}
	@Override
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM) {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.addSDanhSachSPKM(khuyenMai, danhSachSPKM);
	}
	
	public List<SanPham> laySanPhamKMTheoMa(String txt) {
		List<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_BUS.getDanhSachSanPham("Select * from ChiTietKhuyenMai cttkm join SanPham sp on sp.SanPhamID = cttkm.SanPhamID where cttkm.CodeKhuyenMai = '"+txt+"'");
		return list;
	}
	
	public List<KhuyenMai> layKhuyenMaiTheoMa(String txt) {
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		list = khuyenMai_BUS.getKhuyenMaiByID(txt);
		return list;
	}
	
	public List<ChiTietKhuyenMai> layCTTKMTheoMa(String txt) {
		List<ChiTietKhuyenMai> list = new ArrayList<ChiTietKhuyenMai>();
		list = chiTietKhuyenMai_DAO.getChiTietKhuyenMaiTheoMa(txt);
		return list;
	}
	@Override
	public Date getNgayTao(String maKM) {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.getNgayTao(maKM);
	}
	@Override
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai, int masanPham) {
		// TODO Auto-generated method stub
		return chiTietKhuyenMai_DAO.addSanPhamKhuyenMaiKhiUpdate(makhuyenMai, masanPham);
	}
}
