package gui;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import connectDB.ConnectDB;
import utilities.CurrentSession;

public class MainActivity {
	public static void main(String[] args) {
		
		/**
		 * Connecting DataBase
		 */
		
		ConnectDB.getInstance().connect();
                
                CurrentSession.getInstance();
		try {
			UIManager.setLookAndFeel(new FlatMacLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
		}
		
		/**
		 * Launch the application with login UI
		 */
		GUI_Login frame = new GUI_Login();
		frame.setVisible(true);
	}
}
