/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.TacGia;
import entities.ThuongHieu;
import interfaces.ITacGia;
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
public class TacGia_DAO implements  ITacGia{

    private Connection conn;
   
    public TacGia_DAO() {
        conn = ConnectDB.getConnection();
    }

    @Override
    public List<TacGia> getAllTacGia() {
       List<TacGia> list = new ArrayList<TacGia>();
		try {
			Statement stm = conn.createStatement();
			
			String query = "SELECT * FROM TacGia";
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				try {
					TacGia tacGia = new TacGia(rs.getInt("tacGiaID"), rs.getString("tenTacGia"), rs.getString("quocTich"));
					list.add(tacGia);
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
    public List<TacGia> getTacGiaTheoID(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addTacGia(TacGia x) {
        String tenTG = x.getTenTacGia();

        String insert = "INSERT INTO TacGia (TenTacGia) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString(1, tenTG);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editTacGia(TacGia x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
