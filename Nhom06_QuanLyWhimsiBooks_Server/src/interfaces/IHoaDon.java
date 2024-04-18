package interfaces;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import entities.HoaDon;

public interface IHoaDon extends Remote{
	public List<HoaDon> getDanhSachHoaDon() throws RemoteException;
	public boolean createHoaDon(HoaDon x) throws RemoteException;
	public List<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) throws RemoteException;
	public List<HoaDon> getDanhSachHoaDonNangCao(Object[] params) throws RemoteException;	
	public HoaDon getHoaDonByID(HoaDon x) throws RemoteException;
	public int getSoHoaDonTrongNgay() throws RemoteException;
    public boolean updateHoaDon(HoaDon x) throws RemoteException;
    public boolean cancelHoaDon(HoaDon x) throws RemoteException;
	public List<Object[]> getDanhSachHoaDonThongKeXuHuong(Date timeStart, Date timeEnd) throws RemoteException;
	
}
