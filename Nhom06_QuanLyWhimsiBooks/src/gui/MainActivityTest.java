package gui;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import connectDB.ConnectDB;
import ultilities.CurrentSession;

public class MainActivityTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
		}
        ConnectDB.connect();
                
         CurrentSession.getInstance();
         GUI_MainMenu gui_Main = new GUI_MainMenu();
         gui_Main.setVisible(true);
         gui_Main.activateGUITest();
	}
}