package bus;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.NhanVien;
import interfaces.IChiTietHoaDon;
import interfaces.INhanVien;
import ultilities.EnviromentConfigs;

public class NhanVien_BUS implements INhanVien {
	private INhanVien nv_dao;

	public NhanVien_BUS() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx  = new InitialContext();
			nv_dao = (INhanVien) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/nhanVien");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<NhanVien> findEmployee(String x) {
		// Tìm kiếm theo mã hoặc theo tên.
		try {
			return nv_dao.findEmployee(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public List<NhanVien> getAllEmployees() {

		try {
			return nv_dao.getAllEmployees();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public int totalNhanVien() {
		// TODO Auto-generated method stub
		try {
			return nv_dao.totalNhanVien();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public boolean addNhanVien(NhanVien x) {
		try {
			return nv_dao.addNhanVien(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public boolean editNhanVien(NhanVien x) {
		try {
			return nv_dao.editNhanVien(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public boolean deleteNhanVien(NhanVien x) {
		// TODO Auto-generated method stub
		try {
			return nv_dao.deleteNhanVien(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public String getTenTuMa(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien getNhanVienByNhanVienID(String x) {
		try {
			return nv_dao.getNhanVienByNhanVienID(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public boolean isMaNhanVienExists(String x) {
		try {
			return nv_dao.isMaNhanVienExists(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}

	}

	@Override
	public int phatSinhMaNhanVien() {
		// TODO Auto-generated method stub
		try {
			return nv_dao.phatSinhMaNhanVien();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai,
			String gioiTinh, String chucVu) {
		// TODO Auto-generated method stub
		try {
			return nv_dao.findEmployeeAdvanced(maNhanVien, tenNhanVien, soDienThoai, gioiTinh, chucVu);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public NhanVien dangNhapNhanVien(String user, String password) {
		try {
			return nv_dao.dangNhapNhanVien(user, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}

	}

	@Override
	public String getNhanVienEmailViaUsername(String username) {
		// TODO Auto-generated method stub
		try {
			return nv_dao.getNhanVienEmailViaUsername(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public boolean resetUserPassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		try {
			return nv_dao.resetUserPassword(username, newPassword);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}
  
  @Override
	public boolean chuyenChucVuNhanVienCu(String maNhanVien) {
		// TODO Auto-generated method stub
		try {
			return nv_dao.chuyenChucVuNhanVienCu(maNhanVien);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

}
