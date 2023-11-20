package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Numberic;

public class SanPham_DAO implements ISanPham{

	private Connection conn;
	
	// Lấy danh sách sản phẩm cho khuyến mãi
	public ArrayList<SanPham> laySanPhamChoKM() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			Statement stm =  conn.createStatement();
			String query = "SELECT * FROM SanPham";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					SanPham sanPham = new SanPham(rs.getInt("SanPhamID"),rs.getString("TenSanPham"),rs.getInt("SoLuongTon"),rs.getString("ImgPath"));
					list.add(sanPham);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<SanPham> getSPTheoThuongHieu(String maThuongHieu) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			Statement stm =  conn.createStatement();
			String query = "Select * from [dbo].[SanPham] where ThuongHieuID = '"+maThuongHieu+"'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					SanPham sanPham = new SanPham(rs.getInt("SanPhamID"),rs.getString("TenSanPham"),rs.getInt("SoLuongTon"),rs.getString("ImgPath"));
					list.add(sanPham);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<ThuongHieu> getThuongHieu() {
		ArrayList<ThuongHieu> list = new ArrayList<ThuongHieu>();
		try {
			Statement stm =  conn.createStatement();
			String query = "Select * from [dbo].[ThuongHieu]";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					ThuongHieu thuongHieu = new ThuongHieu(rs.getInt("ThuongHieuID"),rs.getString("TenThuongHieu"));
					list.add(thuongHieu);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<SanPham> getDanhSachSanPham(String query) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		
		try {
			Statement stm = conn.createStatement();
			
			//query = "SELECT * FROM SanPham";
			
			TacGia tg = new TacGia();
			NhaCungCap ncc = new NhaCungCap();
			TheLoai tl = new TheLoai();
			NhaXuatBan nxb = new NhaXuatBan();
			DanhMuc dm = new DanhMuc();
			ThuongHieu th = new ThuongHieu();
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				try {
					int sanphamid = rs.getInt("sanphamid");
					int soLuongTon = rs.getInt("soluongton");
					int namsx = rs.getInt("namsanxuat"); 
					int sotrang = rs.getInt("sotrang"); 
					Date ngaynhap =  rs.getDate("ngaynhap"); 
					double gianhap = rs.getDouble("gianhap"); 
					double thue = rs.getDouble("thue"); 
					String tensanpham = rs.getString("tensanpham"); 
					String loaidoitra = rs.getString("loaidoitra");
					String barcode = rs.getString("barcode"); 
					String img = rs.getString("imgpath"); 
					String tinhtrang = rs.getString("tinhtrang"); 
					String loaisanpham = rs.getString("loaisanpham"); 
					String donvidoluong = rs.getString("donvidoluong"); 
					String kichthuoc = rs.getString("kichthuoc"); 
					String xuatxu = rs.getString("xuatxu"); 
					String ngongu = rs.getString("ngonngu"); 
					String loaibia = rs.getString("loaibia"); 
					
					int tacgiaid = rs.getInt("tacgiaid"); 
					int theloaiid = rs.getInt("theloaiid"); 
					int nhaxuatbanid = rs.getInt("nhaxuatbanid"); 
					int thuonghieuid = rs.getInt("thuonghieuid"); 
					int danhmucid = rs.getInt("danhmucid"); 
					String nhacungcapid = rs.getString("nhacungcapid");
					
					tg.setTacGiaID(tacgiaid);
					tl.setTheLoaiID(theloaiid);
					nxb.setNhaXuatBanID(nhaxuatbanid);
					th.setThuongHieuID(thuonghieuid);
					dm.setDanhMucID(danhmucid);
					ncc.setNhaCungCapID(nhacungcapid);
					
					
//					tg.setTacGiaID(1);
//					tl.setTheLoaiID(1);
//					nxb.setNhaXuatBanID(1);
//					th.setThuongHieuID(1);
//					dm.setDanhMucID(1);
//					ncc.setNhaCungCapID("1");
					
					SanPham sanPham = new SanPham(sanphamid, soLuongTon, namsx, 
							 sotrang, ngaynhap, gianhap, thue, tensanpham, 
							loaidoitra, barcode, img, tinhtrang, loaisanpham, donvidoluong, 
							kichthuoc, xuatxu, ngongu, loaibia,
							tg, tl, nxb, th, dm, ncc);
					list.add(sanPham);
					
//					SanPham sanPham = new SanPham(sanphamid, soLuongTon, namsx, 
//							daban, 2, ngaynhap, dongia, thue, tensanpham, 
//							loaidoitra, "abc", img, tinhtrang, loaisanpham, donvidoluong, 
//							kichthuoc, xuatxu, ngongu, loaibia,
//							tg, tl, nxb, th, dm, ncc);
//					list.add(sanPham);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return list;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
	}
	

	@Override
	public boolean addSanPham(SanPham sp) {
		try {
			String sql = "INSERT INTO SanPham(TenSanPham, NgayNhap, GiaNhap, Thue, "
					+ "LoaiDoiTra, Barcode, ImgPath, TinhTrang, SoLuongTon, NamSanXuat, "
					+ "LoaiSanPham, DonViDoLuong, KichThuoc, XuatXu, NgonNgu, "
					+ "SoTrang, LoaiBia, TacGiaID, NhaCungCapID, TheLoaiID, NhaXuatBanID, DanhMucID, ThuongHieuID)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {

                            
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, sp.getTenSanPham());
				pstm.setDate(2, (Date) sp.getNgayNhap());
				pstm.setDouble(3, sp.getGiaNhap());
				pstm.setDouble(4, sp.getThue());
				pstm.setString(5, sp.getLoaiDoiTra());
				pstm.setString(6, sp.getBarcode());
				pstm.setString(7, sp.getImgPath());
				pstm.setString(8, sp.getTinhTrang());
				pstm.setInt(9, sp.getSoLuongTon());
				pstm.setInt(10, sp.getNamSanXuat());
				pstm.setString(11,  sp.getLoaiSanPham());
				pstm.setString(12, sp.getDonViDoLuong());
				pstm.setString(13, sp.getKichThuoc());
				pstm.setString(14, sp.getXuatXu());
				pstm.setString(15, sp.getNgonNgu());
				pstm.setInt(16, sp.getSoTrang());
				pstm.setString(17, sp.getLoaiBia());
                                pstm.setInt(18, sp.getTacGia().getTacGiaID());
                                pstm.setString(19, sp.getNhaCungCap().getNhaCungCapID());
                                pstm.setInt(20, sp.getTheLoai().getTheLoaiID());
                                pstm.setInt(21, sp.getNhaXuatBan().getNhaXuatBanID());
                                pstm.setInt(22, sp.getDanhMuc().getDanhMucID());
                                pstm.setInt(23, sp.getThuongHieu().getThuongHieuID());
                                
				return(pstm.executeUpdate()>0)?true:false;
				
			} catch (Exception e) {
				e.printStackTrace();
//				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi");
		}
		return false;
	}

	@Override
	public boolean editSanPham(SanPham sp) {
		int id = sp.getSanPhamID();
		try {			
				
			String sql = "UPDATE SanPham "
					+ "SET  TenSanPham = ?, NgayNhap  = ?, GiaNhap = ?, Thue = ?, LoaiDoiTra = ?,"
					+ "Barcode = ?, ImgPath = ?, TinhTrang = ?, SoLuongTon = ?, NamSanXuat = ?, LoaiSanPham = ?,"
					+ "DonViDoLuong = ?, KichThuoc = ?, XuatXu = ?, NgonNgu = ?, SoTrang = ?, LoaiBia = ? WHERE SanPhamID = ?";

			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, sp.getTenSanPham());
				pstm.setDate(2, (Date) sp.getNgayNhap());
				pstm.setDouble(3, sp.getGiaNhap());
				pstm.setDouble(4, sp.getThue());
				pstm.setString(5, sp.getLoaiDoiTra());
				pstm.setString(6, sp.getBarcode());
				pstm.setString(7, sp.getImgPath());
				pstm.setString(8, sp.getTinhTrang());
				pstm.setInt(9, sp.getSoLuongTon());
				pstm.setInt(10, sp.getNamSanXuat());
				pstm.setString(11,  sp.getLoaiSanPham());
				pstm.setString(12, sp.getDonViDoLuong());
				pstm.setString(13, sp.getKichThuoc());
				pstm.setString(14, sp.getXuatXu());
				pstm.setString(15, sp.getNgonNgu());
				pstm.setInt(16, sp.getSoTrang());
				pstm.setString(17, sp.getLoaiBia());
				pstm.setInt(18, id);
				return(pstm.executeUpdate()>0)?true:false;
			} catch (Exception e) {
				e.printStackTrace();
//				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi");
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<SanPham> getDanhSachSanPhamSapHet() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		
		//Statement stm = conn.createStatement();
		String query = "SELECT * FROM SanPham WHERE SoLuongTon <= 10";
		
		list = getDanhSachSanPham(query);
		return list;		
		
	}

	public SanPham_DAO() {
		super();
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}


	@Override
	public ArrayList<SanPham> searchSanPham(String sanPhamID) {
		ArrayList<SanPham> list;
		list = new ArrayList<SanPham>();
		
		//Statement stm = conn.createStatement();
		String query = "SELECT * FROM SanPham WHERE SanPhamID = " + sanPhamID;
		
		list = getDanhSachSanPham(query);
		return list;
	}


	@Override
	public ArrayList<SanPham> getDanhSachSanPham() {
		ArrayList<SanPham> list = new ArrayList<>();
		String query = "SELECT * FROM SANPHAM";
		list = getDanhSachSanPham(query);
		return list;
	}
	
	@Override
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) {
		
		SanPham sanPham = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(
				"SELECT * FROM SanPham WHERE SanPhamID = ? OR barcode = ?"
			);
			
			TacGia tg = new TacGia();
			NhaCungCap ncc = new NhaCungCap();
			TheLoai tl = new TheLoai();
			NhaXuatBan nxb = new NhaXuatBan();
			DanhMuc dm = new DanhMuc();
			ThuongHieu th = new ThuongHieu();
			
			
			pstm.setInt(1, Numberic.parseInteger(x));
			pstm.setString(2, x);
			
			ResultSet rs = pstm.executeQuery();
			
			rs.next();
			int sanphamid = rs.getInt("sanphamid");
			int soLuongTon = rs.getInt("soluongton");
			int namsx = rs.getInt("namsanxuat"); 
			int sotrang = rs.getInt("sotrang"); 
			Date ngaynhap =  rs.getDate("ngaynhap"); 
			double gianhap = rs.getDouble("gianhap"); 
			double thue = rs.getDouble("thue"); 
			String tensanpham = rs.getString("tensanpham"); 
			String loaidoitra = rs.getString("loaidoitra");
			String barcode = rs.getString("barcode"); 
			String img = rs.getString("imgpath"); 
			String tinhtrang = rs.getString("tinhtrang"); 
			String loaisanpham = rs.getString("loaisanpham"); 
			String donvidoluong = rs.getString("donvidoluong"); 
			String kichthuoc = rs.getString("kichthuoc"); 
			String xuatxu = rs.getString("xuatxu"); 
			String ngongu = rs.getString("ngonngu"); 
			String loaibia = rs.getString("loaibia"); 
					
			int tacgiaid = rs.getInt("tacgiaid"); 
			int theloaiid = rs.getInt("theloaiid"); 
			int nhaxuatbanid = rs.getInt("nhaxuatbanid"); 
			int thuonghieuid = rs.getInt("thuonghieuid"); 
			int danhmucid = rs.getInt("danhmucid"); 
			String nhacungcapid = rs.getString("nhacungcapid");
					
			tg.setTacGiaID(tacgiaid);
			tl.setTheLoaiID(theloaiid);
			nxb.setNhaXuatBanID(nhaxuatbanid);
			th.setThuongHieuID(thuonghieuid);
			dm.setDanhMucID(danhmucid);
			ncc.setNhaCungCapID(nhacungcapid);
					
			sanPham = new SanPham(sanphamid, soLuongTon, namsx, 
						 sotrang, ngaynhap, gianhap, thue, tensanpham, 
							loaidoitra, barcode, img, tinhtrang, loaisanpham, donvidoluong, 
							kichthuoc, xuatxu, ngongu, loaibia,
							tg, tl, nxb, th, dm, ncc);
			return sanPham;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

    @Override
    public int getIdTacGiaByName(String name) {
        try {
                	
		String query = "SELECT TacGiaID FROM TacGia WHERE TenTacGia = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("TacGiaID");
                    return id;
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
	return -1;		
    }

    @Override
    public int getIdTheloaiByName(String name) {
        try {
                String query = "SELECT TheLoaiID FROM TheLoai WHERE TenTheLoai = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("TheLoaiID");
                    return id;
                }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
	return -1;
    }

    @Override
    public int getIdNhaXuatBanByName(String name) {
        try {
                String query = "SELECT NhaXuatBanID FROM NhaXuatban WHERE TenNhaXuatBan = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("NhaXuatBanID");
                    return id;
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
	return -1;
    }

    @Override
    public String getIdNhaCungCapByName(String name) {
         try {
                String query = "SELECT NhaCungCapID FROM NhaCungCap WHERE TenNhaCungCap = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String id = rs.getString("NhaCungCapID");
                    return id;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }

    @Override
    public int getIdThuongHieuByName(String name) {
         try {
                String query = "SELECT ThuongHieuID FROM ThuongHieu WHERE TenThuongHieu = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("ThuongHieuID");
                    return id;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return -1;
    }

    @Override
    public int getIdDanhMucByName(String name) {
       try {
                String query = "SELECT NhaXuatBanID FROM NhaXuatban WHERE TenNhaXuatBan = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("NhaXuatBanID");
                    return id;
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
	return -1;
    }

    @Override
    public String getNameTacGiaByID(int ID) {
        try {
                String query = "SELECT TenTacGia FROM TacGia WHERE TacGiaID = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setInt(1, ID);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString("TenTacGia");
                    return name;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }

    @Override
    public String getNameNhaXuatBanByID(int ID) {
          try {
                String query = "SELECT TenNhaXuatBan FROM NhaXuatBan WHERE NhaXuatBanID = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setInt(1, ID);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString("TenNhaXuatBan");
                    return name;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }

    @Override
    public String getNameDanhMucByID(int ID) {
         try {
                String query = "SELECT TenDanhMuc FROM DanhMuc WHERE DanhMucID = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setInt(1, ID);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString("TenDanhMuc");
                    return name;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }

    @Override
    public String getNameTheLoaiByID(int ID) {
        try {
                String query = "SELECT TenTheLoai FROM TheLoai WHERE TheLoaiID = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setInt(1, ID);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString("TenTheLoai");
                    return name;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }

    @Override
    public String getNameThuongHieuByID(int ID) {
         try {
                String query = "SELECT TenThuongHieu FROM ThuongHieu WHERE ThuongHieuID = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setInt(1, ID);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString("TenThuongHieu");
                    return name;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }

    @Override
    public String getNameNhaCungCapByID(String ID) {
         try {
                String query = "SELECT TenNhaCungCap FROM NhaCungCap WHERE NhaCungCapID = ?";
                PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, ID);
                ResultSet rs = pstm.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString("TenNhaCungCap");
                    return name;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
	return "";
    }


        
	
}
