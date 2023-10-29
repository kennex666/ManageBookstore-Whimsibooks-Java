package gui;

import java.awt.EventQueue;

import connectDB.ConnectDB;

public class MainActivity {
	public static void main(String[] args) {
		
		/**
		 * Connecting DataBase
		 */
		
		ConnectDB.getInstance().connect();
		
		/**
		 * Launch the application with login UI
		 */
		GUI_Login frame = new GUI_Login();
		frame.setVisible(true);
	}
}
