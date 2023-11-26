package bus;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.NhaCungCap_DAO;
import entities.NhaCungCap;
import interfaces.INhaCungCap;

public class NhaCungCap_BUS implements INhaCungCap{
	private NhaCungCap_DAO ncc_DAO;

	@Override
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		// TODO Auto-generated method stub
		return ncc_DAO.getAllNhaCungCap();
	}

	@Override
	public ArrayList<NhaCungCap> getNCCByID(String maNCC) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNCCByID(maNCC);
	}

	@Override
	public ArrayList<NhaCungCap> getNCCByPhone(String sdt) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNCCByPhone(sdt);
	}
	
	@Override
	public ArrayList<NhaCungCap> getNCCByName(String name) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNCCByName(name);
	}	

	@Override
	public boolean addNhaCungCap(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return ncc_DAO.addNhaCungCap(ncc);
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return ncc_DAO.editNhaCungCap(ncc);
	}

	public int layMaNCCCuoiCung() {
		return	ncc_DAO.layMaNCCCuoiCung();
	}

	public NhaCungCap_BUS() {
		this.ncc_DAO = new NhaCungCap_DAO();
	}
	

	@Override
	public ArrayList<NhaCungCap> getNCCByEmail(String email) {
		// TODO Auto-generated method stub
		return ncc_DAO.getNCCByEmail(email);
	}
	
	
	// kiểm tra tên viết hoa viêt thường
	public boolean containsIgnoreCase(String str, String subStr) {
	    return str.toLowerCase().contains(subStr.toLowerCase());
	}

	public ArrayList<NhaCungCap> getNhaCungCapTheoDieuKien(String ma, String sdt, String ten) {
		ArrayList<NhaCungCap> danhSachTimKiem = new ArrayList<NhaCungCap>();
		if(!ma.isEmpty()) {
			for(NhaCungCap ncc : getAllNhaCungCap()) {
				if(containsIgnoreCase(ncc.getNhaCungCapID(), ma))
					danhSachTimKiem.add(ncc);
			}
		}
		if(!sdt.isEmpty()) {
			for(NhaCungCap ncc : getAllNhaCungCap()) {
				if(containsIgnoreCase(ncc.getSoDienThoai(), sdt))
					danhSachTimKiem.add(ncc);
			}
			if(!ma.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getSoDienThoai(), sdt) && containsIgnoreCase(ncc.getNhaCungCapID(), ma) )
        				danhSachTimKiem.add(ncc);
        		}
			}
		}
		if(!ten.isEmpty()) {
			for(NhaCungCap ncc : getAllNhaCungCap()) {
				if(containsIgnoreCase(ncc.getTenNhaCungCap(), ten) )
					danhSachTimKiem.add(ncc);
			}
			if(!ma.isEmpty() && !sdt.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getSoDienThoai(), sdt) && containsIgnoreCase(ncc.getNhaCungCapID(), ma) && containsIgnoreCase(ncc.getTenNhaCungCap(), ten))
        				danhSachTimKiem.add(ncc);
        		}
			}
			else if(!ma.isEmpty() && sdt.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getNhaCungCapID(), ma) && containsIgnoreCase(ncc.getTenNhaCungCap(), ten))
        				danhSachTimKiem.add(ncc);
        		}
			}
			else if(ma.isEmpty() && !sdt.isEmpty()) {
				danhSachTimKiem.clear();
				for(NhaCungCap ncc : getAllNhaCungCap()) {
        			if(containsIgnoreCase(ncc.getSoDienThoai(), sdt) && containsIgnoreCase(ncc.getTenNhaCungCap(), ten))
        				danhSachTimKiem.add(ncc);
        		}
			}
		}
		return danhSachTimKiem;
	}
	
    private String phatSinhMaNhaCungCap() {
		try {
			String maNhaCungCap = "NCC" + String.format("%05d", layMaNCCCuoiCung() + 1);
			return maNhaCungCap;
		} catch (NullPointerException e) {
			return "NCC" + "00001";
		}
	}
	
	public void nhapFile() {
		int count = 0;
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        
        String defaultCurrentDirectoryPath = "D:\\";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
			try {
				excelFile = excelFileChooser.getSelectedFile();
		        
		        excelFIS = new FileInputStream(excelFile);
				excelBIS = new BufferedInputStream(excelFIS);
				XSSFWorkbook workbook = new XSSFWorkbook(excelBIS);
				XSSFSheet datatypeSheet = workbook.getSheetAt(0);
	
				
				Iterator<Row> iterator = datatypeSheet.iterator();
				Row firstRow = iterator.next();
				Cell firstCell = firstRow.getCell(0);
				while (iterator.hasNext()) {
					Row currentRow = iterator.next();
					NhaCungCap ncc = new NhaCungCap();
					if(getNCCByEmail(currentRow.getCell(2).getStringCellValue()) == null && getNCCByPhone(currentRow.getCell(1).getStringCellValue()) == null) {
					ncc.setNhaCungCapID(phatSinhMaNhaCungCap());
					ncc.setTenNhaCungCap(currentRow.getCell(0).getStringCellValue());
					ncc.setSoDienThoai(currentRow.getCell(1).getStringCellValue());;
					ncc.setEmail(currentRow.getCell(2).getStringCellValue());;
					ncc.setDiaChi(currentRow.getCell(3).getStringCellValue());
					addNhaCungCap(ncc);
					}
					else {
						count++;
					}
				}
				if(count == 0) {
					JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
				}
				else {
					JOptionPane.showMessageDialog(null, "Imported thành công đã xóa "+count+" nhà cung cấp bị trùng !!.....");
				}
				workbook.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

	public void xuatFile(ArrayList<NhaCungCap> list) {
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

	        try {
	            FileOutputStream fileOut = new FileOutputStream(excelFile);
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            XSSFSheet sheet = workbook.createSheet("Sheet1");

	            // Code để ghi dữ liệu vào workbook
	            // Ví dụ: Ghi dữ liệu từ danh sách NhaCungCap vào các dòng của sheet
	            int rowNum = 0;
	            for (NhaCungCap ncc : list) {
	                Row row = sheet.createRow(rowNum++);
	                row.createCell(0).setCellValue(ncc.getTenNhaCungCap());
	                row.createCell(1).setCellValue(ncc.getSoDienThoai());
	                row.createCell(2).setCellValue(ncc.getEmail());
	                row.createCell(3).setCellValue(ncc.getDiaChi());
	            }

	            workbook.write(fileOut);
	            fileOut.close();
	            JOptionPane.showMessageDialog(null, "Exported Successfully !!.....");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
