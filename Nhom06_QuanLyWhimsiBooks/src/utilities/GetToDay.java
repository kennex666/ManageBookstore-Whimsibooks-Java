package utilities;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GetToDay {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static DecimalFormat fmt = new DecimalFormat("###,###");
    
	public static String today() {
		Date ngayHienTai = new Date();
		return sdf.format(ngayHienTai);
	}
	
}
