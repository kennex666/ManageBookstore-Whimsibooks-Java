package utilities;

import javax.swing.JFrame;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 * @description: 
 * 				1. Tạo tiêu đề cố định, thay đổi liên tục
 * 				2. Tạo content có kèm version
 *
 */

public class WindowTitle {
	private JFrame jf;
	public static final String VERSION = "1.0.0 (Test)";
	
	public static String getTitleContent(String x) {
		return x + " - Nhà sách WhimsiBooks | " + VERSION;
	}
	
	public void setTitle() {
		
	}

	public WindowTitle(JFrame jf) {
		super();
		this.jf = jf;
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	@Override
	public String toString() {
		return "WindowTitle [jf=" + jf + "]";
	}
	
	
	
	
}
