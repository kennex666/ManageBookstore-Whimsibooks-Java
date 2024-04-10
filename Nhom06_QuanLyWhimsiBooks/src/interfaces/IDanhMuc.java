package interfaces;

import java.util.List;

import entities.DanhMuc;

public interface IDanhMuc {
	public List<DanhMuc> getAllDanhMuc();
	public List<DanhMuc> getDanhMucTheoID(int x);
	public boolean addDanhMuc(DanhMuc x);
	public boolean editDanhMuc (DanhMuc x);
}
