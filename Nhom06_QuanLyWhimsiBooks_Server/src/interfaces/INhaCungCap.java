package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.NhaCungCap;

public interface INhaCungCap extends Remote{
	public List<NhaCungCap> getAllNhaCungCap() throws RemoteException;
	public List<NhaCungCap> getNCCByID(String maNCC) throws RemoteException;
	public List<NhaCungCap> getNCCByPhone(String sdt) throws RemoteException;
	public List<NhaCungCap> getNCCByEmail(String email) throws RemoteException;
	public List<NhaCungCap> getNCCByName(String name) throws RemoteException;
	public boolean addNhaCungCap(NhaCungCap ncc) throws RemoteException;
	public boolean editNhaCungCap(NhaCungCap ncc) throws RemoteException;
	public long layMaNCCCuoiCung() throws RemoteException;
	
}
