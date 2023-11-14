package interfaces;

import java.util.ArrayList;

import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;

public interface IChiTietTraHang {
	public ArrayList<ChiTietTraHang> getAllChiTietCuaMotHoaDon(String maHoaDon);
	public boolean addMotChiTietCuaHoaDon(ChiTietTraHang x);
	public boolean addNhieuChiTietCuaMotHoaDon(ArrayList<ChiTietTraHang> x);
	public boolean removeMotChiTietCuaHoaDon(ChiTietTraHang x);
}