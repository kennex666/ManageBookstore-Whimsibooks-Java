package interfaces;

import java.util.ArrayList;

import entities.ChiTietHoaDon;

public interface IChiTietHoaDon {
	public ArrayList<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon);
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x);
	public boolean addNhieuChiTietCuaMotHoaDon(ArrayList<ChiTietHoaDon> x);
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x);
}