package interfaces;

import java.util.ArrayList;

import entities.NhaCungCap;

public interface INhaCungCap {
	public ArrayList<NhaCungCap> getAllNhaCungCap();
	public ArrayList<NhaCungCap> getNCCByID(String maNCC);
	public ArrayList<NhaCungCap> getNCCByPhone(String sdt);
	public ArrayList<NhaCungCap> getNCCByEmail(String email);
	public ArrayList<NhaCungCap> getNCCByName(String name);
	public boolean addNhaCungCap(NhaCungCap ncc);
	public boolean editNhaCungCap(NhaCungCap ncc);
	
}
