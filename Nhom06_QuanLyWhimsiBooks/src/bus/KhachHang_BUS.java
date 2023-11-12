package bus;

import java.util.ArrayList;

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entities.KhachHang;
import entities.NhanVien;
import interfaces.IKhachHang;

public class KhachHang_BUS implements IKhachHang {
	KhachHang_DAO kh_dao = new KhachHang_DAO();
	@Override
	public ArrayList<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) {
		// TODO Auto-generated method stub
		return  kh_dao.findKhachHangAdvanced(maKhachHang, tenKhachHang, soDienThoai, gioiTinh, loaiKhachHang);
	}

	@Override
	public ArrayList<KhachHang> getAllKhachHang() {
		
		return kh_dao.getAllKhachHang();
	}

	@Override
	public int totalKhachHang() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return kh_dao.addKhachHang(kh);
	}

	@Override
	public boolean editKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLayTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhanVien> findKhachHang(String x) {
		// TODO Auto-generated method stub
		return null;
	}
}
