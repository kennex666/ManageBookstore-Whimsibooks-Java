/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.ThuongHieu;
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
public class ThuongHieu_DAO implements IThuongHieu {

    private Connection conn;

    @Override
    public List<ThuongHieu> getAllThuongHieu() {
        List<ThuongHieu> list = new ArrayList<ThuongHieu>();
        try {
            Statement stm = conn.createStatement();

            String query = "SELECT * FROM ThuongHieu";

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                try {
                    ThuongHieu thuongHieu = new ThuongHieu(rs.getInt("thuongHieuID"), rs.getString("tenThuongHieu"));
                    list.add(thuongHieu);
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
    public List<ThuongHieu> getThuongHieuTheoID(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addThuongHieu(ThuongHieu x) {
        String tenTH = x.getTenThuongHieu();

        String insert = "INSERT INTO ThuongHieu (TenThuongHieu) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString(1, tenTH);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editThuongHieu(ThuongHieu x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ThuongHieu_DAO() {
        conn = ConnectDB.getConnection();
    }

}
