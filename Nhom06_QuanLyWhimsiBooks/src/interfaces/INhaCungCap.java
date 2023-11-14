package interfaces;

import java.util.ArrayList;

import entities.NhaCungCap;

public interface INhaCungCap {
	public ArrayList<NhaCungCap> getAllNhaCungCap();
	public String getNameByID(String maNCC);
	public String getNameByPhone(String sdt);
	public boolean addNhaCungCap(NhaCungCap ncc);
	public boolean editNhaCungCap(NhaCungCap ncc);
}
