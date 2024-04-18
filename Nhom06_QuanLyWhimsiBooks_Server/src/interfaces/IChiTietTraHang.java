package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.ChiTietHoaDon;
import entities.ChiTietTraHang;

public interface IChiTietTraHang extends Remote{
	public List<ChiTietTraHang> getAllChiTietCuaMotHoaDon(String maHoaDon) throws RemoteException;
	public boolean addMotChiTietCuaHoaDon(ChiTietTraHang x) throws RemoteException;
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietTraHang> x) throws RemoteException;
	public boolean removeMotChiTietCuaHoaDon(ChiTietTraHang x) throws RemoteException;
}