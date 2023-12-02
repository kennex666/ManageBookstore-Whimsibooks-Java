package gui;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import connectDB.ConnectDB;
import java.util.Random;
import javax.swing.JOptionPane;
import utilities.CurrentSession;
import utilities.ErrorMessage;

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
            ConnectDB.getInstance().connect();
            if (ConnectDB.getConnection() == null) {
                Thread.sleep(300);
                sl.processBarUpdate(40, "Kết nối CSDL thất bại");
                if (!ErrorMessage.showConfirmDialogYesNo("Lỗi", "Kết nối CSDL lỗi, bạn có muôn tiếp tục?")) {
                    System.exit(500);
                }
                for (int i = 40; i < 80; i++) {
                    sl.processBarUpdate(i);
                }

                sl.processBarUpdate(80, "Tiến hành vào giao diện, bỏ qua kết nối csdl");
                GUI_MainMenu guiMain = new GUI_MainMenu();
                for (int i = 80; i < 101; i++) {
                    Thread.sleep(random(10, 50));

                    sl.processBarUpdate(i);
                }

                sl.dispose();
                guiMain.setVisible(true);

            } else {
                for (int i = 23; i < 40; i++) {
                    Thread.sleep(random(10, 50));
                    sl.processBarUpdate(i);
                }
                Thread.sleep(250);
                sl.processBarUpdate(40, "Kết nối cơ sở dữ liệu thành công");
                Thread.sleep(300);
                sl.processBarUpdate(40, "Đang cập nhật cơ sở dữ liệu");
                
                for (int i = 40; i < 46; i++) {
                    Thread.sleep(random(10, 50));
                    sl.processBarUpdate(i);
                }
                
                Thread.sleep(250);
                sl.processBarUpdate(46, "Thiết lập phiên hoạt động");
                Thread.sleep(300);
                for (int i = 46; i < 77; i++) {
                    Thread.sleep(random(10, 50));
                    sl.processBarUpdate(i);
                }
                
                CurrentSession.getInstance();
                Thread.sleep(250);
                sl.processBarUpdate(76, "Đã thiết lập phiên hoạt động");
                Thread.sleep(300);
                sl.processBarUpdate(76, "Đang khởi tạo giao diện đăng nhập");
                
                GUI_Login frame = new GUI_Login();
                for (int i = 76; i < 100; i++) {
                    Thread.sleep(random(10, 50));
                    sl.processBarUpdate(i);
                }
                
                Thread.sleep(500);
                sl.processBarUpdate(100, "Khởi động hoàn tất");
                Thread.sleep(500);

                sl.dispose();
                frame.setVisible(true);
            }
        } catch (Exception e) {
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
