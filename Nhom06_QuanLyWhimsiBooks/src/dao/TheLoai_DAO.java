/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.TheLoai;
import entities.ThuongHieu;
import interfaces.ITheLoai;
import interfaces.IThuongHieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TheLoai_DAO implements ITheLoai{
    private Connection conn;
    public TheLoai_DAO() {
        conn = ConnectDB.getConnection();
    }

    @Override
    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> list = new ArrayList<TheLoai>();
		try {
			Statement stm = conn.createStatement();
			
			String query = "SELECT * FROM TheLoai";
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				try {
					TheLoai theLoai = new TheLoai(rs.getInt("theLoaiID"), rs.getString("tenTheLoai"));
					list.add(theLoai);
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
    public List<TheLoai> getTheLoaiTheoID(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addTheLoai(TheLoai x) {
        String tenTL = x.getTenTheLoai();

        String insert = "INSERT INTO TheLoai (TenTheLoai) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString(1, tenTL);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editTheLoai(TheLoai x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
