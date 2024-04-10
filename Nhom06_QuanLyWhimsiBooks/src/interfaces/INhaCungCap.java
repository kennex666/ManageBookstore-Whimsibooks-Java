package interfaces;

import java.util.List;

import entities.NhaCungCap;

public interface INhaCungCap {
	public List<NhaCungCap> getAllNhaCungCap();
	public List<NhaCungCap> getNCCByID(String maNCC);
	public List<NhaCungCap> getNCCByPhone(String sdt);
	public List<NhaCungCap> getNCCByEmail(String email);
	public List<NhaCungCap> getNCCByName(String name);
	public boolean addNhaCungCap(NhaCungCap ncc);
	public boolean editNhaCungCap(NhaCungCap ncc);
	
}
