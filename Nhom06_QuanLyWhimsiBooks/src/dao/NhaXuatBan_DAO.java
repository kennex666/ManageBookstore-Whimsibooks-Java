/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.NhaXuatBan;
import interfaces.INhaXuatBan;
import jakarta.persistence.EntityManager;

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
public class NhaXuatBan_DAO implements INhaXuatBan{
    private Connection conn;
    private EntityManager em;

    public NhaXuatBan_DAO() {
       em = ConnectDB.getEntityManager();
    }
    
    
    
    @Override
    public List<NhaXuatBan> getAllNhaXuatBan() {
       List<NhaXuatBan> list = new ArrayList<NhaXuatBan>();
		
		try {
			list = em.createNamedQuery("NhaXuatBan.findAll").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
    }

    @Override
    public List<NhaXuatBan> getNhaXuatBanTheoID(String x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addNhaXuatBan(NhaXuatBan x) {
        try {
        	em.getTransaction().begin();
            em.persist(x);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editNhaXuatBan(NhaXuatBan x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
