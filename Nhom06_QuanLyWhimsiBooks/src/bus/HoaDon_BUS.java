package bus;

import java.util.ArrayList;
import java.util.Date;

import dao.HoaDon_DAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.SanPham;
import interfaces.IHoaDon;

public class HoaDon_BUS implements IHoaDon{
	private HoaDon_DAO hoaDon_DAO;
	
	
	public HoaDon_BUS() {
		super();
		hoaDon_DAO = new HoaDon_DAO();
	}

	@Override
	public boolean createHoaDon(HoaDon x) {
		// TODO Auto-generated method stub
            if (x.getHoaDonID() != null){
                if (!x.getHoaDonID().isBlank()){
                    for (ChiTietHoaDon y : x.getListChiTietHoaDon())
                    y.setHoaDon(x);
                    return hoaDon_DAO.updateHoaDon(x);
                }
            }
            
            String hdID = generateHoaDonID();
            x.setHoaDonID(hdID);
            for (ChiTietHoaDon y : x.getListChiTietHoaDon())
		y.setHoaDon(x);
            return hoaDon_DAO.createHoaDon(x);
	}

        @Override
        public boolean updateHoaDon(HoaDon x) {
            return hoaDon_DAO.updateHoaDon(x);
        }

        @Override
        public boolean cancelHoaDon(HoaDon x) {
            return hoaDon_DAO.cancelHoaDon(x);
        }
	
        
        
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDon() {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDon();
	}
	
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDonTheoThoiGian(batDau, ketThuc);
	}
	
	@Override
	public ArrayList<HoaDon> getDanhSachHoaDonNangCao(Object[] params) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getDanhSachHoaDonNangCao(params);
	}
	
	@Override
	public int getSoHoaDonTrongNgay() {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getSoHoaDonTrongNgay();
	}
	
@	Override
	public HoaDon getHoaDonByID(HoaDon x) {
		// TODO Auto-generated method stub
		return hoaDon_DAO.getHoaDonByID(x);
	}

	public String generateHoaDonID() {
		Date now = new Date();
		return String.format(
				"HD%02d%02d%02d%03d", 
				now.getDate(), 
				now.getMonth()+1, 
				((now.getYear()/10)%10)*10 + now.getYear()%10,
				getSoHoaDonTrongNgay() + 1
		);
	}
	
	
}
