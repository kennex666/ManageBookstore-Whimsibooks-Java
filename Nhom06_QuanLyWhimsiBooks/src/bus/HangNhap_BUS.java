package bus;

import entities.HangNhap;
import interfaces.IHangNhap;

public class HangNhap_BUS implements IHangNhap{
	private HangNhap_BUS hn_Dao;

	public HangNhap_BUS(HangNhap_BUS hn_Dao) {
		this.hn_Dao = hn_Dao;
	}
	
	@Override
	public HangNhap findHangNhap(String hangNhapID) {
		return hn_Dao.findHangNhap(hangNhapID);
	}

}
