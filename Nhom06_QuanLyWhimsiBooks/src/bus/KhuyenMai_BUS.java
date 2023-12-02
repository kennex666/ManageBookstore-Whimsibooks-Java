package bus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.KhuyenMai_DAO;
import entities.KhuyenMai;
import entities.NhaCungCap;
import entities.SanPham;
import interfaces.IKhuyenMai;

public class KhuyenMai_BUS implements IKhuyenMai{
	private KhuyenMai_DAO khuyenMai_DAO;
	private SanPham_BUS sanPham_BUS;
	
	public KhuyenMai_BUS() {
		this.khuyenMai_DAO = new KhuyenMai_DAO();
		this.sanPham_BUS = new SanPham_BUS();
	}
	
	public ArrayList<SanPham> laySanPhamTheoMa(String txt) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_BUS.getDanhSachSanPham("SELECT * FROM SanPham WHERE SanPhamID LIKE '%"+txt+"%'");
		return list;
	}
	
	public ArrayList<SanPham> laySanPhamTheoTen(String txt) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		list = sanPham_BUS.getDanhSachSanPham("SELECT * FROM SanPham WHERE SanPhamID LIKE '%"+txt+"%'");
		return list;
	}
	

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getKhuyenMaiByIDAndName(maKhuyenMai, tenKM);
	}
	
	public ArrayList<KhuyenMai> getKhuyenMaiTheoTen(String tenSK) {
		String query = "Select * from KhuyenMai WHERE TenKhuyenMai = '"+tenSK+"'";
		return khuyenMai_DAO.TimKiemKhuyenMaiTheoDieuKien(query);
	}
	
    public ArrayList<SanPham> laySanPhamDuocChon(JTable table) {
    	ArrayList<SanPham> dsSanPhamDuocChon = new ArrayList<SanPham>();
    	int rowCount = table.getRowCount();
    	if(rowCount != 0) {
    		for(int i = 0; i < rowCount; i++) {
    			boolean isSelected = (boolean) table.getModel().getValueAt(i, 0);
    			String maSanPham = table.getModel().getValueAt(i, 1).toString();
    			String tenSanPham = table.getModel().getValueAt(i, 2).toString();
    			if (isSelected) {
    			    SanPham sanPham = new SanPham(Integer.valueOf(maSanPham), tenSanPham);
    			    dsSanPhamDuocChon.add(sanPham);
    			}
    		}
    		return dsSanPhamDuocChon;
    	}
    	return null;
    }

	@Override
	public ArrayList<KhuyenMai> getAllKhuyenMai() {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getAllKhuyenMai();
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getKhuyenMaiByID(maKhuyenMai);
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getKhuyenMaiFollowDay(startDay, expriedDay);
	}

	@Override
	public boolean addKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.addKhuyenMai(khuyenMai);
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.editKhuyenMai(khuyenMai);
	}

	@Override
	public int layMaNCCCuoiCung() {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.layMaNCCCuoiCung();
	}

	
	public ArrayList<KhuyenMai> TimKiemTheoLoai(String hinhThuc) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		String queryTong = "SELECT * FROM KhuyenMai";
		String queryPhanTram = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Percentage'";
		String queryGiaTri = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Fixed'";
		if(hinhThuc.equals("ALL")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryTong);
		}
		if(hinhThuc.equals("Percentage")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		}
		if(hinhThuc.equals("Fixed")) {
			return list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		}
		return list = null;
	}
	
	public ArrayList<KhuyenMai> TimKiemTheoDieuKien(String ma,String loai) {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		String queryTong = "SELECT * FROM KhuyenMai";
		String queryma = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+ma+"%'";
		String querymagt = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+ma+"%' and LoaiGiamGia = 'Fixed'";
		String querymapt = "Select * from KhuyenMai WHERE CodeKhuyenMai like '%"+ma+"%' and LoaiGiamGia = 'Percentage'";
		String queryPhanTram = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Percentage'";
		String queryGiaTri = "SELECT * FROM KhuyenMai WHERE LoaiGiamGia = 'Fixed'";
		if(ma.length() > 0) {
			switch (loai) {
		    case "Tất cả":
		        list = TimKiemKhuyenMaiTheoDieuKien(queryma);
		        break;
		    case "Giá trị":
		        list = TimKiemKhuyenMaiTheoDieuKien(querymagt);
		        break;
		    case "Phần trăm":
		        list = TimKiemKhuyenMaiTheoDieuKien(querymapt);
		        break;
			}
		}
		else if(ma.length() <= 0) {
			switch (loai) {
		    case "Tất cả":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryTong);
		        break;
		    case "Giá trị":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryPhanTram);
		        break;
		    case "Phần trăm":
		    	list = TimKiemKhuyenMaiTheoDieuKien(queryGiaTri);
		        break;
			}
		}
		return list;
	}
        
        @Override
        public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai){
            return khuyenMai_DAO.getKhuyenMaiByCodeKMForSeller(maKhuyenMai);
        }
	
	@Override
	public ArrayList<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query) {
		return khuyenMai_DAO.TimKiemKhuyenMaiTheoDieuKien(query);
	}
	
	// Xuat file
	@Override
	public ArrayList<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getDanhSachKhuyenMaiNangCao(params);
	}
	
	public boolean xuatFile(ArrayList<KhuyenMai> list) {
	    JFileChooser excelFileChooser = new JFileChooser("D:\\");
	    excelFileChooser.setDialogTitle("Save Excel File");
	    FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xlsx");
	    excelFileChooser.setFileFilter(fnef);

	    int excelChooser = excelFileChooser.showSaveDialog(null);

	    if (excelChooser == JFileChooser.APPROVE_OPTION) {
	        File excelFile = excelFileChooser.getSelectedFile();

	        // Kiểm tra nếu tên file không kết thúc bằng ".xlsx", thêm ".xlsx" vào
	        if (!excelFile.getName().toLowerCase().endsWith(".xlsx")) {
	            excelFile = new File(excelFile.getParentFile(), excelFile.getName() + ".xlsx");
	        }

	        // Kiểm tra xem file đã tồn tại chưa
	        if (excelFile.exists()) {
	            int result = JOptionPane.showConfirmDialog(null,
	                    "File đã tồn tại. Bạn có muốn ghi đè lên file hiện tại không?", "Ghi đè",
	                    JOptionPane.YES_NO_OPTION);
	            if (result != JOptionPane.YES_OPTION) {
	                // Người dùng không muốn ghi đè, trả về false
	                return false;
	            }
	        }

	        try {
	            FileOutputStream fileOut = new FileOutputStream(excelFile);
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            XSSFSheet sheet = workbook.createSheet("Sheet1");

	            int rowNum = 1;
	            String[] title = {
	                    "Mã giảm giá", "Ngày tạo", "Ngày kích hoạt", "Ngày hết hạn ", "Hình thức giảm", "Đơn hàng từ" ,"Mức giảm giá"
	                };
                Row head = sheet.createRow(0);
                head.createCell(0).setCellValue(title[0]);
                head.createCell(1).setCellValue(title[1]);
                head.createCell(2).setCellValue(title[2]);
                head.createCell(3).setCellValue(title[3]);
                head.createCell(4).setCellValue(title[4]);
                head.createCell(5).setCellValue(title[5]);
                head.createCell(6).setCellValue(title[6]);
                
	            for (KhuyenMai km : list) {
	                Row row = sheet.createRow(rowNum++);
	                row.createCell(0).setCellValue(km.getCodeKhuyenMai());
	                row.createCell(1).setCellValue(utilities.GetToDay.today());
	                row.createCell(2).setCellValue(km.getNgayKhuyenMai()+"");
	                row.createCell(3).setCellValue(km.getNgayHetHanKM()+"");
	                row.createCell(4).setCellValue(km.getLoaiKhuyenMai());
	                row.createCell(5).setCellValue(km.getDonHangTu());
	                row.createCell(6).setCellValue(km.getGiaTri());
	            }

	            workbook.write(fileOut);
	            fileOut.close();
	            
	            // Thông báo thành công
	            JOptionPane.showMessageDialog(null, "Xuất file thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

	            return true;
	            
	        } catch (FileNotFoundException e) {
	            JOptionPane.showMessageDialog(null, "Lỗi: File không tìm thấy", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	    }
	    
	    // Người dùng đã hủy hoặc có lỗi, trả về false
	    return false;
	}
	
	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiByName(String name) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.getKhuyenMaiByName(name);
	}

	@Override
	public boolean deleteKhuyenMai(String codeKhuyenMai) {
		// TODO Auto-generated method stub
		return khuyenMai_DAO.deleteKhuyenMai(codeKhuyenMai);
	}



}
