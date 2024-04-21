package application;

import loader.SplashLoading;
import ultilities.CurrentSession;
import ultilities.EnviromentConfigs;
import ultilities.ErrorMessage;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import gui.GUI_Login;
import gui.GUI_MainMenu;

import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JOptionPane;

public class MainActivity {

	public static void main(String[] args) {

        /**
         * Connecting DataBase
         */
    	
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            SplashLoading sl = new SplashLoading();
            sl.setLocationRelativeTo(null);
            sl.setVisible(true);
            for (int i = 0; i < 10; i++) {
                Thread.sleep(random(10, 50));
                sl.processBarUpdate(i);
            }
            sl.processBarUpdate(10, "Khởi tạo tiến trình hoàn tất");
            Thread.sleep(250);
            sl.processBarUpdate(10, "Cập nhật tiến trình");

			Thread.sleep(500);
			for (int i = 10; i < 23; i++) {
				Thread.sleep(random(10, 50));
				sl.processBarUpdate(i);
			}

			sl.processBarUpdate(23, "Đã chạy tiến trình");
			Thread.sleep(250);
			sl.processBarUpdate(23, "Đang kết nối đến cơ sở dữ liệu");
			Thread.sleep(250);

			Context ctx = new InitialContext();
			Object test = null;
			
			boolean isChangeURL = false;
			do {
				try {
					test = ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI + "/chiTietHoaDon");
				} catch (Exception e) {
					// TODO: handle exception
					// Show input dialog
					if (JOptionPane.showConfirmDialog(null, "Không thể tìm thấy máy chủ " + EnviromentConfigs.URL_RMI + ", bạn có muốn đổi máy chủ?",
							"Lỗi kết nối cơ sở dữ liệu", JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
						String temp = JOptionPane.showInputDialog(null, "Nhập địa chỉ máy chủ mới (bao gồm port): ",
								"Thay đổi máy chủ", JOptionPane.INFORMATION_MESSAGE);
						if (temp != null && !temp.isEmpty() && !temp.isBlank())
								EnviromentConfigs.URL_RMI = temp;
						isChangeURL = true;
					}else {
						test = null;
						isChangeURL = false;
					}
				}
			} while (test == null && isChangeURL);

			if (test == null) {
				Thread.sleep(300);
				sl.processBarUpdate(40, "Kết nối CSDL thất bại");

				JOptionPane.showMessageDialog(null, "Kết nối CSDL lỗi, vui lòng kiểm tra lại kết nối mạng!", "Lỗi kết nối cơ sở dữ liệu",
						JOptionPane.ERROR_MESSAGE);
				
				System.exit(500);

			} else {
				for (int i = 23; i < 40; i++) {
					Thread.sleep(random(10, 30));
					sl.processBarUpdate(i);
				}
				Thread.sleep(250);
				sl.processBarUpdate(40, "Kết nối cơ sở dữ liệu thành công");
				Thread.sleep(300);
				sl.processBarUpdate(40, "Đang cập nhật cơ sở dữ liệu");

				for (int i = 40; i < 46; i++) {
					Thread.sleep(random(10, 20));
					sl.processBarUpdate(i);
				}

				Thread.sleep(250);
				sl.processBarUpdate(46, "Thiết lập phiên hoạt động");
				Thread.sleep(300);
				for (int i = 46; i < 77; i++) {
					Thread.sleep(random(10, 20));
					sl.processBarUpdate(i);
				}

				CurrentSession.getInstance();
				Thread.sleep(250);
				sl.processBarUpdate(76, "Đã thiết lập phiên hoạt động");
				Thread.sleep(300);
				sl.processBarUpdate(76, "Đang khởi tạo giao diện đăng nhập");

				GUI_Login frame = new GUI_Login();
				for (int i = 76; i < 100; i++) {
					Thread.sleep(random(10, 20));
					sl.processBarUpdate(i);
				}

				Thread.sleep(500);
				sl.processBarUpdate(100, "Khởi động hoàn tất");
				Thread.sleep(500);

				sl.dispose();
				frame.setVisible(true);
			}
		} catch (Exception e) {
			// get print stack trace from e
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, e, "Lỗi hệ thống", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static int random(int min, int max) {

		// Create an instance of Random
		Random random = new Random();

		// Generate a random number within the specified range
		return random.nextInt((max - min) + 1) + min;

		// Print the random number
	}
}
