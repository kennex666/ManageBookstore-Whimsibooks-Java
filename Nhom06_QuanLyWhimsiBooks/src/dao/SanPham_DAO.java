package dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import connectDB.ConnectDB;
import entities.DanhMuc;
import entities.KhuyenMai;
import entities.NhaCungCap;
import entities.NhaXuatBan;
import entities.SanPham;
import entities.TacGia;
import entities.TheLoai;
import entities.ThuongHieu;
import interfaces.ISanPham;
import jakarta.persistence.EntityManager;
import ultilities.Numberic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPham_DAO implements ISanPham {
	private final int LIMIT_RESULT = 100;
	private EntityManager em;

	// Lấy danh sách sản phẩm cho khuyến mãi
	public List<SanPham> laySanPhamChoKM() {
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			list = em.createNamedQuery("SanPham.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getSPTheoThuongHieu(String maThuongHieu) {
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			list = em.createNamedQuery("SanPham.findByThuongHieuID").setParameter("thuongHieuID", maThuongHieu)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ThuongHieu> getThuongHieu() {
		List<ThuongHieu> list = new ArrayList<ThuongHieu>();
		try {
			list = em.createNamedQuery("ThuongHieu.listThuongHieu").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SanPham> getDanhSachSanPham(String query) {
		List<SanPham> list = new ArrayList<SanPham>();

		try {

			list = em.createNativeQuery(query, SanPham.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}

		return list;
	}

	@Override
	public boolean addSanPham(SanPham sp) {
		try {
			em.persist(sp);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editSanPham(SanPham sp) {
		try {
			em.getTransaction().begin();
			em.merge(sp);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SanPham> getDanhSachSanPhamSapHet() {
		List<SanPham> list = new ArrayList<SanPham>();

		list = em.createNamedQuery("SanPham.getSanPhamSapHet").getResultList();
		return list;

	}

	public SanPham_DAO() {
		super();
		// TODO Auto-generated constructor stub
		em = ConnectDB.getEntityManager();
	}

	@Override
	public List<SanPham> searchSanPham(String sanPhamID) {
		List<SanPham> list;
		list = new ArrayList<SanPham>();

		list = em.createNamedQuery("SanPham.findById").setParameter("id", sanPhamID).getResultList();

		return list;
	}

	@Override
	public List<SanPham> getDanhSachSanPham() {
		List<SanPham> list = new ArrayList<>();
		list = em.createNamedQuery("SanPham.findAll").setMaxResults(LIMIT_RESULT).getResultList();
		return list;
	}

	@Override
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) {

		SanPham sanPham = null;
		int id = 0;
		try {

			if (x.length() > 5) {
				id = Numberic.parseInteger("-1");
			} else {
				id = Numberic.parseInteger(x);
			}

			sanPham = (SanPham) em.createNamedQuery("SanPham.findByIdAndBarcode").setParameter("id", id)
					.setParameter("barcode", x).getSingleResult();

			return sanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getIdTacGiaByName(String name) {
		try {

			TacGia tg = (TacGia) em.createNamedQuery("TacGia.findByName").setParameter("name", name).getSingleResult();
			if (tg != null)
				return tg.getTacGiaID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getIdTheloaiByName(String name) {
		try {
			TheLoai tl = (TheLoai) em.createNamedQuery("TheLoai.findByName").setParameter("name", name)
					.getSingleResult();
			if (tl != null)
				return tl.getTheLoaiID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getIdNhaXuatBanByName(String name) {
		try {
			NhaXuatBan nhaXuatBan = (NhaXuatBan) em.createNamedQuery("NhaXuatBan.findByName").setParameter("name", name)
					.getSingleResult();
			if (nhaXuatBan != null)
				return nhaXuatBan.getNhaXuatBanID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getIdNhaCungCapByName(String name) {
		try {
			NhaCungCap ncc = (NhaCungCap) em.createNamedQuery("NhaCungCap.findByName").setParameter("name", name)
					.getSingleResult();
			if (ncc != null)
				return ncc.getNhaCungCapID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int getIdThuongHieuByName(String name) {
		try {
			ThuongHieu th = (ThuongHieu) em.createNamedQuery("ThuongHieu.findByName").setParameter("name", name)
					.getSingleResult();
			if (th != null)
				return th.getThuongHieuID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getIdDanhMucByName(String name) {
		try {
			DanhMuc dm = (DanhMuc) em.createNamedQuery("DanhMuc.findByName").setParameter("name", name)
					.getSingleResult();
			if (dm != null)
				return dm.getDanhMucID();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getNameTacGiaByID(int ID) {
		try {
			TacGia tg = (TacGia) em.createNamedQuery("TacGia.findByID").setParameter("id", ID).getSingleResult();
			if (tg != null)
				return tg.getTenTacGia();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameNhaXuatBanByID(int ID) {
		try {
			NhaXuatBan nxb = (NhaXuatBan) em.createNamedQuery("NhaXuatBan.findByID").setParameter("id", ID)
					.getSingleResult();
			if (nxb != null)
				return nxb.getTenNhaXuatBan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameDanhMucByID(int ID) {
		try {
			DanhMuc dm = (DanhMuc) em.createNamedQuery("DanhMuc.findByID").setParameter("id", ID).getSingleResult();
			if (dm != null)
				return dm.getTenDanhMuc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameTheLoaiByID(int ID) {
		try {
			TheLoai tl = (TheLoai) em.createNamedQuery("TheLoai.findByID").setParameter("id", ID).getSingleResult();
			if (tl != null)
				return tl.getTenTheLoai();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameThuongHieuByID(int ID) {
		try {
			ThuongHieu th = (ThuongHieu) em.createNamedQuery("ThuongHieu.findByID").setParameter("id", ID)
					.getSingleResult();
			if (th != null)
				return th.getTenThuongHieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameNhaCungCapByID(String ID) {
		try {
			NhaCungCap ncc = (NhaCungCap) em.createNamedQuery("NhaCungCap.findByID").setParameter("id", ID)
					.getSingleResult();
			if (ncc != null)
				return ncc.getTenNhaCungCap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public boolean editTrangThaiSanPham(SanPham sp) {
		int id = sp.getSanPhamID();
		try {
			SanPham sp2 = em.find(SanPham.class, id);
			em.getTransaction().begin();
			sp2.setTinhTrang(sp.getTinhTrang());
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void SapXepTangTheoGia(List<SanPham> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham sp1, SanPham sp2) {
				if (sp1.getGiaBan() > sp2.getGiaBan()) {
					return 1;
				} else {
					if (sp1.getGiaBan() == sp2.getGiaBan()) {
						return 0;
					} else {
						return -1;
					}
				}
			}
		});

	}

	@Override
	public void SapXepGiamTheoGia(List<SanPham> list) {
		Collections.sort(list, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham sp1, SanPham sp2) {
				if (sp1.getGiaBan() < sp2.getGiaBan()) {
					return 1;
				} else {
					if (sp1.getGiaBan() == sp2.getGiaBan()) {
						return 0;
					} else {
						return -1;
					}
				}
			}
		});

	}

	@Override
	public void SapXepTangTheoSoLuong(List<SanPham> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham sp1, SanPham sp2) {
				if (sp1.getSoLuongTon() > sp2.getSoLuongTon()) {
					return 1;
				} else {
					if (sp1.getSoLuongTon() == sp2.getSoLuongTon()) {
						return 0;
					} else {
						return -1;
					}
				}
			}
		});

	}

}
