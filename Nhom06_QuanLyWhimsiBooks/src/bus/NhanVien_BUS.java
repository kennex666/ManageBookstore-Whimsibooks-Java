package bus;

import java.lang.reflect.Array;
import java.util.ArrayList;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entities.NhanVien;
import interfaces.INhanVien;

public class NhanVien_BUS implements INhanVien {
	private NhanVien_DAO nv_dao ;

	public NhanVien_BUS() {
		// TODO Auto-generated constructor stub
		nv_dao = new NhanVien_DAO();
	}
	
	@Override
	public ArrayList<NhanVien> findEmployee(String x) {
		// Tìm kiếm theo mã hoặc theo tên.
		return nv_dao.findEmployee(x);
	}

	@Override
	public ArrayList<NhanVien> getAllEmployees() {

		return nv_dao.getAllEmployees();
	}

	@Override
	public int totalNhanVien() {
		// TODO Auto-generated method stub
		return nv_dao.totalNhanVien();

	}

	@Override
	public boolean addNhanVien(NhanVien x) {
		return nv_dao.addNhanVien(x);
	}

	@Override
	public boolean editNhanVien(NhanVien x) {
		return nv_dao.editNhanVien(x);
	}

	@Override
	public boolean deleteNhanVien(NhanVien x) {
		// TODO Auto-generated method stub
		return nv_dao.deleteNhanVien(x);
	}

	@Override
	public String getTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien getNhanVienByNhanVienID(String x) {
		return nv_dao.getNhanVienByNhanVienID(x);
	}

	@Override
	public boolean isMaNhanVienExists(String x) {
		return nv_dao.isMaNhanVienExists(x);

	}

	@Override
	public int phatSinhMaNhanVien() {
		// TODO Auto-generated method stub
		return nv_dao.phatSinhMaNhanVien();
	}

	@Override
	public ArrayList<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh,
			String chucVu) {
		// TODO Auto-generated method stub
		return nv_dao.findEmployeeAdvanced(maNhanVien, tenNhanVien, soDienThoai, gioiTinh, chucVu);
	}
        
        @Override
        public NhanVien dangNhapNhanVien(String user, String password){
            return nv_dao.dangNhapNhanVien(user, password);
            
        }

	

}
