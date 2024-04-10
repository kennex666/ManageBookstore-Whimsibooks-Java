package interfaces;

import java.util.List;

import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;

public interface IChiTietTraHang {
	public List<ChiTietTraHang> getAllChiTietCuaMotHoaDon(String maHoaDon);
	public boolean addMotChiTietCuaHoaDon(ChiTietTraHang x);
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietTraHang> x);
	public boolean removeMotChiTietCuaHoaDon(ChiTietTraHang x);
}