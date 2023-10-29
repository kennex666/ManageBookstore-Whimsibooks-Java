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
import entities.HangNhap;
import entities.KhuyenMai;
import utilities.Test;

public class MainMenuTest {
	public static void main(String[] args) throws SQLException {
		ConnectDB.connect();
		HangNhap_DAO dao = new HangNhap_DAO();
		HangNhap hangNhap = dao.findHangNhap("HN111");
		System.out.println(hangNhap);
	}
}