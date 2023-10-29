package gui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import connectDB.ConnectDB;
import dao.HangNhap_DAO;
import entities.DanhMuc;

public class MainActivityTest {
	public static void main(String[] args) {
         GUI_MainMenu gui_Main = new GUI_MainMenu();
         gui_Main.setVisible(true);
		
	}
}