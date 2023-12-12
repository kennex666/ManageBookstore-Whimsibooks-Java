package utilities;

public class ProcessingEnumDBForQuy {
	public static String convertNhanVienRolesToEnum(String chucVu) {
		if (chucVu.equalsIgnoreCase("nhân viên cũ"))
			return "NHAN_VIEN_CU";
		if (chucVu.equalsIgnoreCase("nhân viên bán hàng"))
			return "NHAN_VIEN_BAN_HANG";
		return "NGUOI_QUAN_LY";
	}
	public static String convertEnumToNhanVienRoles(String chucVu) {
		// TODO Auto-generated method stub
		if (chucVu.equalsIgnoreCase("NHAN_VIEN_CU"))
			return "Nhân viên cũ";
		if (chucVu.equalsIgnoreCase("NHAN_VIEN_BAN_HANG"))
			return "Nhân viên bán hàng";
		return "Người quản lý";

	}
}
