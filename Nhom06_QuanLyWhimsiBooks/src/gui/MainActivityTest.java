package gui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

import connectDB.ConnectDB;
import dao.HangNhap_DAO;
import entities.DanhMuc;

public class MainActivityTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
		}
         GUI_MainMenu gui_Main = new GUI_MainMenu();
         gui_Main.setVisible(true);
         gui_Main.activateGUITest();
	}
}