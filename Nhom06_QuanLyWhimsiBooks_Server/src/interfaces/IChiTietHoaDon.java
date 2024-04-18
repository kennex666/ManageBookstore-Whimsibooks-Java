package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.ChiTietHoaDon;

public interface IChiTietHoaDon extends Remote{
	public List<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon) throws RemoteException;
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x) throws RemoteException;
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietHoaDon> x) throws RemoteException;
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x) throws RemoteException;
}