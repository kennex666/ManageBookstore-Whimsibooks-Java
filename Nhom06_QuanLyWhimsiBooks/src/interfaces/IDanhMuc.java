package interfaces;

import java.util.ArrayList;

import entities.DanhMuc;

public interface IDanhMuc {
	public ArrayList<DanhMuc> getAllDanhMuc();
	public ArrayList<DanhMuc> getDanhMucTheoID(String x);
	public boolean addDanhMuc(DanhMuc x);
	public boolean editDanhMuc (DanhMuc x);
}
