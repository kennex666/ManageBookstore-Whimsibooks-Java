/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entities.DanhMuc;
import entities.NhaXuatBan;
import interfaces.INhaXuatBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NhaXuatBan_DAO implements INhaXuatBan{
    private Connection conn;

    public NhaXuatBan_DAO() {
        this.conn = ConnectDB.getConnection();
    }
    
    
    
    @Override
    public ArrayList<NhaXuatBan> getAllNhaXuatBan() {
       ArrayList<NhaXuatBan> list = new ArrayList<NhaXuatBan>();
		
		try {
			Statement stm = conn.createStatement();
			
			String query = "SELECT * FROM NhaXuatBan";
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				try {
					NhaXuatBan nhaXuatBan = new NhaXuatBan(
                                                rs.getInt("nhaxuatbanid"), 
                                                rs.getString("tennhaxuatban"), 
                                                rs.getString("diachi"), 
                                                rs.getString("sodienthoai"), 
                                                rs.getString("email"), 
                                                rs.getString("website"), 
                                                rs.getInt("namthanhlap"),
                                                rs.getString("linhvucxuatban"), 
                                                rs.getString("quocgia"));
					list.add(nhaXuatBan);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return list;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
    }

    @Override
    public ArrayList<NhaXuatBan> getNhaXuatBanTheoID(String x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addNhaXuatBan(NhaXuatBan x) {
        		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO NhaXuatBan(tenNhaXuatBan) VALUES(?)";
			
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setString(1, x.getTenNhaXuatBan());
			
			int rs = pstm.executeUpdate();
			return (rs > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

    @Override
    public boolean editNhaXuatBan(NhaXuatBan x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
