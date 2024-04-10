package interfaces;

import java.util.List;

import entities.ChiTietHoaDon;

public interface IChiTietHoaDon {
	public List<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon);
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x);
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietHoaDon> x);
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x);
}