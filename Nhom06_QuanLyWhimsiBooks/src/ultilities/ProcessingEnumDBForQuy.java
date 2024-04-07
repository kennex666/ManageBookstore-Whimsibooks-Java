package ultilities;

public class ProcessingEnumDBForQuy {
	public static String convertNhanVienRolesToEnum(String chucVu) {
		if (chucVu.isBlank())
			return "";
		if (chucVu.equalsIgnoreCase("nhân viên cũ"))
			return "NHAN_VIEN_CU";
		if (chucVu.equalsIgnoreCase("nhân viên bán hàng"))
			return "NHAN_VIEN_BAN_HANG";
		return "NGUOI_QUAN_LY";
	}
	public static String convertEnumToNhanVienRoles(String chucVu) {
		// TODO Auto-generated method stub
		if (chucVu.isBlank())
			return "";
		if (chucVu.equalsIgnoreCase("NHAN_VIEN_CU"))
			return "Nhân viên cũ";
		if (chucVu.equalsIgnoreCase("NHAN_VIEN_BAN_HANG"))
			return "Nhân viên bán hàng";
		return "Người quản lý";

	}
        
        public static String convertEnumToKhachHang(String loai){
    		if (loai.isBlank())
    			return "";
            if (loai.equals("CA_NHAN"))
                return "Cá nhân";
            return "Doanh nghiệp";
        }
        
        public static String convertKhachHangToEnum(String loai){
    		if (loai.isBlank())
    			return "";
            if (loai.equals("Cá nhân"))
                return "CA_NHAN";
            return "DOANH_NGHIEP";
        }
        
        public static String gioiTinhToEnum(String gt){
    		if (gt.isBlank())
    			return "";
            return gt.equalsIgnoreCase("nam") ? "NAM" : "NU";
        }
        
        public static String enumToGioiTinh(String gt){
    		if (gt.isBlank())
    			return "";
            return gt.equalsIgnoreCase("NAM") ? "Nam" : "Nữ";
        }
}
