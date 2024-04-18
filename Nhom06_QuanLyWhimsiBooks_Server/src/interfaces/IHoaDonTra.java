package interfaces;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;

import entities.HoaDon;
import entities.HoaDonTra;

public interface IHoaDonTra extends Remote {
	public List<HoaDonTra> getDanhSachHoaDon() throws RemoteException;

	public boolean createHoaDon(HoaDonTra x) throws RemoteException;

	public List<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) throws RemoteException;

	public List<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params) throws RemoteException;

	public HoaDonTra getHoaDonByID(HoaDonTra x) throws RemoteException;

	public int getSoHoaDonTrongNgay() throws RemoteException;

	public boolean updateHoaDon(HoaDonTra x) throws RemoteException;

	public boolean cancelHoaDon(HoaDonTra x) throws RemoteException;

	public HashMap<String, Object[]> getObjectThongKeXuHuong(Date start, Date end) throws RemoteException;
}
