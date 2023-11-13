package dao;

import java.util.ArrayList;

import entities.KhachHang;
import entities.NhanVien;
import interfaces.IKhachHang;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import utilities.QueryBuilder;

public class KhachHang_DAO implements IKhachHang {
	@Override
	public ArrayList<NhanVien> findKhachHang(String x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<KhachHang> getAllKhachHang() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int totalKhachHang() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean addKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		return false;
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
        public KhachHang getKhachHangTuMaVaSDT(String x) {
            KhachHang khachHang = null;
            try {
                String query = "SELECT * FROM KhachHang ?";
                QueryBuilder queryBuilder = new QueryBuilder(query);
                queryBuilder.addParameter(
                        QueryBuilder.Enum_DataType.STRING, 
                        "KhachHangID", 
                        "=", 
                        x);
                queryBuilder.addParameter(
                        QueryBuilder.Enum_DataType.STRING, 
                        "SoDienThoai", 
                        "=", 
                        x);
                ResultSet rs = queryBuilder.setParamsForPrepairedStament(connectDB.ConnectDB.getConnection(), "OR").executeQuery();
                if (rs.next()){
                    khachHang = new KhachHang();
                    String maKH = rs.getString("KhachHangID");
                    String hoTen = rs.getString("HoTen");
                    String soDienThoai = rs.getString("soDienThoai");
                    java.sql.Date ngaySinhTemp =  rs.getDate("NgaySinh");
                    LocalDate ngaySinh = null;
                    if (ngaySinhTemp != null)
                        ngaySinh = ngaySinhTemp.toLocalDate();
                    String gt = rs.getString("GioiTinh");
                    String email = rs.getString("Email");
                    String maSoThue = rs.getString("MaSoThue");
                    String diaChi = rs.getString("DiaChi");
                    String loaiKhachHang = rs.getString("LoaiKhachHang");
                    khachHang = new KhachHang(maKH, hoTen, soDienThoai, ngaySinh, gt, email, maSoThue, diaChi, loaiKhachHang);
                }
                return khachHang;
            } catch (Exception e) {
                return null;
            }
            
        }
        
	
        
}
