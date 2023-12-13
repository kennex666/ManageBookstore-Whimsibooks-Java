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
	private static JFrame jf;
	public static final String VERSION = "23.12.14";
        public static WindowTitle instance = new WindowTitle();
	
	public static String getTitleContent(String x) {
		return x + " - Nhà sách WhimsiBooks | " + VERSION;
	}
	
	public static void setTitle(String x) {
		jf.setTitle(getTitleContent(x));
	}

	public WindowTitle(JFrame jf) {
		super();
		this.jf = jf;
	}
        
        public WindowTitle() {
		super();
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}
        
        public static WindowTitle getInstance(){
            return instance;
        }

	@Override
	public String toString() {
		return "WindowTitle [jf=" + jf + "]";
	}
	
	
	
	
}
